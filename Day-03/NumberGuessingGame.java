import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate a random number between 1 and 100
        int secretNumber = random.nextInt(100) + 1;

        int guess = 0;
        int attempts = 0;

        System.out.println("=================================");
        System.out.println("     NUMBER GUESSING GAME");
        System.out.println("=================================");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("Try to guess it!");
        System.out.println();

        // Continue until the correct number is guessed
        while (guess != secretNumber) {

            System.out.print("Enter your guess: ");

            // Validate integer input
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
                continue;
            }

            guess = scanner.nextInt();
            attempts++;

            if (guess < secretNumber) {
                System.out.println("Higher! Try again.");
            }
            else if (guess > secretNumber) {
                System.out.println("Lower! Try again.");
            }
            else {
                System.out.println();
                System.out.println("🎉 Congratulations!");
                System.out.println("You guessed the correct number!");
                System.out.println("Number: " + secretNumber);
                System.out.println("Attempts: " + attempts);
            }
        }

        scanner.close();
    }
}
