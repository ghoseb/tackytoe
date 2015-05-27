(ns tackytoe.app.game)


(defn game
  "Given app-state return the current game board."
  [state]
  [:div.game
   [:div.game__board (for [[idx cell] (map-indexed vector (:board @state))]
                       ^{:key idx} [:div.game__cell {:data-marked cell}])]
   [:div.game__player {:data-player "batman" :data-turn false}]
   [:div.game__player {:data-player "user"}]
   [:a.game__home {:href "/"}]
   [:a.game__reset {:href "javascript:void(0)"}]])




;; Use this markup to render results -->

;; [:div.result
;;    [:h2.result__label "Rajini Won"]
;;    [:div.result__winner {:data-player "rajini"}]
;;    [:h1.result__text "Mind It!!"]
;;    [:a.result__home {:href "/"}]]
