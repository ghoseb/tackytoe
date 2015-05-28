(ns tackytoe.app.game
  (:require [tackytoe.engine.board :refer [make-board
                                           valid-move?
                                           place-on-board
                                           next-mark
                                           empty-squares
                                           winner
                                           game-over?
                                           winning-combo]]
            [tackytoe.engine.ai :refer [computer-mover]]))


(defn get-player [{:keys [name]}]
  (case name
    "rajini" computer-mover
    (fn [board _] (rand-nth (empty-squares board)))))


(defn- play-move
  "Play the move and change the turn, mark, etc."
  [state move]
  (when-not (game-over? (:board @state))
    (let [new-board (place-on-board (:board @state) move (:mark @state))
          maybe-win? (winning-combo new-board)]
      (swap! state assoc
             :board new-board
             :mark (next-mark (:mark @state))
             :turn (if (= (:turn @state) :human)
                     :computer
                     :human)
             :over? (game-over? new-board)
             :winner maybe-win?))))


(defn- move-when-valid
  [state idx]
  (let [board (:board @state)
        mark (:mark @state)
        ai (get-player (:vs @state))]
    (when (and (= :human (:turn @state))
               (valid-move? board idx))
      (play-move state idx)
      (js/setTimeout #(play-move state (ai (:board @state) (:mark @state)))
                     (rand-int 2000)))))


(defn turn?
  [state player]
  (and (not (:over? @state))
       (= (:turn @state) player)))


(defn game
  "Given app-state return the current game board."
  [state]
  (let [win? (into #{} (:winner @state))]
    [:div.game
     [:div.game__board (for [[idx cell] (map-indexed vector (:board @state))]
                         ^{:key idx} [:div.game__cell {:data-marked cell
                                                       :on-click #(move-when-valid state idx)
                                                       :class (when (win? idx)
                                                                "highlight")}])]
     [:div.game__player {:data-player (get-in @state [:vs :name]) :data-turn (turn? state :computer)}]
     [:div.game__player {:data-player "user" :data-turn (turn? state :human)}]
     (cond
       (turn? state :human) [:div.game__turn.show]
       (game-over? (:board @state)) [:div.game__turn.showover])
     [:button.game__home {:on-click #(set! js/window.location.hash "")}]
     [:button.game__reset {:on-click #(swap! state assoc :board (make-board))}]]))



;; Use this markup to render results -->

;; [:div.result
;;  [:h2.result__label "Rajini Won"]
;;  [:div.result__winner {:data-player "rajini"}]
;;  [:h1.result__text "Mind It!!"]
;;  [:a.result__home {:href "/"}]]
