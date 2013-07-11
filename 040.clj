(fn [s v] (butlast (apply concat (map #(vector % s) v))))
