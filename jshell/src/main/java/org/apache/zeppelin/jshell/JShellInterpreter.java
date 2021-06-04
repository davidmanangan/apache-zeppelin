/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.zeppelin.jshell;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.zeppelin.interpreter.ZeppelinContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.PipedOutputStream;
import java.io.PipedInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.zeppelin.interpreter.InterpreterContext;
import org.apache.zeppelin.interpreter.InterpreterException;
import org.apache.zeppelin.interpreter.InterpreterResult;
import org.apache.zeppelin.interpreter.InterpreterResult.Code;
import org.apache.zeppelin.interpreter.KerberosInterpreter;
import org.apache.zeppelin.scheduler.Scheduler;
import org.apache.zeppelin.scheduler.SchedulerFactory;

/**
 * Shell interpreter for Zeppelin.
 */
public class JShellInterpreter extends KerberosInterpreter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JShellInterpreter.class);

    private static final String TIMEOUT_PROPERTY = "jshell.command.timeout.millisecs";
    private static final String DEFAULT_TIMEOUT = "60000";
    private static final String DIRECTORY_USER_HOME = "jshell.working.directory.user.home";

    private final boolean isWindows = System.getProperty("os.name").startsWith("Windows");
    private final String shell = isWindows ? "cmd /c" : "bash -c";
    ConcurrentHashMap<String, DefaultExecutor> executors;

    public JShellInterpreter(Properties property) {
        super(property);
    }

    @Override
    public void open() {
        super.open();
        executors = new ConcurrentHashMap<>();
        LOGGER.info("Command timeout property: {}", getProperty(TIMEOUT_PROPERTY));
    }

    @Override
    public void close() {
        super.close();
        for (String executorKey : executors.keySet()) {
            DefaultExecutor executor = executors.remove(executorKey);
            if (executor != null) {
                try {
                    executor.getWatchdog().destroyProcess();
                } catch (Exception e){
                    LOGGER.error("error destroying executor for paragraphId: " + executorKey, e);
                }
            }
        }
    }

    @Override
    protected boolean isInterpolate() {
        return Boolean.parseBoolean(getProperty("zeppelin.jshell.interpolation", "false"));
    }

    @Override
    public ZeppelinContext getZeppelinContext() {
        return null;
    }

    @Override
    public InterpreterResult internalInterpret(String cmd,
                                               InterpreterContext context) {
        LOGGER.debug("Run shell command '{}'", cmd);

        /*
        TODO: replace block below to allow processing of multiple statements separated by ';' in jshell
         */
        // the Windows CMD shell doesn't handle multiline statements,
        // they need to be delimited by '&&' instead
        //if (isWindows) {
        //    String[] lines = StringUtils.split(cmd, "\n");
        //    cmd = StringUtils.join(lines, " && ");
        //}

        try {
            PipedOutputStream stdin = new PipedOutputStream();
            PipedInputStream stdout = new PipedInputStream();
            //stdin.connect(stdout);                              // - pipe STDOUT of first process to STDIN of second process
            //
            ////place script inside echo command
            //String jshellScript = "echo '{{}}'";
            //jshellScript = jshellScript.replace("{{}}",cmd);
            //
            ////First Process: bash -c
            //CommandLine commandLine =
            //        new CommandLine("/bin/bash")
            //                .addArguments(new String[] {"-c", jshellScript},false);
            //
            //DefaultExecutor executor = new DefaultExecutor();
            //executor.setStreamHandler(new PumpStreamHandler(stdin));
            //executor.execute(commandLine,new DefaultExecuteResultHandler());

            /**
             * Run Shell Command
             */

            //Second process: jshell > append in line below: .addArgument("-q");
            //CommandLine commandLine2 = new CommandLine("jshell");
            CommandLine commandLine2 =
                    new CommandLine("/bin/bash")
                            .addArguments(new String[] {"-c", "jshell"},false);

            DefaultExecutor executor2 = new DefaultExecutor();
            executor2.setStreamHandler(
                    new PumpStreamHandler(System.out, System.err, stdout));

            executor2.setWatchdog(new ExecuteWatchdog(
                    Long.valueOf(getProperty(TIMEOUT_PROPERTY, DEFAULT_TIMEOUT))));

            Thread.sleep(10000);

            executors.put(context.getParagraphId(), executor2);

            if (Boolean.valueOf(getProperty(DIRECTORY_USER_HOME))) {
                executor2.setWorkingDirectory(new File(System.getProperty("user.home")));
            }

            int exitVal = executor2.execute(commandLine2);

            LOGGER.info("Paragraph {} return with exit value: {}", context.getParagraphId(), exitVal);
            if (exitVal == 0) {
                return new InterpreterResult(Code.SUCCESS);
            } else {
                return new InterpreterResult(Code.ERROR);
            }
        } catch (ExecuteException e) {
            int exitValue = e.getExitValue();
            LOGGER.error("Can not run command: " + cmd, e);
            Code code = Code.ERROR;
            StringBuilder messageBuilder = new StringBuilder();
            if (exitValue == 143) {
                code = Code.INCOMPLETE;
                messageBuilder.append("Paragraph received a SIGTERM\n");
                LOGGER.info("The paragraph {} stopped executing: {}",
                        context.getParagraphId(), messageBuilder.toString());
            }
            messageBuilder.append("ExitValue: " + exitValue);
            return new InterpreterResult(code, messageBuilder.toString());
        } catch (IOException e) {
            LOGGER.error("Can not run command: " + cmd, e);
            return new InterpreterResult(Code.ERROR, e.getMessage());
        } catch (InterruptedException e) {
            LOGGER.error("Can not run command: " + cmd, e);
            return new InterpreterResult(Code.ERROR, e.getMessage());
        } finally {
            executors.remove(context.getParagraphId());
        }
    }

    @Override
    public void cancel(InterpreterContext context) {
        DefaultExecutor executor = executors.remove(context.getParagraphId());
        if (executor != null) {
            try {
                executor.getWatchdog().destroyProcess();
            } catch (Exception e){
                LOGGER.error("error destroying executor for paragraphId: " + context.getParagraphId(), e);
            }
        }
    }

    @Override
    public FormType getFormType() {
        return FormType.SIMPLE;
    }

    @Override
    public int getProgress(InterpreterContext context) {
        return 0;
    }

    @Override
    public Scheduler getScheduler() {
        return SchedulerFactory.singleton().createOrGetParallelScheduler(
                JShellInterpreter.class.getName() + this.hashCode(), 10);
    }

    @Override
    protected boolean runKerberosLogin() {
        try {
            createSecureConfiguration();
            return true;
        } catch (Exception e) {
            LOGGER.error("Unable to run kinit for zeppelin", e);
        }
        return false;
    }

    public void createSecureConfiguration() throws InterpreterException {
        Properties properties = getProperties();
        CommandLine cmdLine = CommandLine.parse(shell);
        cmdLine.addArgument("-c", false);
        cmdLine.addArgument("jshell");
        String kinitCommand = String.format("kinit -k -t %s %s",
                properties.getProperty("zeppelin.jshell.keytab.location"),
                properties.getProperty("zeppelin.jshell.principal"));
        cmdLine.addArgument(kinitCommand, false);
        DefaultExecutor executor = new DefaultExecutor();
        try {
            executor.execute(cmdLine);
        } catch (Exception e) {
            LOGGER.error("Unable to run kinit for zeppelin user " + kinitCommand, e);
            throw new InterpreterException(e);
        }
    }

    @Override
    protected boolean isKerboseEnabled() {
        if (!StringUtils.isAnyEmpty(getProperty("zeppelin.jshell.auth.type")) && getProperty(
                "zeppelin.jshell.auth.type").equalsIgnoreCase("kerberos")) {
            return true;
        }
        return false;
    }

}
