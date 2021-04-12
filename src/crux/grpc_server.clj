(ns crux.grpc-server
  (:gen-class)
  (:require
    [clojure.tools.logging :as log]
    [crux.system :as sys]
    [crux.service]
    )
  (:import
    [io.grpc
     Server
     ServerBuilder]
    [io.grpc.stub StreamObserver]
    [crux.service ServerImpl]))

(def SERVER_PORT 50051)

(defn start []
  (let [greeter-service (new ServerImpl)
        server (-> (ServerBuilder/forPort SERVER_PORT)
                   (.addService greeter-service)
                   (.build)
                   (.start))]
    (-> (Runtime/getRuntime)
        (.addShutdownHook
          (Thread. (fn []
                     (if (not (nil? server))
                       (.shutdown server))))))
    (if (not (nil? server))
      (.awaitTermination server))))

(defn ->server {::sys/deps {:crux-node :crux/node}
                ::sys/args {:port {:spec    ::sys/nat-int
                                   :doc     "Port to start the gRPC server on"
                                   :default SERVER_PORT}}}
  [{:keys [crux-node port] :as options}]
  (let []
    (log/info "gRPC server started on port: " port)
    (start)))