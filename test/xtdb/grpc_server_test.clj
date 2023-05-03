(ns xtdb.grpc-server-test
  (:require [clojure.test :refer :all]
            [xtdb.grpc-server :refer :all])
  (:import (io.grpc ManagedChannelBuilder)
           [xtdb.grpc.server ServerGrpc]
           [xtdb.grpc.server StatusRequest]
           [xtdb.grpc.server StatusReply]))
;; for now tests are running only if a real server is launched in background
(def client (ServerGrpc/newBlockingStub
              (-> (ManagedChannelBuilder/forAddress "localhost" (int default_port))
                  (.usePlaintext)
                  .build)))

(defn say-hello []
  (println
    (.getMessage
      (.status client (-> (StatusRequest/newBuilder)
                          .build)))))

(deftest a-test
  (testing "FIXME, I fail."
    (do
      (say-hello))
    ))




