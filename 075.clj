(fn [x]
  (letfn [(gcd [a b]
            (if (zero? b)
              a
              (recur b (mod a b))))]
    (if (= 1 x)
      1
      (count (filter #(= 1 (gcd x %)) (range 1 x))))))
