(ns example3
  (:use [anglican emit runtime]))

(defquery example3
  (println (sample (normal 0 1))))
