(ns tackytoe.core
  (:refer-clojure :exclude [atom])
  (:require [tackytoe.util :refer [hook-browser-navigation!]]
            [reagent.core :as reagent :refer [atom]]
            [secretary.core :as secretary
             :refer-macros [defroute]]
            [tackytoe.app.home :as tah]
            [tackytoe.app.game :as tag]
            [tackytoe.engine.board :refer [make-board]]))


(def opponents [{:name "rajini" :url "#/vs/rajini"}
                {:name "batman" :url "#/vs/rakhi"}])

(defn ^:private player
  "Return a new player object given the name."
  ([]
   (rand-nth opponents))
  ([vs]
   (case vs
     "rajini" (opponents 0)
     "rakhi" (opponents 1)
     (opponents 0))))


(defn default-state
  []
  {:current-page #(tah/home opponents)
   :board (make-board)
   :vs (player)
   :mark "x"
   :over? false
   :winner nil
   :turn :human})


(defonce ^{:doc "The global application state."}
  app-state (atom (default-state)))


(defn ^:private put! [k v]
  (swap! app-state assoc k v))

;;;

(secretary/set-config! :prefix "#")

(defroute "/" []
  (reset! app-state (default-state))
  (put! :current-page #(tah/home opponents)))

(defroute "/vs/:vs" [vs]
  (swap! app-state assoc :vs (player vs))
  (put! :current-page #(tag/game app-state)))

(defn app []
  [(@app-state :current-page)])

(hook-browser-navigation!)

(defn main []
  (reagent/render-component [app] (js/document.getElementById "app")))
