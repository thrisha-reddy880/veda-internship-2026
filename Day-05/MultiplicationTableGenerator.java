import java.util.Scanner;

public class MultiplicationTableGenerator {

    // Generate multiplication table for one number
    static void generateTable(int number) {

        System.out.println("\nMultiplication Table of " + number);
        System.out.println("----------------------------");

        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d%n", number, i, number * i);
        }
    }

    // Generate multiplication tables for a range of numbers
    static void generateRangeTables(int start, int end) {

        for (int number = start; number <= end; number++) {

            System.out.println("\nMultiplication Table of " + number);
            System.out.println("----------------------------");

            for (int i = 1; i <= 10; i++) {
                System.out.printf("%d x %d = %d%n",
                        number, i, number * i);
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("    MULTIPLICATION TABLE GENERATOR");
        System.out.println("======================================");

        System.out.println("1. Generate table for one number");
        System.out.println("2. Generate tables for a range");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice == 1) {

            System.out.print("Enter a number: ");
            int number = scanner.nextInt();

            generateTable(number);

        } else if (choice == 2) {

            System.out.print("Enter starting number: ");
            int start = scanner.nextInt();

            System.out.print("Enter ending number: ");
            int end = scanner.nextInt();

            if (start > end) {
                System.out.println("Starting number cannot be greater than ending number.");
            } else {
                generateRangeTables(start, end);
            }

        } else {

            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
