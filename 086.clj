(fn f
  ([n] (f n #{}))
  ([n s]
   (letfn [(d [n] (map (comp read-string str) (str n)))
           (u [n] (apply + (map #(* % %) (d n))))]
     (let [x (u n)]
       (cond
         (= x 1) true
         (s x) false
         :else (recur x (conj s x)))))))
