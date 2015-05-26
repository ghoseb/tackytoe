(ns tackytoe.app.home)

(defn home []
  [:div.player-select
   [:h2.player-select__msg "Welcome to"]
   [:h1.player-select__title "Tic Tac Toe"]
   [:small.player-select__vs "play against"]
   [:div.player-select__items-list
    [:a.player-select__item {:href "#/game" :data-player "rajini"}]
    [:a.player-select__item {:href "#/game" :data-player "batman"}] ]])
