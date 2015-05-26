(ns tackytoe.core
  (:refer-clojure :exclude [atom])
  (:require [tackytoe.util :refer [hook-browser-navigation!]]
            [reagent.core :as reagent :refer [atom]]
            [secretary.core :as secretary
             :refer-macros [defroute]]
            [tackytoe.app.home :as home]
            [tackytoe.app.game :as game]))



(defonce ^{:doc "The global application state."}
  app-state (atom {:current-page "/"}))


(defn ^:private put! [k v]
  (swap! app-state assoc k v))

;;; dummy component used for routing
(defn current-page-will-mount []
  (put! :current-page #'home/home))


(defn current-page-render []
  [(@app-state :current-page)])


(defn current-page []
  (reagent/create-class {:component-will-mount current-page-will-mount
                         :reagent-render current-page-render}))


(secretary/set-config! :prefix "#")

(defroute "/" []
  (put! :current-page #'home/home))

(defroute "/game" []
  (put! :current-page #'game/game))

(hook-browser-navigation!)

(defn main []
  (reagent/render [current-page] (js/document.getElementById "app")))
