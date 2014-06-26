(fn [n a b]
  (letfn [(multiples-under-n [x]
            (quot (dec n) x))
          (sum-under-n [x]
            (let [z (multiples-under-n x)]
              (*' x (/ (*' z (inc z))
                      2))))]
    (-' (+' (sum-under-n a)
          (sum-under-n b))
      (sum-under-n (*' a b)))))
