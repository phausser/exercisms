
(ns armstrong-numbers)

(defn calc-armstrong-value [num]
  (let [number-chars (str num)
        exponent (count number-chars)]
    (->> number-chars
         (map #(Long/parseLong (str %)))
         (map #(Math/pow % exponent))
         (reduce +))))

(defn armstrong? [num]
  (= (calc-armstrong-value num) num))
