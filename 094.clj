(def board
  ["      "
   " ##   "
   " ##   "
   "   ## "
   "   ## "
   "      "])

(def board2
  ["     "
   "     "
   " ### "
   "     "
   "     "])

(defn board-dimensions
  [board]
  [(count board) (count (board 0))])

(def alive-cell \#)
(def dead-cell \space)

(defn constrain
  [[r c] [mr mc]]
  (when (and (>= r 0)
             (< r mr)
             (>= c 0)
             (< c mc))
    [r c]))

(defn neighbors
  [board [r c]]
  (for [dr (range -1 2)
        dc (range -1 2)
        :when (or (not= dr 0) (not= dc 0))]
    (remove nil? (constrain [(+ r dr) (+ c dc)] (board-dimensions board)))))

(defn alive?
  [board [r c]]
  (= \# (get-in board [r c])))

(defn tick-cell
  [board r c]
  (let [neighbor-count (count (filter (partial alive? board)
                                      (neighbors board [r c])))]
    (if (alive? board [r c])
      (if (some #{neighbor-count} #{2 3}) alive-cell dead-cell)
      (if (= 3 neighbor-count) alive-cell dead-cell))))

(defn tick-board
  [board]
  (for [r (range (count board))]
    (apply str 
           (for [c (range (count (board 0)))]
             (tick-cell board r c)))))

(defn z
  [board]
  (letfn [(board-dimensions [] [(count board) (count (board 0))])
          (alive? [point] (= \# (get-in board point)))
          (constrain [[r c]]
            (let [[mr mc] (board-dimensions)]
              (when (and (>= r 0)
                         (< r mr)
                         (>= c 0)
                         (< c mc))
                [r c])))
          (neighbors [[r c]]
            (for [dr (range -1 2)
                  dc (range -1 2)
                  :when (not (and (= dr 0) (= dc 0)))]
              (remove nil? (constrain [(+ r dr) (+ c dc)]))))
          (tick-cell [point]
            (let [neighbor-count (count (filter alive? (neighbors point)))]
              (if (alive? point)
                (if (some #{neighbor-count} #{2 3}) \# \space)
                (if (= 3 neighbor-count) \# \space))))]
    (for [r (range (count board))]
      (apply str
             (for [c (range (count (board 0)))]
               (tick-cell [r c]))))))

(doseq [line (z board2)]
  (println \[ line \]))
