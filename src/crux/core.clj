(ns crux.core
  (:require [crux.api :as crux]
            [clojure.java.io :as io]
            [environ.core :refer [env]])
  (:gen-class))


(defn start-node
  [storage-dir grpc-server-port]
  (let [config {:rocksdb-config                {:crux/module 'crux.rocksdb/->kv-store
                                                :db-dir      (str (io/file storage-dir "db"))}
                :crux/index-store              {:kv-store :rocksdb-config}
                :crux/tx-log                   {:kv-store :rocksdb-config}
                :crux/document-store           {:kv-store :rocksdb-config}
                :crux.grpc-server/server       {:port grpc-server-port}}]
    (crux/start-node config)))

(defn -main
  "Start a Crux node"
  []
  (let [crux-db-dir (env :crux-db-dir)
        crux-grpc-server-port (env :crux-grpc-server-port)]
    (start-node
      crux-db-dir
      crux-grpc-server-port)
    )
  )
