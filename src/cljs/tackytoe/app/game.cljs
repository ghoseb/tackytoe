(ns tackytoe.app.game)

(def players [{:name "Rajnikanth" :email "r@k.com"}
              {:name "Rakhi" :email "foo@bar.com"}])

(defn player
  [name email]
  [:li [:a {:href (str "mailto:" email) :target :_blank}
        name]])


(defn game []
  [:div "This is the tic tac toe game page."
   [:ul (for [{:keys [name email]} players]
          [player name email])]
   [:div [:a {:href "#/"} "go to the home page"]]])
