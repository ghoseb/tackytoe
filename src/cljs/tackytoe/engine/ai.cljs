(ns ^{:doc "Adapted from https://github.com/trptcolin/tictactoe-clojure/"}
  tackytoe.engine.ai
  (:require [tackytoe.engine.board :refer [winner
                                           full?
                                           next-mark
                                           empty-squares]]))



(declare best-scored-board)

(defn- make-scored-board [score move]
  {:score score :move move})

(defn- score-board [board move mark depth]
  (let [next-board (assoc board move mark)]
    (cond
      (= mark (winner next-board)) (make-scored-board (- 10 depth) move)
      (full? next-board) (make-scored-board 0 move)
      :else (make-scored-board
             (- (:score (best-scored-board
                         next-board
                         (next-mark mark)
                         (inc depth))))
             move))))

(defn- scored-board-compare [a b]
  (if (> (:score b) (:score a)) b a))

(defn- child-scored-boards [board mark depth]
  (map
    #(score-board board % mark depth)
    (empty-squares board)))

(defn- best-scored-board* [board mark depth]
  (reduce
    scored-board-compare
    (child-scored-boards board mark depth)))

(def best-scored-board (memoize best-scored-board*))

;;; public functions

(defn computer-mover [board mark]
  (let [best-board (best-scored-board board mark 0)]
    (:move best-board)))

