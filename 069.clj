(fn [f & maps]
  (let [merge-two (fn [x y] (reduce (fn [a [k v]] (if (contains? a k)
                                                    (conj a [k (f (a k) v)])
                                                    (conj a [k v])))
                                    x y))]
    (reduce merge-two maps)))

