(ns p131
  (:use clojure.test))
(defn f
  [& sets]
  (letfn [(power-set 
            ([s] (power-set s #{#{}}))
            ([s acc]
             (println "s " s)
             (println "acc " acc)
             (if (empty? s)
               acc
               (recur (disj s (first s))
                      (into acc (map #(conj % (first s)) acc))))))]
  (boolean
    (seq (apply clojure.set/intersection 
                (map (fn [x]
                       (into #{} (map #(apply + %) x)))
                     (map #(remove empty? (power-set %)) sets)))))))

(deftest examples
  (is (= true (f #{-1 1 99}
                 #{-2 2 888}
                 #{-3 3 777})))
  (is (= false (apply f (map hash-set (range 1 5))))))

(run-all-tests)

