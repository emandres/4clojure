(fn [board]
  (letfn [(rows [board] board)
          (cols [board] (apply map vector board))
          (diags [board]
            (let [coords [[[0 0] [1 1] [2 2]]
                          [[0 2] [1 1] [2 0]]]]
              (map #(map (fn [[r c]]
                           (nth (nth board r) c))
                         %)
                    coords)))
          (winner? [board]
            (or (every? (partial = :x) board)
                (every? (partial = :o) board)))]
    (ffirst (filter winner? (concat (rows board)
                                    (cols board)
                                    (diags board))))))
