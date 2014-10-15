(ns twitter-fetcher.core
  (:gen-class)
  (:require [clj-http.client :as client])
  (:require [clojure.data.codec.base64 :as b64])
  (:require [clojure.data.json :as json]))

(defn getenv
  [name]
  (get (System/getenv) name))

(def base-url          "https://api.twitter.com/")
(def search-url        (str base-url "1.1/search/tweets.json"))
(def search-params     {"count" "100" "q" "6wunderkinder" "result_type" "recent"})
(def token-url         (str base-url "oauth2/token"))
(def consumer-key      (getenv "CONSUMER_KEY"))
(def consumer-secret   (getenv "CONSUMER_SECRET"))
(def form-content-type "application/x-www-form-urlencoded;charset=UTF-8")
(def form-body         "grant_type=client_credentials")

(defn encode-keys []
  "I really don't understand what this does"
  (let [combo     (str consumer-key ":" consumer-secret)
        the-bytes (b64/encode (.getBytes combo))]
    (String. the-bytes)))

(defn default-opts
  [& args]
  (into {:accept :json} args))

(defn create-token
  [basic]
  (let [auth (str "Basic " basic)
        content-type form-content-type
        headers      {"Authorization" auth
                      "Content-Type" content-type}
        opts         (default-opts {:body    form-body
                                    :headers headers})
        result       (client/post token-url opts)
        body         (:body result)
        body-json    (json/read-str body :key-fn keyword)]
    (:access_token body-json)))

(defn fetch-tweets
  []
  (let [encoded-keys (encode-keys)
        token        (create-token encoded-keys)
        auth         (str "Bearer " token)
        headers      {"Authorization" auth}
        opts         (default-opts {:query-params search-params
                                    :headers      headers})
        result       (client/get search-url opts)
        body         (:body result)
        body-json    (json/read-str body :key-fn keyword)]
    (:statuses body-json)))

(defn print-status
  [status]
  (let [user        (:user status)
        screen-name (:screen_name user)
        text        (:text status)]
    (println (str "@" screen-name ": " text))))

(defn -main
  [& args]
  (doseq [status (fetch-tweets)]
    (print-status status)))
