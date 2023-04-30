(ns xtdb.grpc-server
  (:gen-class)
  (:require
    [clojure.tools.logging :as log]
    [xtdb.service]
    [xtdb.system :as sys]
    )
  (:import
    (xtdb.service ServerImpl)
    (io.grpc
      ServerBuilder)))

(def default_port 50051)

(defn start [options]
  (let [service (new ServerImpl)
        port (get options :port)
        server (-> (ServerBuilder/forPort port)
                   (.addService service)
                   (.build)
                   (.start))]
    (-> (Runtime/getRuntime)
        (.addShutdownHook
          (Thread. (fn []
                     (if (not (nil? server))
                       (.shutdown server))))))
    (if (not (nil? server))
      (.awaitTermination server))))


(defn ->server {::sys/deps {:xtdb-node :xtdb/node}
                ::sys/args {:port {:spec ::sys/int
                                   :doc  "Port to start the gRPC server on"
                                   :default default_port}}}
  [{:keys [port] :as options}]
  (let []
    (log/info "gRPC server started on port: " port)
    (start options)))