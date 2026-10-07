import java.util.Scanner;

public class PrimeNumberAnalysis {

    // Check whether a number is prime
    static boolean isPrime(int number) {

        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {

            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Generate all prime numbers up to a limit
    static void generatePrimes(int limit) {

        System.out.println("\nPrime numbers up to " + limit + ":");

        boolean found = false;

        for (int number = 2; number <= limit; number++) {

            if (isPrime(number)) {
                System.out.print(number + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.print("No prime numbers found.");
        }

        System.out.println();
    }

    // Generate prime numbers within a range
    static void generateRangePrimes(int start, int end) {

        System.out.println("\nPrime numbers between " + start + " and " + end + ":");

        boolean found = false;

        for (int number = start; number <= end; number++) {

            if (isPrime(number)) {
                System.out.print(number + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.print("No prime numbers found.");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("       PRIME NUMBER ANALYSIS");
        System.out.println("======================================");

        System.out.println("1. Check whether a number is prime");
        System.out.println("2. Generate primes up to a number");
        System.out.println("3. Generate primes within a range");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice == 1) {

            System.out.print("Enter a number: ");
            int number = scanner.nextInt();

            if (isPrime(number)) {
                System.out.println(number + " is a prime number.");
            } else {
                System.out.println(number + " is not a prime number.");
            }

        } else if (choice == 2) {

            System.out.print("Enter the limit: ");
            int limit = scanner.nextInt();

            if (limit < 2) {
                System.out.println("No prime numbers exist below 2.");
            } else {
                generatePrimes(limit);
            }

        } else if (choice == 3) {

            System.out.print("Enter starting number: ");
            int start = scanner.nextInt();

            System.out.print("Enter ending number: ");
            int end = scanner.nextInt();

            if (start > end) {
                System.out.println("Starting number cannot be greater than ending number.");
            } else {
                generateRangePrimes(start, end);
            }

        } else {

            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
