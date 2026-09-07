# OIBSIP - Java Development Track
## Task 2 · Number Guessing Game

### Objective
A console-based game where the computer generates a random number and the
user attempts to guess it, receiving "Too High" / "Too Low" hints until they
guess correctly or run out of attempts.

### Tech Stack
Java (console application) — `java.util.Random`, `java.util.Scanner`

### How to Run
```bash
javac NumberGuessingGame.java
java NumberGuessingGame
```

### Features
- Difficulty selection at the start of every round:
  - Easy → range 1–50, 10 attempts
  - Medium → range 1–100, 7 attempts
  - Hard → range 1–200, 5 attempts
- Real-time "Too High!" / "Too Low!" / "Correct!" feedback
- Visible attempt counter each turn
- "You Lost!" message with the revealed number if attempts run out
- "Play Again" prompt after every round
- Round-by-round score summary (attempts used per round)
- Input validation for non-numeric guesses and out-of-range guesses

### Sample Run
```
Choose difficulty:
1. Easy   (1-50,  10 attempts)
2. Medium (1-100, 7 attempts)
3. Hard   (1-200, 5 attempts)
Enter choice (1-3): 2

I'm thinking of a number between 1 and 100.
You have 7 attempts. Good luck!

Attempt 1/7 - Enter your guess: 50
Too High!

Attempt 2/7 - Enter your guess: 25
Too Low!

Attempt 3/7 - Enter your guess: 37
Correct!
Round 1 Summary — guessed in 3 attempts.

Play again? (yes/no): no
Thanks for playing! Total rounds played: 1
```

### Author
Sneha R — OIBSIP Java Development Track
