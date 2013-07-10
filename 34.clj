(fn [s e] (take (- e s) (iterate inc s)))
