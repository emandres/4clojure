;this doesn't work yet. It clips of the first item of the sequence
(fn longest-subsequence
  [v]
  (let [deltas (concat [1] (map - (rest v) v))
        deltas-with-index (map-indexed vector deltas)
        increasing-sequences (partition-by #(> (last %) 0) deltas-with-index)
        longest-sequence (last (sort-by count increasing-sequences))
        start-index (ffirst longest-sequence)]
    (subvec v start-index (+ start-index (count longest-sequence)))))
