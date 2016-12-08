(ns normaldist_ex
  (:use [anglican emit runtime]))



;; Swapping two locations in a vector.
(defn permute
	[vec i j]
	(assoc vec j (vec i) i (vec j)))
	

;; Swaps all the consecutive elements in the range.
(defn swapNLocations
	[vec i j swaps total]
	(if (== swaps total)
		vec
		(swapNLocations (permute vec i j) (+ i 2) (+ j 2) (+ swaps 1) total)))

;; Initiates the swapping process.
(defn helpfunc
	[lst percent]
	(swapNLocations (into [] (sort lst)) 0 1 0 (int (Math/round (* percent (count lst))))))


;; My absolute function
(defm myabs [n] (max n (- n)))


(with-primitive-procedures [helpfunc]
 (defquery normaldist_ex
  (let [x (sample (normal 0 1))]
    (if (< (myabs x) 1.1)
	(println (helpfunc '(4 77 12 33 9 2) 0.3))))))

;;	(println (* x 2) " : " x))))




;;(defn pseudorandn
;;	[lst rng]
;;	(set (take rng lst)))
;;

;; (into (list) #{set-elems})
;; (conj #{set-elems} num)

;;(defn getindices
;;	[cval len n]
;;	(if (== cval len)
;;		#{}
;;		(conj (getindices (+ cval 1) len n) (rand-int n)))) 
;;		
;;
;;(defn checksize
;;	[indst len rng]
;;	(if (== (count indst) len) 
;;		indst
;;		(checksize (getindices (count indst) len rng) len rng)))  
	

;; Factorial program for testing
;;(defn fac
;;	[n]
;;	(if (n == 0) 
;;		1
;;		(* n (fac (- n 1)))))
	
