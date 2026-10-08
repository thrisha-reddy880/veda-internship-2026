import java.util.Scanner;

public class ATMSimulation {

    static int correctPin = 1234;
    static int balance = 5000;
    static int maxAttempts = 3;

    // PIN verification
    static boolean verifyPin(Scanner scanner) {

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {

            System.out.print("Enter your PIN: ");
            int pin = scanner.nextInt();

            if (pin == correctPin) {
                System.out.println("PIN verified successfully!");
                return true;
            }

            System.out.println("Incorrect PIN.");

            if (attempt < maxAttempts) {
                System.out.println("Attempts remaining: "
                        + (maxAttempts - attempt));
            }
        }

        System.out.println("Too many incorrect attempts.");
        System.out.println("Account locked.");

        return false;
    }

    // Check balance
    static void checkBalance() {

        System.out.println();
        System.out.println("------ BALANCE ------");
        System.out.println("Current balance: Rs. " + balance);
        System.out.println("---------------------");
    }

    // Deposit money
    static void deposit(Scanner scanner) {

        System.out.print("Enter amount to deposit: ");
        int amount = scanner.nextInt();

        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
        } else {
            balance = balance + amount;

            System.out.println("Deposit successful!");
            System.out.println("Amount deposited: Rs. " + amount);
            System.out.println("Updated balance: Rs. " + balance);
        }
    }

    // Withdraw money
    static void withdraw(Scanner scanner) {

        System.out.print("Enter amount to withdraw: ");
        int amount = scanner.nextInt();

        if (amount <= 0) {

            System.out.println("Invalid withdrawal amount.");

        } else if (amount > balance) {

            System.out.println("Insufficient balance.");

        } else {

            balance = balance - amount;

            System.out.println("Withdrawal successful!");
            System.out.println("Amount withdrawn: Rs. " + amount);
            System.out.println("Remaining balance: Rs. " + balance);
        }
    }

    // Display menu
    static void showMenu() {

        System.out.println();
        System.out.println("==========================");
        System.out.println("        ATM MENU");
        System.out.println("==========================");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.println("==========================");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================");
        System.out.println("     WELCOME TO ATM");
        System.out.println("==========================");

        // Verify PIN
        boolean loginSuccessful = verifyPin(scanner);

        if (!loginSuccessful) {
            scanner.close();
            return;
        }

        int choice;

        do {

            showMenu();

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit(scanner);
                    break;

                case 3:
                    withdraw(scanner);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        scanner.close();
    }
}
