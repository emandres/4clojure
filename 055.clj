#(into {} (map (fn [[k v]] [k (count v)]) (group-by identity %)))
