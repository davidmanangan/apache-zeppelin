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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.zeppelin.interpreter.InterpreterException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Properties;

import org.apache.zeppelin.interpreter.InterpreterContext;
import org.apache.zeppelin.interpreter.InterpreterResult;
import org.apache.zeppelin.interpreter.InterpreterResult.Code;

public class JShellInterpreterTest {

    private JShellInterpreter shell;
    private InterpreterContext context;
    private InterpreterResult result;

    @Before
    public void setUp() throws Exception {
        Properties p = new Properties();
        p.setProperty("jshell.command.timeout.millisecs", "2000");
        shell = new JShellInterpreter(p);

        context = InterpreterContext.builder().setParagraphId("paragraphId").build();
        shell.open();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws InterpreterException {
        result = shell.interpret("System.out.println(\"Hello There!\")", context);

        assertEquals(InterpreterResult.Code.SUCCESS, result.code());
        assertTrue(shell.executors.isEmpty());
        // it should be fine to cancel a statement that has been completed.
        shell.cancel(context);
        assertTrue(shell.executors.isEmpty());
    }

    @Test
    public void testInvalidCommand() throws InterpreterException {
        result = shell.interpret("invalid_command", context);
        assertEquals(Code.SUCCESS, result.code());
        assertTrue(shell.executors.isEmpty());
    }
}
