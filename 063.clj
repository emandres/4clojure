(fn [f v]
  ((fn my-group-by [f v m]
     (if (empty? v)
       m
       (let [k (f (first v))]
         (recur f 
                (rest v)
                (assoc m k (if (contains? m k)
                             (conj (m k) (first v))
                             [(first v)]))))))
   f v {}))

