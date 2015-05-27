(ns tackytoe.util
  (:require [goog.events :as events]
            [goog.history.EventType :as EventType]
            [reagent.core :as reagent]
            [secretary.core :as secretary])
  (:import goog.History))

(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
     EventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true))

  (set! (.-onhashchange js/window)
        #(secretary/dispatch! (.-hash js/window.location))
        false))
