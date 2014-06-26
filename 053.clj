(ns p53
  (:use clojure.test))

(defn f [s]
  (letfn [(incr [acc s]
            (if (and (seq s) (> (first s) (last acc)))
              (recur (conj acc (first s)) (rest s))
              acc))
          (increasing [[h & r]] (incr [h] r))
          (increasing-subseqs [s]
            (if (seq s)
              (let [t (increasing s)]
                (cons t (increasing-subseqs (drop (count t) s))))
              []))]
    (let [t (increasing-subseqs s)
          max-count (max 2 (apply max (map count t)))]
      (or (first (filter #(= max-count (count %)) 
                         t)) 
          []))))

(deftest example-1
  (is (= (f [1 0 1 2 3 0 4 5]) [0 1 2 3])))

(run-all-tests)
