(ns tackytoe.app.game)


(defn game
  "Given app-state return the current game board."
  [state]
  [:div.game
   [:div.game__board (for [[idx cell] (map-indexed vector (:board @state))]
                       ^{:key idx} [:div.game__cell {:data-marked cell}])]
   [:div.game__player {:data-player "batman"}]
   [:div.game__player {:data-player "you"}]])
