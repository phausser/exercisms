(ns rna-transcription)

(defn to-rna [dna]
  (->> dna
       (map #(case %
               \G "C"
               \C "G"
               \A "U"
               \T "A"
               (throw (AssertionError.))))
       (apply str)))

