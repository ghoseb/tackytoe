(ns tackytoe.main
  (:require [tackytoe.core :as core]
            [figwheel.client :as figwheel :include-macros true]
            [weasel.repl :as weasel]))

(enable-console-print!)

(figwheel/watch-and-reload
  :websocket-url "ws://localhost:3449/figwheel-ws"
  :jsload-callback core/main)

(when-not (weasel/alive?)
  (weasel/connect "ws://localhost:9001" :verbose true :print #{:repl :console}))

(core/main)
