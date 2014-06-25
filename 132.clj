(ns p132
  (:use clojure.test))

(defn f
  [o x c]
  (let [[e1 e2] c]
    (if (and e1 e2)
      (lazy-cat (if (o e1 e2)
                  [e1 x]
                  [e1])
                (f o x (rest c)))
      (if e1
        [e1]
        []))))

(deftest example-1
  (is (= '(1 :less 6 :less 7 4 3)
         (f < :less [1 6 7 4 3]))))

(deftest example-2
  (is (empty? (f > :more ()))))

(deftest example-3
  (is (= [0 1 :same 1 2 3 :same 5 8 13 :same 21]
         (take 12 (->> [0 1]
                       (iterate (fn [[a b]] [b (+ a b)]))
                       (map first)
                       (f (fn [a b]
                            (= (mod a 2) (mod b 2)))
                          :same))))))

(run-all-tests)
