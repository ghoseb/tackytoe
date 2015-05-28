(ns tackytoe.dev
  (:require [environ.core :refer [env]]
            [cemerick.piggieback :as piggieback]
            [weasel.repl.websocket :as weasel]
            [figwheel-sidecar.auto-builder :as fig-auto]
            [figwheel-sidecar.core :as fig]
            [clojurescript-build.auto :as auto]
            [clojure.java.shell :refer [sh]]))

(def is-dev? (env :is-dev))

(defn browser-repl []
  (let [repl-env (weasel/repl-env :ip "0.0.0.0" :port 9001)]
    (piggieback/cljs-repl :repl-env repl-env)))

(defn start-figwheel []
  (let [server (fig/start-server {:css-dirs ["resources/public/css"]})
        config {:builds [{:id "dev"
                          :source-paths ["env/dev/cljs"
                                         "src/cljs"]
                          :compiler {:output-to            "resources/public/js/app.js"
                                     :output-dir           "resources/public/js/out"
                                     :source-map           "resources/public/js/out.js.map"
                                     :source-map-timestamp true
                                     :preamble             ["reagent/react.js"]}}]
                :figwheel-server server}]
    (fig-auto/autobuild* config)))
