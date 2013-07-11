(fn [c n] (reduce concat (map #(repeat n %) c)))
