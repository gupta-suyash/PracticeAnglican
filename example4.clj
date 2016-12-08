(ns example4
  (:use [anglican emit runtime]))

(defquery example4
	(println (sample (flip 0.9))))
	;;(println (sample (bernoulli 0.9))))
  	;;(println (sample (uniform-discrete 1 7))))
