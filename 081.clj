(fn [& sets]
  (set (reduce (fn [a b]
                 (filter #(a %) b)) sets)))
