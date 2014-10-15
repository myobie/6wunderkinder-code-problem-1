(defproject twitter-fetcher "0.1.0-SNAPSHOT"
  :description "Fetching the twitters"
  :url "https://github.com/myobie/6wunderkinder-code-problem-1"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot twitter-fetcher.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
