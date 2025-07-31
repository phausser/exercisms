(ns bob
  (:require [clojure.string :as string]))

(defn is-question? [s]
  (some? (re-find #"\?\s*$" s)))

(defn is-uppercase? [s]
  (= (string/upper-case s) s))

(defn has-letters? [s]
  (some? (re-find #"[A-Za-z]+" s)))

(defn is-yelling? [s]
  (and (is-uppercase? s) (has-letters? s)))

(defn is-whitespace-only? [s]
  (some? (re-find #"^\s*$" s)))

(defn response-for [s]
  (cond
    (and (is-question? s) (is-yelling? s))
    "Calm down, I know what I'm doing!"
    (is-yelling? s)
    "Whoa, chill out!"
    (is-question? s)
    "Sure."
    (is-whitespace-only? s)
    "Fine. Be that way!"
    :else
    "Whatever."))
