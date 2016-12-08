(ns example5
  (:use [anglican emit runtime]))

(defquery example5
	(let [x (sample (bernoulli 0.7))]
		(observe (flip x) true)
		(predict :x-equal-1 (= x 1))))

