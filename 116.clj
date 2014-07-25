(ns p116
  (:use clojure.test))

(defn g [n]
  (let [primes (letfn [(prime-seq [known-primes candidate]
                         (if (some #(zero? (mod candidate %)) known-primes)
                           (recur known-primes (+ 2 candidate))
                           (cons candidate 
                                 (lazy-seq (prime-seq (conj known-primes candidate)
                                                      (+ 2 candidate))))))]
                 (cons 2 (prime-seq [2] 3)))
        balanced-primes (map second
                             (filter (fn [[a b c]]
                                       (= b (/ (+ a c) 2)))
                                     (partition 3 1 primes)))]
    (boolean (some #{n} (take-while (partial >= n)
                                    balanced-primes)))))

(deftest examples
  (is (false? (g 4)))
  (is (true? (g 563)))
  (is (= 1103 (nth (filter g (range)) 15))))

(run-all-tests)
