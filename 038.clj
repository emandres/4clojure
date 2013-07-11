(fn [& z] (reduce (fn [a b] (if (> a b) a b)) z))
