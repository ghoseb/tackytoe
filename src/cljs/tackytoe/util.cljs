(ns tackytoe.util
  (:require [goog.events :as events]
            [goog.history.EventType :as EventType]
            [reagent.core :as reagent]
            [secretary.core :as secretary :include-macros true])
  (:import goog.History))

(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
     EventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))
