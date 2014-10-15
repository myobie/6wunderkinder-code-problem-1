(defproject twitter-fetcher "0.1.0-SNAPSHOT"
  :description "Fetching the twitters"
  :url "https://github.com/myobie/6wunderkinder-code-problem-1"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-http "1.0.0"]
                 [org.clojure/data.codec "0.1.0"]
                 [org.clojure/data.json "0.2.5"]]
  :main ^:skip-aot twitter-fetcher.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
