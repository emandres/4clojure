(fn compose [& fs]
  (reduce  (fn [f e] (fn [& args] (e (apply f args)))) (reverse fs)))
