(fn [num-primes]
  (let [is-prime (fn[n] (every? #(not= 0 (rem n %)) (range 2 (inc (/ n 2)))))]
    (take num-primes (filter is-prime (drop 2 (range))))))

