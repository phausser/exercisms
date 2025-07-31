
(ns armstrong-numbers)

(defn string-to-list [s]
  (map #(Character/getNumericValue %) (seq s)))

(defn calc-armstrong-value [s]
  (let [number-sequence (string-to-list s)
        exponent (count number-sequence)]
    (bigint (reduce +' (map #(Math/pow % exponent) number-sequence)))))

(defn armstrong? [num]
  (= (calc-armstrong-value (str num)) num))
