(ns tackytoe.core
  (:refer-clojure :exclude [atom])
  (:require [tackytoe.util :refer [hook-browser-navigation!]]
            [reagent.core :as reagent :refer [atom]]
            [secretary.core :as secretary
             :refer-macros [defroute]]
            [tackytoe.app.home :as tah]
            [tackytoe.app.game :as tag]))


(def opponents [{:name "rajini" :url "#/vs/rajini"}
                {:name "batman" :url "#/vs/batman"}])

(defn ^:private player
  "Return a new player object given the name."
  ([]
   (rand-nth opponents))
  ([vs]
   (case vs
     "rajini" (opponents 0)
     "batman" (opponents 1)
     (opponents 0))))


(defonce ^{:doc "The global application state."}
  app-state (atom {:current-page #(tah/home opponents)
                   :board ["x" "o" "" "" "" "x" "" "" ""]
                   :vs (player)}))


(defn ^:private put! [k v]
  (swap! app-state assoc k v))

;;;

(secretary/set-config! :prefix "#")

(defroute "/" []
  (put! :current-page #(tah/home opponents)))

(defroute "/vs/:vs" [vs]
  (swap! app-state assoc :vs (player vs))
  (put! :current-page #(tag/game app-state)))

(defn app []
  [(@app-state :current-page)])

(defn main []
  (hook-browser-navigation!)
  (reagent/render-component [app] (js/document.getElementById "app")))
