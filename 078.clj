(fn t
  ([f & args] (t (apply f args)))
  ([f] (if (fn? f)
         (recur (f))
         f)))
