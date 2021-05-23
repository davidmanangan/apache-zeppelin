package org.apache.zeppelin.interpreter.jupyter.proto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * The JupyterKernel service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: kernel.proto")
public final class JupyterKernelGrpc {

  private JupyterKernelGrpc() {}

  public static final String SERVICE_NAME = "jupyter.JupyterKernel";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<org.apache.zeppelin.interpreter.jupyter.proto.ExecuteRequest,
      org.apache.zeppelin.interpreter.jupyter.proto.ExecuteResponse> METHOD_EXECUTE =
      io.grpc.MethodDescriptor.<org.apache.zeppelin.interpreter.jupyter.proto.ExecuteRequest, org.apache.zeppelin.interpreter.jupyter.proto.ExecuteResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "jupyter.JupyterKernel", "execute"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.apache.zeppelin.interpreter.jupyter.proto.ExecuteRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.apache.zeppelin.interpreter.jupyter.proto.ExecuteResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<org.apache.zeppelin.interpreter.jupyter.proto.CompletionRequest,
      org.apache.zeppelin.interpreter.jupyter.proto.CompletionResponse> METHOD_COMPLETE =
      io.grpc.MethodDescriptor.<org.apache.zeppelin.interpreter.jupyter.proto.CompletionRequest, org.apache.zeppelin.interpreter.jupyter.proto.CompletionResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "jupyter.JupyterKernel", "complete"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.apache.zeppelin.interpreter.jupyter.proto.CompletionRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.apache.zeppelin.interpreter.jupyter.proto.CompletionResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<org.apache.zeppelin.interpreter.jupyter.proto.CancelRequest,
      org.apache.zeppelin.interpreter.jupyter.proto.CancelResponse> METHOD_CANCEL =
      io.grpc.MethodDescriptor.<org.apache.zeppelin.interpreter.jupyter.proto.CancelRequest, org.apache.zeppelin.interpreter.jupyter.proto.CancelResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "jupyter.JupyterKernel", "cancel"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.apache.zeppelin.interpreter.jupyter.proto.CancelRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.apache.zeppelin.interpreter.jupyter.proto.CancelResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<org.apache.zeppelin.interpreter.jupyter.proto.StatusRequest,
      org.apache.zeppelin.interpreter.jupyter.proto.StatusResponse> METHOD_STATUS =
      io.grpc.MethodDescriptor.<org.apache.zeppelin.interpreter.jupyter.proto.StatusRequest, org.apache.zeppelin.interpreter.jupyter.proto.StatusResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "jupyter.JupyterKernel", "status"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.apache.zeppelin.interpreter.jupyter.proto.StatusRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.apache.zeppelin.interpreter.jupyter.proto.StatusResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<org.apache.zeppelin.interpreter.jupyter.proto.StopRequest,
      org.apache.zeppelin.interpreter.jupyter.proto.StopResponse> METHOD_STOP =
      io.grpc.MethodDescriptor.<org.apache.zeppelin.interpreter.jupyter.proto.StopRequest, org.apache.zeppelin.interpreter.jupyter.proto.StopResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "jupyter.JupyterKernel", "stop"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.apache.zeppelin.interpreter.jupyter.proto.StopRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.apache.zeppelin.interpreter.jupyter.proto.StopResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static JupyterKernelStub newStub(io.grpc.Channel channel) {
    return new JupyterKernelStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static JupyterKernelBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new JupyterKernelBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static JupyterKernelFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new JupyterKernelFutureStub(channel);
  }

  /**
   * <pre>
   * The JupyterKernel service definition.
   * </pre>
   */
  public static abstract class JupyterKernelImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends code
     * </pre>
     */
    public void execute(org.apache.zeppelin.interpreter.jupyter.proto.ExecuteRequest request,
        io.grpc.stub.StreamObserver<org.apache.zeppelin.interpreter.jupyter.proto.ExecuteResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_EXECUTE, responseObserver);
    }

    /**
     * <pre>
     * Get completion
     * </pre>
     */
    public void complete(org.apache.zeppelin.interpreter.jupyter.proto.CompletionRequest request,
        io.grpc.stub.StreamObserver<org.apache.zeppelin.interpreter.jupyter.proto.CompletionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_COMPLETE, responseObserver);
    }

    /**
     * <pre>
     * Cancel the running statement
     * </pre>
     */
    public void cancel(org.apache.zeppelin.interpreter.jupyter.proto.CancelRequest request,
        io.grpc.stub.StreamObserver<org.apache.zeppelin.interpreter.jupyter.proto.CancelResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CANCEL, responseObserver);
    }

    /**
     * <pre>
     * Get jupyter kernel status
     * </pre>
     */
    public void status(org.apache.zeppelin.interpreter.jupyter.proto.StatusRequest request,
        io.grpc.stub.StreamObserver<org.apache.zeppelin.interpreter.jupyter.proto.StatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_STATUS, responseObserver);
    }

    /**
     * <pre>
     * Stop jupyter kernel
     * </pre>
     */
    public void stop(org.apache.zeppelin.interpreter.jupyter.proto.StopRequest request,
        io.grpc.stub.StreamObserver<org.apache.zeppelin.interpreter.jupyter.proto.StopResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_STOP, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_EXECUTE,
            asyncServerStreamingCall(
              new MethodHandlers<
                org.apache.zeppelin.interpreter.jupyter.proto.ExecuteRequest,
                org.apache.zeppelin.interpreter.jupyter.proto.ExecuteResponse>(
                  this, METHODID_EXECUTE)))
          .addMethod(
            METHOD_COMPLETE,
            asyncUnaryCall(
              new MethodHandlers<
                org.apache.zeppelin.interpreter.jupyter.proto.CompletionRequest,
                org.apache.zeppelin.interpreter.jupyter.proto.CompletionResponse>(
                  this, METHODID_COMPLETE)))
          .addMethod(
            METHOD_CANCEL,
            asyncUnaryCall(
              new MethodHandlers<
                org.apache.zeppelin.interpreter.jupyter.proto.CancelRequest,
                org.apache.zeppelin.interpreter.jupyter.proto.CancelResponse>(
                  this, METHODID_CANCEL)))
          .addMethod(
            METHOD_STATUS,
            asyncUnaryCall(
              new MethodHandlers<
                org.apache.zeppelin.interpreter.jupyter.proto.StatusRequest,
                org.apache.zeppelin.interpreter.jupyter.proto.StatusResponse>(
                  this, METHODID_STATUS)))
          .addMethod(
            METHOD_STOP,
            asyncUnaryCall(
              new MethodHandlers<
                org.apache.zeppelin.interpreter.jupyter.proto.StopRequest,
                org.apache.zeppelin.interpreter.jupyter.proto.StopResponse>(
                  this, METHODID_STOP)))
          .build();
    }
  }

  /**
   * <pre>
   * The JupyterKernel service definition.
   * </pre>
   */
  public static final class JupyterKernelStub extends io.grpc.stub.AbstractStub<JupyterKernelStub> {
    private JupyterKernelStub(io.grpc.Channel channel) {
      super(channel);
    }

    private JupyterKernelStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JupyterKernelStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new JupyterKernelStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends code
     * </pre>
     */
    public void execute(org.apache.zeppelin.interpreter.jupyter.proto.ExecuteRequest request,
        io.grpc.stub.StreamObserver<org.apache.zeppelin.interpreter.jupyter.proto.ExecuteResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_EXECUTE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get completion
     * </pre>
     */
    public void complete(org.apache.zeppelin.interpreter.jupyter.proto.CompletionRequest request,
        io.grpc.stub.StreamObserver<org.apache.zeppelin.interpreter.jupyter.proto.CompletionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_COMPLETE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Cancel the running statement
     * </pre>
     */
    public void cancel(org.apache.zeppelin.interpreter.jupyter.proto.CancelRequest request,
        io.grpc.stub.StreamObserver<org.apache.zeppelin.interpreter.jupyter.proto.CancelResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CANCEL, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get jupyter kernel status
     * </pre>
     */
    public void status(org.apache.zeppelin.interpreter.jupyter.proto.StatusRequest request,
        io.grpc.stub.StreamObserver<org.apache.zeppelin.interpreter.jupyter.proto.StatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_STATUS, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Stop jupyter kernel
     * </pre>
     */
    public void stop(org.apache.zeppelin.interpreter.jupyter.proto.StopRequest request,
        io.grpc.stub.StreamObserver<org.apache.zeppelin.interpreter.jupyter.proto.StopResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_STOP, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The JupyterKernel service definition.
   * </pre>
   */
  public static final class JupyterKernelBlockingStub extends io.grpc.stub.AbstractStub<JupyterKernelBlockingStub> {
    private JupyterKernelBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private JupyterKernelBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JupyterKernelBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new JupyterKernelBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends code
     * </pre>
     */
    public java.util.Iterator<org.apache.zeppelin.interpreter.jupyter.proto.ExecuteResponse> execute(
        org.apache.zeppelin.interpreter.jupyter.proto.ExecuteRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_EXECUTE, getCallOptions(), request);
    }

    /**
     * <pre>
     * Get completion
     * </pre>
     */
    public org.apache.zeppelin.interpreter.jupyter.proto.CompletionResponse complete(org.apache.zeppelin.interpreter.jupyter.proto.CompletionRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_COMPLETE, getCallOptions(), request);
    }

    /**
     * <pre>
     * Cancel the running statement
     * </pre>
     */
    public org.apache.zeppelin.interpreter.jupyter.proto.CancelResponse cancel(org.apache.zeppelin.interpreter.jupyter.proto.CancelRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CANCEL, getCallOptions(), request);
    }

    /**
     * <pre>
     * Get jupyter kernel status
     * </pre>
     */
    public org.apache.zeppelin.interpreter.jupyter.proto.StatusResponse status(org.apache.zeppelin.interpreter.jupyter.proto.StatusRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_STATUS, getCallOptions(), request);
    }

    /**
     * <pre>
     * Stop jupyter kernel
     * </pre>
     */
    public org.apache.zeppelin.interpreter.jupyter.proto.StopResponse stop(org.apache.zeppelin.interpreter.jupyter.proto.StopRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_STOP, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The JupyterKernel service definition.
   * </pre>
   */
  public static final class JupyterKernelFutureStub extends io.grpc.stub.AbstractStub<JupyterKernelFutureStub> {
    private JupyterKernelFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private JupyterKernelFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JupyterKernelFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new JupyterKernelFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get completion
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.apache.zeppelin.interpreter.jupyter.proto.CompletionResponse> complete(
        org.apache.zeppelin.interpreter.jupyter.proto.CompletionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_COMPLETE, getCallOptions()), request);
    }

    /**
     * <pre>
     * Cancel the running statement
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.apache.zeppelin.interpreter.jupyter.proto.CancelResponse> cancel(
        org.apache.zeppelin.interpreter.jupyter.proto.CancelRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CANCEL, getCallOptions()), request);
    }

    /**
     * <pre>
     * Get jupyter kernel status
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.apache.zeppelin.interpreter.jupyter.proto.StatusResponse> status(
        org.apache.zeppelin.interpreter.jupyter.proto.StatusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_STATUS, getCallOptions()), request);
    }

    /**
     * <pre>
     * Stop jupyter kernel
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.apache.zeppelin.interpreter.jupyter.proto.StopResponse> stop(
        org.apache.zeppelin.interpreter.jupyter.proto.StopRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_STOP, getCallOptions()), request);
    }
  }

  private static final int METHODID_EXECUTE = 0;
  private static final int METHODID_COMPLETE = 1;
  private static final int METHODID_CANCEL = 2;
  private static final int METHODID_STATUS = 3;
  private static final int METHODID_STOP = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final JupyterKernelImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(JupyterKernelImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXECUTE:
          serviceImpl.execute((org.apache.zeppelin.interpreter.jupyter.proto.ExecuteRequest) request,
              (io.grpc.stub.StreamObserver<org.apache.zeppelin.interpreter.jupyter.proto.ExecuteResponse>) responseObserver);
          break;
        case METHODID_COMPLETE:
          serviceImpl.complete((org.apache.zeppelin.interpreter.jupyter.proto.CompletionRequest) request,
              (io.grpc.stub.StreamObserver<org.apache.zeppelin.interpreter.jupyter.proto.CompletionResponse>) responseObserver);
          break;
        case METHODID_CANCEL:
          serviceImpl.cancel((org.apache.zeppelin.interpreter.jupyter.proto.CancelRequest) request,
              (io.grpc.stub.StreamObserver<org.apache.zeppelin.interpreter.jupyter.proto.CancelResponse>) responseObserver);
          break;
        case METHODID_STATUS:
          serviceImpl.status((org.apache.zeppelin.interpreter.jupyter.proto.StatusRequest) request,
              (io.grpc.stub.StreamObserver<org.apache.zeppelin.interpreter.jupyter.proto.StatusResponse>) responseObserver);
          break;
        case METHODID_STOP:
          serviceImpl.stop((org.apache.zeppelin.interpreter.jupyter.proto.StopRequest) request,
              (io.grpc.stub.StreamObserver<org.apache.zeppelin.interpreter.jupyter.proto.StopResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class JupyterKernelDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.apache.zeppelin.interpreter.jupyter.proto.JupyterKernelProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (JupyterKernelGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new JupyterKernelDescriptorSupplier())
              .addMethod(METHOD_EXECUTE)
              .addMethod(METHOD_COMPLETE)
              .addMethod(METHOD_CANCEL)
              .addMethod(METHOD_STATUS)
              .addMethod(METHOD_STOP)
              .build();
        }
      }
    }
    return result;
  }
}
