(ns bob
  (:require [clojure.string :as string]))

(defn is-question? [s]
  (some? (re-find #"\?\s*$" s)))

(defn is-uppercase? [s]
  (= (string/upper-case s) s))

(defn is-nontext-only? [s]
  (nil? (re-find #"[A-Za-z]+" s)))

(defn is-whitespace-only? [s]
  (some? (re-find #"^\s*$" s)))

(defn response-for [s]
  (cond
    (and (is-question? s) (is-uppercase? s) (not (is-nontext-only? s)))
    "Calm down, I know what I'm doing!"
    (and (is-uppercase? s) (not (is-nontext-only? s)))
    "Whoa, chill out!"
    (is-question? s)
    "Sure."
    (is-whitespace-only? s)
    "Fine. Be that way!"
    :else
    "Whatever."))
