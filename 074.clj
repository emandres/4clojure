(fn [s]
  (let [squares (map * (range 1 10) (range 1 10))
        nums (map read-string (re-seq #"[0-9]+" s))]
    (apply str (interpose "," (filter #(some (partial = %) squares) nums)))))

