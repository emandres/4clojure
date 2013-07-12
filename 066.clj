(fn [a b]
  (if (= b 0)
    a
    (recur b (mod a b))))

