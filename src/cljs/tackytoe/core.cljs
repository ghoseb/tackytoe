(ns tackytoe.core
  (:refer-clojure :exclude [atom])
  (:require [tackytoe.util :refer [hook-browser-navigation!]]
            [reagent.core :as reagent :refer [atom]]
            [secretary.core :as secretary
             :refer-macros [defroute]]
            [tackytoe.app.home :as home]
            [tackytoe.app.game :as game]))



(defonce ^{:doc "The global application state."}
  app-state (atom {:current-page home/home
                   :board ["x" "o" "" "" "" "x" "" "" ""]}))


(defn ^:private put! [k v]
  (swap! app-state assoc k v))


(secretary/set-config! :prefix "#")

(defroute "^/$" []
  (put! :current-page home/home))

(defroute "/game" []
  (put! :current-page #(game/game app-state)))

(defn app []
  [(@app-state :current-page)])

(defn main []
  (hook-browser-navigation!)
  (reagent/render-component [app] (js/document.getElementById "app")))
