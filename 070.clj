(fn [s](->> s(re-seq #"\w+") (sort-by clojure.string/lower-case)))
