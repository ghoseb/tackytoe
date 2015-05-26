(ns tackytoe.app.home)

(defn home []
  [:div [:h2 "Welcome to the ultimate Tic Tac Toe game!"]
   [:div [:a {:href "#/game"} "go to the game page"]]])
