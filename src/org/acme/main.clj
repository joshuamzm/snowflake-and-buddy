(ns org.acme.main
  (:require [buddy.core.codecs :refer [bytes->hex]]
            [buddy.core.hash :as hash]
            [buddy.core.mac]
            [clojure.edn :as edn]
            [clojure.pprint :refer [pprint]]
            [honey.sql :as hsql]
            [next.jdbc :as jdbc]
            [next.jdbc.result-set :as rs])
  (:gen-class))

(defn- load-config [path]
  (-> path (slurp) (edn/read-string)))

(defn -main [& args]
  (let [config (load-config "snowflake-credentials.edn")

        ds (jdbc/get-datasource (merge (:credentials config)
                                       {:classname "SnowflakeDriver"
                                        :dbtype    "snowflake"}))

        property-address-zip "12020"

        results (jdbc/execute!
                  ds
                  (hsql/format {:select-distinct [:address-id]
                                :from            (-> config :tables :addresses (keyword))
                                :where           [:= :property-address-zip property-address-zip]})
                  {:builder-fn rs/as-unqualified-kebab-maps})

        digested-results (map (fn [{:keys [address-id]}]
                                (-> address-id (hash/sha256) (bytes->hex))) results)]

    (println "Get addresses with ZIP code" property-address-zip)
    (pprint digested-results)))
