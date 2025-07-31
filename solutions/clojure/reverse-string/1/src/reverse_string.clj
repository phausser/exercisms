(ns reverse-string)

(defn reverse-string [s]
  (if (empty? s)
    ""
    (str (reduce #(str %2 %1) s))))