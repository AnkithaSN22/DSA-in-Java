package numbergessinggame;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList; 

public class NumberGuessingGame {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Variables to track stats
        int totalGames = 0;
        int totalWins = 0;
        int bestAttempts = Integer.MAX_VALUE;

        // Game loop to allow replay
        boolean playAgain = true;
        while (playAgain) {
            totalGames++;  // Increment total games played

            // Ask the user to select a difficulty level
            int upperBound = 0;
            int maxAttempts = 0;

            // Difficulty Levels
            System.out.println("\nChoose your difficulty level: ");
            System.out.println("1. Easy (1 to 50, 10 attempts)");
            System.out.println("2. Medium (1 to 100, 8 attempts)");
            System.out.println("3. Hard (1 to 200, 6 attempts)");

            System.out.print("Enter your choice (1/2/3): ");
            int choice = scanner.nextInt();

            // Setting the difficulty levels
            switch (choice) {
                case 1: upperBound = 50; maxAttempts = 10; break;
                case 2: upperBound = 100; maxAttempts = 8; break;
                case 3: upperBound = 200; maxAttempts = 6; break;
                default:
                    System.out.println("Invalid choice! Defaulting to Medium difficulty.");
                    upperBound = 100; maxAttempts = 8;
                    break;
            }

            // Generate a random number within the selected range
            int targetNumber = random.nextInt(upperBound) + 1;
            int attemptsLeft = maxAttempts;
            boolean correctGuess = false;

            // List to track previous guesses
            ArrayList<Integer> guessHistory = new ArrayList<>();

            // Game loop for the current game
            while (attemptsLeft > 0 && !correctGuess) {
                System.out.println("\nYou have " + attemptsLeft + " attempts remaining.");
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attemptsLeft--;
                guessHistory.add(userGuess);

                // Check if the user's guess is correct, too high, or too low
                if (userGuess < targetNumber) {
                    printMessage("Your guess is low!", "red");
                } else if (userGuess > targetNumber) {
                    printMessage("Your guess is high!", "red");
                } else {
                    printMessage("Congratulations! You've guessed the correct number " + targetNumber + " in " + (maxAttempts - attemptsLeft) + " attempts!", "blue");
                    correctGuess = true;
                    totalWins++;  // Increment wins
                    bestAttempts = Math.min(bestAttempts, maxAttempts - attemptsLeft);  // Update best attempts if it's the new best
                }

                // Provide more detailed hints if the guess is wrong
                if (attemptsLeft > 0 && !correctGuess) {
                    if (userGuess < targetNumber) {
                        printMessage("Hint: Try a higher number!", "yellow");
                    } else {
                        printMessage("Hint: Try a lower number!", "yellow");
                    }

                    // Adding a "warmer" or "colder" hint
                    if (guessHistory.size() > 1) {
                        int lastGuess = guessHistory.get(guessHistory.size() - 2);
                        if (Math.abs(targetNumber - userGuess) < Math.abs(targetNumber - lastGuess)) {
                            printMessage("You're getting warmer!", "green");
                        } else {
                            printMessage("You're getting colder.", "blue");
                        }
                    }
                }
            }

            // If the player runs out of attempts without guessing the correct number
            if (!correctGuess) {
                printMessage("Sorry, you've run out of attempts! The correct number was " + targetNumber + ".", "red");
            }

            // Ask the player if they want to play again
            playAgain = askToPlayAgain(scanner);

            // Offer to reset stats or view them
            int statsChoice = askForStatsChoice(scanner);
            switch (statsChoice) {
                case 1:
                    printStats(totalGames, totalWins, bestAttempts);
                    break;
                case 2:
                    totalGames = 0;
                    totalWins = 0;
                    bestAttempts = Integer.MAX_VALUE;
                    printMessage("Stats have been reset.", "blue");
                    break;
                case 3:
                    playAgain = false;
                    break;
                default:
                    printMessage("Invalid choice, exiting game.", "red");
                    playAgain = false;
            }
        }
        printMessage("Thanks for playing.", "blue");
    }

    // Helper method for colored output messages
    public static void printMessage(String message, String color) {
        String colorCode;
        switch (color.toLowerCase()) {
            case "red": colorCode = "\u001B[31m"; break;
            case "blue": colorCode = "\u001B[34m"; break;
            case "green": colorCode = "\u001B[32m"; break;
            case "yellow": colorCode = "\u001B[33m"; break;
            default: colorCode = ""; break;
        }
        System.out.println(colorCode + message + "\u001B[0m");
    }

    // Helper method for asking if the user wants to play again
    public static boolean askToPlayAgain(Scanner scanner) {
        System.out.print("\nDo you want to play again? (yes/no): ");
        String replay = scanner.next().toLowerCase();
        return replay.equals("yes");
    }

    // Helper method to ask for stats choice
    public static int askForStatsChoice(Scanner scanner) {
        System.out.println("\nWould you like to view your stats or reset them?");
        System.out.println("1. View Stats");
        System.out.println("2. Reset Stats");
        System.out.println("3. Quit");
        System.out.print("Enter your choice (1/2/3): ");
        return scanner.nextInt();
    }

    // Helper method to print stats
    public static void printStats(int totalGames, int totalWins, int bestAttempts) {
        System.out.println("\nStats: ");
        System.out.println("Total Games Played: " + totalGames);
        System.out.println("Total Wins: " + totalWins);
        System.out.println("Best Performance (fewest attempts): " + (bestAttempts == Integer.MAX_VALUE ? "N/A" : bestAttempts));
    }

}
