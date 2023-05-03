(ns xtdb.grpc-server
  (:gen-class)
  (:require
    [clojure.tools.logging :as log]
    [xtdb.grpc-server.service]
    [xtdb.system :as sys]
    )
  (:import
    (io.grpc
      ServerBuilder)
    (xtdb.grpc_server.service ServerImpl)))

(def default_port 50051)

(defn start [options]
  (let [service (new ServerImpl)
        port (get options :port)
        awaitTermination? (get options :awaitTermination?)
        server (-> (ServerBuilder/forPort port)
                   (.addService service)
                   (.build)
                   (.start))]
    (-> (Runtime/getRuntime)
        (.addShutdownHook
          (Thread. (fn []
                     (if (not (nil? server))
                       (.shutdown server))))))
    (if (and (not (nil? server)) awaitTermination?)
      (.awaitTermination server))))


(defn ->server {::sys/deps {:xtdb-node :xtdb/node}
                ::sys/args {:port {:spec    ::sys/int
                                   :doc     "Port to start the gRPC server on"
                                   :default default_port}}}
  [{:keys [port] :as options}]
  (let []
    (log/info "gRPC server started on port: " port)
    (start options)))
