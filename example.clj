(ns example
  (:use [anglican emit runtime]))

(defquery example
  (let [bet (sample (beta 5 3))]
    (observe (flip bet) true)
    (predict (> bet 0.7))))
