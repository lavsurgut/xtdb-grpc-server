(defproject xtdb-grpc-server "0.1.0-SNAPSHOT"
  :description "GRPC server for XTDB"
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [javax.annotation/javax.annotation-api "1.3.2"]
                 [ch.qos.logback/logback-classic "1.2.9"]
                 [com.google.protobuf/protobuf-java "3.22.3"]
                 [environ "1.2.0"]
                 [io.grpc/grpc-core "1.54.1"
                  :exclusions [io.grpc/grpc-api]]
                 [io.grpc/grpc-stub "1.54.1"]
                 [io.grpc/grpc-protobuf "1.54.1"]
                 [io.grpc/grpc-netty "1.54.1"
                  :exclusions [io.netty/netty-codec-http2 io.grpc/grpc-core io.grpc/grpc-api]]
                 [io.netty/netty-codec-http2 "4.1.91.Final"]]
  :plugins [[org.clojars.awebneck/lein-protoc "0.5.5"]]
  :proto-source-paths ["src/proto"]
  :protoc-version "3.22.3"
  :protoc-grpc {:version "1.54.1"}
  :proto-target-path "target/generated-sources/protobuf"
  :java-source-paths ["target/generated-sources/protobuf"]
  :main ^:skip-aot xtdb.core
  :aot :all
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev     {:dependencies
                       [[com.xtdb/xtdb-core "1.23.1"]
                        [com.xtdb/xtdb-rocksdb "1.23.1"]
                        [com.xtdb/xtdb-http-server "1.23.1"]]
                       }
             }
  )
