(fn [& bs]
  (true? (and (some (true? bs)
                    (not (every? true? bs))))))
