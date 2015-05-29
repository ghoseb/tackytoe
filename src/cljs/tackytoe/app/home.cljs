(ns tackytoe.app.home)

(defn home
  [players]
  [:div.player-select
   [:h2.player-select__msg "Welcome to"]
   [:h1.player-select__title "Tic Tac Toe"]
   [:small.player-select__vs "play against"]
   [:div.player-select__items-list
    (for [p players]
      ^{:key (:name p)} [:a.player-select__item {:href (:url p)
                                                 :data-player (:name p)}])]])
