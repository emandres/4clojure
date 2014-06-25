(fn [w]
  (set (filter #(> (count %)
                   1)
               (map (comp set second)
                    (group-by sort w)))))
