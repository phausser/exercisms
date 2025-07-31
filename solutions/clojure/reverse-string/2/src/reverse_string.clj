(ns reverse-string)

(defn reverse-string [s] ;; <- arglist goes here
  (reduce #(str %2 %1) "" s))