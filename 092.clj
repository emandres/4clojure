(ns p92
  (:use clojure.test))

(defn arabic
  ([roman] (arabic roman 0))
  ([roman acc] 
   (let [base-numerals {\I 1
                        \V 5
                        \X 10
                        \L 50
                        \C 100
                        \D 500
                        \M 1000}
         subtractive-numerals {"IV" 4
                               "IX" 9
                               "XL" 40
                               "XC" 90
                               "CD" 400
                               "CM" 900}]
     (if (subtractive-numerals (apply str (take 2 roman)))
       (recur (drop 2 roman)
              (+ acc (subtractive-numerals (apply str (take 2 roman)))))
       (if (base-numerals (first roman))
         (recur (next roman) 
                (+ acc (base-numerals (first roman))))
         acc)))))

(deftest base-numerals
  (is (= 1    (arabic "I")))
  (is (= 5    (arabic "V")))
  (is (= 10   (arabic "X")))
  (is (= 50   (arabic "L")))
  (is (= 100  (arabic "C")))
  (is (= 500  (arabic "D")))
  (is (= 1000 (arabic "M"))))

(deftest multiple-numerals
  (is (= 2 (arabic "II")))
  (is (= 30 (arabic "XXX"))))

(deftest subtractive-numerals
  (is (= 4 (arabic "IV"))))

(deftest example-1
  (is (= 14 (arabic "XIV"))))

(deftest exmaple-2
  (is (= 827 (arabic "DCCCXXVII"))))

(run-all-tests)
