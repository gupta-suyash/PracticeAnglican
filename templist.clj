(ns templist
  (:use [anglican emit runtime]))


(defm getval
	[range]
	(let [x (sample (uniform-discrete (nth range 0) (nth range 1)))]
		x))



(defm tossCoin
	[p]
	(sample (flip p)))


(defm crtList 
	[n low high last p]
	(if (== n 0)
		'()
		(let [x (getval (conj (conj '() high) low))]
			(if (= (tossCoin p) false)				;; Decision for next number any
				(conj (crtList (- n 1) low high (if (> x last) x last) p) x)
				(conj 
					(if (< x (- high 1)) 
						(crtList (- n 1) x high x p)
						(crtList (- n 1) x (+ x high) x p))
					x)))))
		

;; Arguments: List Size, Low, High, Initial Value, Bias Probability
(defquery templist
	(println (crtList 30 0 70 0 0.9)))

