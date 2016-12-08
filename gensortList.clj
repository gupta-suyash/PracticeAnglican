(ns gensortList
  (:use [anglican emit runtime]))


(defm getval
	[range]
	(let [x (sample (uniform-discrete (nth range 0) (nth range 1)))]
		x))



(defm tossCoin
	[p]
	(sample (flip p)))


(defm creatList 
	[n low high last p]
	(if (== n 0)
		'()
		(if (= (tossCoin p) false)				;; Decision for next number any
			(let [x (getval (conj (conj '() high) low))]
				(conj (creatList (- n 1) low high (if (> x last) x last) p) x))
			(let [x (+ last 1)]				;; Generate sorted element
				(conj (creatList (- n 1) low high x p) x)))))
		

;; Arguments: List Size, Low, High, Initial Value, Bias Probability
(defquery gensortList
	(println (creatList 30 0 200 0 0.9)))

