(defproject crux-grpc-server "0.1.0-SNAPSHOT"
  :description "GRPC server for Crux"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [org.slf4j/slf4j-api "1.7.29"]
                 [ch.qos.logback/logback-classic "1.2.3"]
                 [juxt/crux-core "21.04-1.16.0-beta"]
                 [juxt/crux-rocksdb "21.04-1.16.0-beta"]
                 [juxt/crux-http-server "21.04-1.16.0-alpha"]
                 [com.google.protobuf/protobuf-java "3.10.0"]
                 [javax.annotation/javax.annotation-api "1.2"]
                 [io.netty/netty-codec-http2 "4.1.25.Final"]
                 [io.grpc/grpc-core "1.25.0" :exclusions [io.grpc/grpc-api]]
                 [io.grpc/grpc-stub "1.25.0"]
                 [io.grpc/grpc-protobuf "1.25.0"]
                 [io.grpc/grpc-netty "1.25.0" :exclusions [io.netty/netty-codec-http2 io.grpc/grpc-core io.grpc/grpc-api]]
                 [environ "1.2.0"]
                 ]
  :plugins [[org.clojars.awebneck/lein-protoc "0.5.5"]]
  :proto-source-paths ["src/proto"]
  :protoc-version "3.10.0"
  :protoc-grpc {:version "1.25.0"}
  :proto-target-path "target/generated-sources/protobuf"
  :java-source-paths ["target/generated-sources/protobuf"]
  :main ^:skip-aot crux.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  )