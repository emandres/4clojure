(ns p114
  (:use clojure.test))

(defn g-take-while
  [n p [f & r]]
  (let [next-n (if (p f) (dec n) n)]
    (if (zero? next-n)
      nil
      (cons f (lazy-seq (g-take-while next-n
                                      p
                                      r))))))


(deftest example-1
  (is (= [2 3 5 7 11 13]
         (g-take-while 4 
                       #(= 2 (mod % 3)) 
                       [2 3 5 7 11 13 17 19 23]))))

(run-all-tests)
