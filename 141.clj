(defn g
  [trump-suit]
  (fn [cards]
    (let [lead-suit-bonus {(:suit (first cards)) 20}
          bonuses (if trump-suit
                    (assoc lead-suit-bonus trump-suit 40)
                    lead-suit-bonus)]
      (first (sort-by (fn [{:keys [suit rank]}]
                        (- (+ (or (suit bonuses) 0)
                              rank)))
                      cards)))))

