package proto.xtdb.grpc.server;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: server.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ServerGrpc {

  private ServerGrpc() {}

  public static final String SERVICE_NAME = "server.Server";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.xtdb.grpc.server.StatusRequest,
      proto.xtdb.grpc.server.StatusReply> getStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Status",
      requestType = proto.xtdb.grpc.server.StatusRequest.class,
      responseType = proto.xtdb.grpc.server.StatusReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.xtdb.grpc.server.StatusRequest,
      proto.xtdb.grpc.server.StatusReply> getStatusMethod() {
    io.grpc.MethodDescriptor<proto.xtdb.grpc.server.StatusRequest, proto.xtdb.grpc.server.StatusReply> getStatusMethod;
    if ((getStatusMethod = ServerGrpc.getStatusMethod) == null) {
      synchronized (ServerGrpc.class) {
        if ((getStatusMethod = ServerGrpc.getStatusMethod) == null) {
          ServerGrpc.getStatusMethod = getStatusMethod =
              io.grpc.MethodDescriptor.<proto.xtdb.grpc.server.StatusRequest, proto.xtdb.grpc.server.StatusReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Status"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.xtdb.grpc.server.StatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.xtdb.grpc.server.StatusReply.getDefaultInstance()))
              .setSchemaDescriptor(new ServerMethodDescriptorSupplier("Status"))
              .build();
        }
      }
    }
    return getStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerStub>() {
        @java.lang.Override
        public ServerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerStub(channel, callOptions);
        }
      };
    return ServerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerBlockingStub>() {
        @java.lang.Override
        public ServerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerBlockingStub(channel, callOptions);
        }
      };
    return ServerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerFutureStub>() {
        @java.lang.Override
        public ServerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerFutureStub(channel, callOptions);
        }
      };
    return ServerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void status(proto.xtdb.grpc.server.StatusRequest request,
        io.grpc.stub.StreamObserver<proto.xtdb.grpc.server.StatusReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStatusMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Server.
   */
  public static abstract class ServerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ServerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Server.
   */
  public static final class ServerStub
      extends io.grpc.stub.AbstractAsyncStub<ServerStub> {
    private ServerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerStub(channel, callOptions);
    }

    /**
     */
    public void status(proto.xtdb.grpc.server.StatusRequest request,
        io.grpc.stub.StreamObserver<proto.xtdb.grpc.server.StatusReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Server.
   */
  public static final class ServerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ServerBlockingStub> {
    private ServerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.xtdb.grpc.server.StatusReply status(proto.xtdb.grpc.server.StatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Server.
   */
  public static final class ServerFutureStub
      extends io.grpc.stub.AbstractFutureStub<ServerFutureStub> {
    private ServerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.xtdb.grpc.server.StatusReply> status(
        proto.xtdb.grpc.server.StatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STATUS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STATUS:
          serviceImpl.status((proto.xtdb.grpc.server.StatusRequest) request,
              (io.grpc.stub.StreamObserver<proto.xtdb.grpc.server.StatusReply>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              proto.xtdb.grpc.server.StatusRequest,
              proto.xtdb.grpc.server.StatusReply>(
                service, METHODID_STATUS)))
        .build();
  }

  private static abstract class ServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.xtdb.grpc.server.GrpcServerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Server");
    }
  }

  private static final class ServerFileDescriptorSupplier
      extends ServerBaseDescriptorSupplier {
    ServerFileDescriptorSupplier() {}
  }

  private static final class ServerMethodDescriptorSupplier
      extends ServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ServerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServerFileDescriptorSupplier())
              .addMethod(getStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
