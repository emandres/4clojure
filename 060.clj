(fn g
  ([o [f & r]] (g o f r))
  ([o s [f & r]]
   (if f
     (cons s (lazy-seq (g o (o s f) r)))
     (list s))))
