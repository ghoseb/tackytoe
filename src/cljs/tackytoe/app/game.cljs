(ns tackytoe.app.game)

(def players [{:name "Rajnikanth" :email "r@k.com"}
              {:name "Rakhi" :email "foo@bar.com"}])

(defn game []
  [:div "This is the tic tac toe game page."
   [:ul (for [p players]
          [:li [:a {:href (str "mailto:" (:email p)) :target :_blank}
                (:name p)]])]
   [:div [:a {:href "#/"} "go to the home page"]]])
