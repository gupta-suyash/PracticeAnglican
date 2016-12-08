(ns example6
  (:use [anglican emit runtime]))

(defquery example6
	(if (= (sample (flip 0.6)) true)
		(println 1)
		(println 0)))
