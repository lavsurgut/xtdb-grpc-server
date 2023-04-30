(ns xtdb.service
  (:gen-class
    :name xtdb.service.ServerImpl
    :extends
    xtdb.grpc.server.ServerGrpc$ServerImplBase)
  (:import
    [io.grpc.stub StreamObserver]
    [xtdb.grpc.server StatusReply]))


(defn -status [this req res]
  (let []
    (doto res
      (.onNext (-> (StatusReply/newBuilder)
                   (.setMessage "Hello, stranger")
                   (.build)))
      (.onCompleted))))