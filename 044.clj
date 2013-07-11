(fn [x coll]
  (let [m (rem x (count coll))
        n (if (< m 0)
            (+ m (count coll))
            m)]
    (concat (drop n coll) (take n coll))))
