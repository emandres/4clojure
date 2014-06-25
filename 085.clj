(ns p085
  (:use clojure.test))

(defn power-set 
  ([s] (power-set s #{#{}}))
  ([s acc]
   (if (empty? s)
     acc
     (recur (disj s (first s))
            (into acc (map #(conj % (first s)) acc))))))


(deftest empty-set
  (is (= #{#{}} (power-set #{}))))

(deftest one-item
  (is (= #{#{} #{1}} (power-set #{1}))))

(deftest two-items
  (is (= #{#{} #{1} #{2} #{1 2}} (power-set #{1 2}))))

(deftest large-test
  (is (= (count (power-set (into #{} (range 10)))) 1024)))

(run-all-tests)

