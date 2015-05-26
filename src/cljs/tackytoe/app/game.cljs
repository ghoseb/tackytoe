(ns tackytoe.app.game)

(def gameCells [{:marked "x"}
                {:marked "o"}
                {:marked ""}
                {:marked ""}
                {:marked ""}
                {:marked "x"}
                {:marked ""}
                {:marked ""}
                {:marked ""}])


(defn game []
  [:div.game
   [:div.game__board (for [cell gameCells]
                       [:div.game__cell {:data-marked (:marked cell)}])]
   [:div.game__player {:data-player "rajini"}]
   [:div.game__player {:data-player "you"}]])
