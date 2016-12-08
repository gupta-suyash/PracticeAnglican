(ns example2
  (:use [anglican emit runtime]))

(defquery example2
  (let [x (sample (normal 0 1))]
    (if (and (> 0.4 x) (> x -0.4))  
	(println true)
	(println false))))
