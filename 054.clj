(fn my-partition [x coll]
  (if (>= (count coll) x)
    (cons (take x coll) (my-partition x (drop x coll)))))
