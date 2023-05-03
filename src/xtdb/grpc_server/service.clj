(ns xtdb.grpc_server.service
  (:gen-class
    :name xtdb.grpc_server.service.ServerImpl
    :extends
    proto.xtdb.grpc.server.ServerGrpc$ServerImplBase)
  (:import
    [io.grpc.stub StreamObserver]
    [proto.xtdb.grpc.server StatusReply]))


(defn -status [this req res]
  (let []
    (doto res
      (.onNext (-> (StatusReply/newBuilder)
                   (.setMessage "Hello, stranger")
                   (.build)))
      (.onCompleted))))