(defn f
  [s]
  (letfn [(increasing [s]
            (reduce 
              #(if (= 1  (- %2 (last %1)))
                 (conj %1 %2)
                 %1)
              [(first s)]
              (rest s)))
          (increasing-seqs [s]
            (if (not (empty? s))
              (let [i (increasing s)]
                (cons i (increasing-seqs (drop (count i) s))))))]
    (map #(vector (first %) (last %)) (increasing-seqs (distinct (sort s))))))

