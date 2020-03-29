;A game of tic-tac-toe implemented using clojure

(defn triple-winner? [triple]
    (if (every? #{:x} triple) :x
        (if (every? #{:o} triple) :o)))

(declare triples)

(defn winner? [board]
    (first (filter #{:x :o} (map triple-winner? (triples board)))))

(defn triples [board]
   (concat
       (partition-all 3 board)
       (list
          (take-nth 3 board)
          (take-nth 3 (drop 1 board))
          (take-nth 3 (drop 2 board))
          (take-nth 4 board)
          (take-nth 2 (drop-last 2 (drop 2 board))))))

(defn full-board? [board]
    (let [board (map #(if (keyword? %) (subs (str %) 1) %) board)]
         (println (nth board 0) (nth board 1) (nth board 2))
         (println (nth board 3) (nth board 4) (nth board 5))
         (println (nth board 6) (nth board 7) (nth board 8))))

(defn player-name [player]
    (subs (str player) 1))

(def starting-board [1 2 3 4 5 6 7 8 9])

(def player-sequence (cycle [:x :o]))

(defn get-move [board]
    (let [input (try
           (. Integer parseInt (read-line))
           (catch Exception e nil))]
         (if (some #{input} board)
              input
              nil)))

(defn take-turn [player board]
    (println "Select your move, player" (player-name player) " (press 1-9 and hit enter):")
    (loop [move (get-move board)]
        (if move
            (assoc board (dec move) player)
            (do
                (println "Move was invalid. Select your move, player" (str (player-name player) ":"))
                (recur (get-move board))))))

(defn play-game []
    (loop [board starting-board player-sequence player-sequence]
       (let [winner (winner? board)]
           (println "Current board:")
           (cond
                winner (println "Player" (player-name winner) "wins!")
                (full-board? board) (println "Game is draw.")
                :else
                   (recur
                      (take-turn (first player-sequence) board)
                      (rest player-sequence))))))

(play-game)
         
    
    

 
          