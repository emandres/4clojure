(ns roman-numerals-tests
  (:use clojure.test))

(with-test
  (defn roman-numerals [n]
    (if 
      (zero? n) ""
      (let [conversions [
                         [1000 "M"]
                         [900 "CM"]
                         [500 "D"]
                         [400 "CD"]
                         [100 "C"]
                         [90 "XC"]
                         [50 "L"]
                         [40 "XL"]
                         [10 "X"]
                         [9 "IX"]
                         [5 "V"]
                         [4 "IV"]
                         [1 "I"]]
            [arabic roman] (first (filter #(>= n (first %)) conversions))]
        (str roman (roman-numerals (- n arabic))))))
  (is (= "" (roman-numerals 0)))
  (is (= "I" (roman-numerals 1)))
  (is (= "II" (roman-numerals 2)))
  (is (= "IV" (roman-numerals 4)))
  (is (= "V" (roman-numerals 5)))
  (is (= "IX" (roman-numerals 9)))
  (is (= "X" (roman-numerals 10)))
  (is (= "XL" (roman-numerals 40)))
  (is (= "L" (roman-numerals 50)))
  (is (= "XC" (roman-numerals 90)))
  (is (= "C" (roman-numerals 100)))
  (is (= "CD") (roman-numerals 400))
  (is (= "D" (roman-numerals 500)))
  (is (= "CM") (roman-numerals 900))
  (is (= "M" (roman-numerals 1000))))
(run-all-tests)
