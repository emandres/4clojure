(defn k-combinations
  [n s]
  (letfn [(powerset [s]
            (apply clojure.set/union
                   #{s}
                   (map #(powerset (disj s %)) s)))]
    (set (filter #(= n (count %)) (powerset s)))))

(println (k-combinations 1 #{4 5 6}))
