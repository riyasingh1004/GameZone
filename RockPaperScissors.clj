;A rock paper scissors game using clojure.



(defn get-guess []

  (println "Make your guess: 
            r-for rock, p-for paper, s-for scissors")
  (let [guess (read-line)]
      (if (get {"r" true "p" true "s" true} guess) guess)))


(defn winner [guess1 guess2]
    (let [guesses [guess1 guess2]]
        (cond
            (= guess1 guess2) 0
            (= guesses ["p" "r"]) 1
            (= guesses ["r" "p"]) 2
            (= guesses ["r" "s"]) 1
            (= guesses ["s" "r"]) 2
            (= guesses ["s" "p"]) 1
            (= guesses ["p" "s"]) 2)))
     
(defn make-guess []
    (let [computer-guess (rand-nth ["r" "p" "s"])
            player-guess (get-guess)
            winner (winner computer-guess player-guess)]
         (println "The computer guessed:" computer-guess)
         (println "You guessed:" player-guess)
         (cond
             (= player-guess nil) (println "Your entry was inavlid.")
             (= winner 0) (println "Game tied!")
             (= winner 1) (println "Computer wins!")
             (= winner 2) (println "Player wins!"))))

(loop []
   (make-guess)
   (recur))
    
    
