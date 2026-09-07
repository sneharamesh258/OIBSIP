import java.util.Random;
import java.util.Scanner;

/**
 * OIBSIP - Java Development Track
 * Task 2: Number Guessing Game
 *
 * The system generates a random number and the user tries to guess it,
 * receiving Too High / Too Low hints until correct or out of attempts.
 * Includes bonus difficulty levels and multi-round score tracking.
 */
public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundNumber = 1;
        boolean playAgain = true;

        System.out.println("=========================================");
        System.out.println("   WELCOME TO THE NUMBER GUESSING GAME");
        System.out.println("=========================================");

        while (playAgain) {
            System.out.println("\n----- Round " + roundNumber + " -----");
            int[] difficultySettings = chooseDifficulty(scanner);
            int upperBound = difficultySettings[0];
            int maxAttempts = difficultySettings[1];

            int targetNumber = random.nextInt(upperBound) + 1;
            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            System.out.println("I'm thinking of a number between 1 and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts. Good luck!");

            while (attemptsUsed < maxAttempts && !guessedCorrectly) {
                System.out.print("\nAttempt " + (attemptsUsed + 1) + "/" + maxAttempts + " - Enter your guess: ");
                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("That's not a valid number. Try again.");
                    continue;
                }

                attemptsUsed++;

                if (guess < 1 || guess > upperBound) {
                    System.out.println("Please guess a number within the range 1-" + upperBound + ".");
                } else if (guess < targetNumber) {
                    System.out.println("Too Low!");
                } else if (guess > targetNumber) {
                    System.out.println("Too High!");
                } else {
                    System.out.println("Correct!");
                    guessedCorrectly = true;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nYou Lost! The number was: " + targetNumber);
            } else {
                System.out.println("Round " + roundNumber + " Summary — guessed in " + attemptsUsed + " attempts.");
            }

            System.out.print("\nPlay again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
            roundNumber++;
        }

        System.out.println("\nThanks for playing! Total rounds played: " + (roundNumber - 1));
        scanner.close();
    }

    /**
     * Prompts the user to choose a difficulty level.
     * @return an array of {upperBound, maxAttempts}
     */
    private static int[] chooseDifficulty(Scanner scanner) {
        int upperBound = 100;
        int maxAttempts = 7;
        boolean validChoice = false;

        while (!validChoice) {
            System.out.println("\nChoose difficulty:");
            System.out.println("1. Easy   (1-50,  10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard   (1-200, 5 attempts)");
            System.out.print("Enter choice (1-3): ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    upperBound = 50;
                    maxAttempts = 10;
                    validChoice = true;
                    break;
                case "2":
                    upperBound = 100;
                    maxAttempts = 7;
                    validChoice = true;
                    break;
                case "3":
                    upperBound = 200;
                    maxAttempts = 5;
                    validChoice = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }

        return new int[]{upperBound, maxAttempts};
    }
}
