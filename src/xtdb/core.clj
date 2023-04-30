(ns xtdb.core
  (:require [xtdb.api :as xtdb]
            [clojure.java.io :as io]
            [xtdb.grpc-server :as grpc-server]
            [environ.core :refer [env]])
  (:gen-class))


(defn start-node
  [storage-dir grpc-server-port]
  (let [config {:rocksdb-config          {:xtdb/module 'xtdb.rocksdb/->kv-store
                                          :db-dir      (io/file storage-dir "tmp/rocksdb")}
                :xtdb/index-store        {:kv-store :rocksdb-config}
                :xtdb/tx-log             {:kv-store :rocksdb-config}
                :xtdb/document-store     {:kv-store :rocksdb-config}
                :xtdb.grpc-server/server {:port grpc-server-port}}]
    (xtdb/start-node config)))

(defn -main
  "Start a XTDB node"
  []
  (let [xtdb-db-dir (or (env :xtdb-db-dir) ".")
        xtdb-grpc-server-port (or (env :xtdb-grpc-server-port) grpc-server/default_port)]
    (start-node
      xtdb-db-dir
      xtdb-grpc-server-port)
    )
  )
