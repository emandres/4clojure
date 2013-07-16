(fn [n] 
  (= n (apply + (filter #(= 0 (rem n %)) (range 1 n)))))

