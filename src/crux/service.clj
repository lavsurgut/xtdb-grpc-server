(ns crux.service
  (:gen-class
    :name crux.service.ServerImpl
    :extends
    crux.grpc.server.ServerGrpc$ServerImplBase)
  (:import
    [io.grpc.stub StreamObserver]
    [crux.grpc.server
     StatusReply]))


(defn -status [this req res]
  (let []
    (doto res
      (.onNext (-> (StatusReply/newBuilder)
                   (.setMessage "Hello, stranger")
                   (.build)))
      (.onCompleted))))