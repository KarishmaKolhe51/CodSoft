import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 5; // Limit the number of attempts
    private static final int MAX_ROUNDS = 3; // Limit the number of rounds

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        for (int round = 1; round <= MAX_ROUNDS; round++) {
            int randomNumber = generateRandomNumber();
            int roundScore = playRound(randomNumber, scanner);
            totalScore += roundScore;

            System.out.println("Round " + round + " score: " + roundScore);

            if (round < MAX_ROUNDS && playAgain(scanner)) {
                continue;
            } else {
                break;
            }
        }

        System.out.println("Thank you for playing! \nYour total score is: " + totalScore);
        scanner.close();
    }

    private static int generateRandomNumber() {
        return new Random().nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
    }

    private static int playRound(int correctNumber, Scanner scanner) {
        int attempts = 0;

        System.out.println("\nGuess the number between " + MIN_RANGE + " and " + MAX_RANGE);

        while (attempts < MAX_ATTEMPTS) {
            int userGuess = getUserInput(scanner, "Enter your guess: ");
            attempts++;

            if (userGuess == correctNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                return MAX_ATTEMPTS - attempts + 1;
            } else {
                System.out.println(userGuess < correctNumber ? "Too low! Try again." : "Too high! Try again.");
            }
        }

        System.out.println(
                "Sorry, you've reached the maximum number of attempts. The correct number was: " + correctNumber);
        return 0;
    }

    private static int getUserInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    private static boolean playAgain(Scanner scanner) {
        System.out.print("Do you want to play the next round? (yes/no): ");
        return scanner.next().equalsIgnoreCase("yes");
    }
}
