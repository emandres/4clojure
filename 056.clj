(fn [coll]
  (reduce (fn [a b] (if (some #(= % b) a) a (conj a b))) [] coll))
