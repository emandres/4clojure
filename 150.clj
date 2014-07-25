(ns p150
  (:require [clojure.test :refer :all]))
; 1 2 3 ...             ; 1 + [], 2 + [], 3 + [] ...
; 11 22 33 ...          ; 1 + 1, 2 + 2, 3 + 3 ...
;; 101 111 121 ...      ; 10 + 1, 11 + 1, 12 + 1 ...
;; 1001 1111 1221 ...

(defn even-digit-palindrome
  {:test (fn []
           (is (= 11 (even-digit-palindrome 1)))
           (is (= 1221 (even-digit-palindrome 12))))}

  [n]
  (read-string (str n (clojure.string/reverse (str n)))))

(defn odd-digit-palindrome
  {:test (fn []
           (is (= 1 (odd-digit-palindrome 1)))
           (is (= 111 (odd-digit-palindrome 11)))
           (is (= 12321 (odd-digit-palindrome 123))))}
  [n]
  (read-string (str n
                    (subs (clojure.string/reverse (str n))
                          1))))

(defn power-10
  {:test (fn []
           (is (= 1 (power-10 0)))
           (is (= 10 (power-10 1)))
           (is (= 100 (power-10 2))))}
  [exp]
  (apply * (take exp (repeat 10))))

(defn palindrome-seq
  {:test (fn []
           (is (= (concat (range 10) [11 22 33 44 55 66 77 88 99 101])
                  (take 20 (palindrome-seq))))
           (map #(is (some #{%} (palindrome-seq)))
                [1001 2002 12321 45654]))}
  ([] (concat [0] (palindrome-seq 0)))
  ([n] (let [start (power-10 n)
             end (power-10 (inc n))]
         (lazy-cat (map odd-digit-palindrome (range start end))
                   (map even-digit-palindrome (range start end))
                   (palindrome-seq (inc n))))))

(defn palindromes
  {:test (fn []
           (is (= [0 1 2 3 4 5 6 7 8 9 11 22 33 44 55 66 77 88 99 101 111 121 131 141 151 161]
                  (take 26 (palindromes 0)))))}
  [begin]
  (drop-while (partial < begin)
              (palindrome-seq)))

(defn z
  [begin]
  (letfn [(even-digit-palindrome [n]
            (read-string (str n (clojure.string/reverse (str n)))))
          (odd-digit-palindrome [n]
            (read-string (str n (subs (clojure.string/reverse (str n))
                                      1))))
          (power-10 [exp] (apply * (take exp (repeat 10))))
          (palindrome-seq
            ([] (concat [0] (palindrome-seq 0)))
            ([n] (let [start (power-10 n)
                       end (power-10 (inc n))]
                   (lazy-cat (map odd-digit-palindrome (range start end))
                             (map even-digit-palindrome (range start end))
                             (palindrome-seq (inc n))))))]
    (drop-while (partial > begin) (palindrome-seq (quot (count (str begin)) 2)))))

(println (take 26 (z 0)))
