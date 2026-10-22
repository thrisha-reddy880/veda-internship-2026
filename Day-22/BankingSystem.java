import java.util.Scanner;
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
class InvalidAccountException extends Exception {
    public InvalidAccountException(String message) {
        super(message);
    }
}
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}
class BankAccount {
    private final String accountNumber;
    private final String accountHolder;
    private double balance;
    public BankAccount(String accountNumber, String accountHolder,
                    double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException(
                "Deposit amount must be greater than zero."
            );
        }
        balance += amount;
        System.out.println("Deposit successful!");
        System.out.printf("Updated Balance: Rs. %.2f%n", balance);
    }
    public void withdraw(double amount)
            throws InvalidAmountException,
                InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException(
                "Withdrawal amount must be greater than zero."
            );
        }
        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance! Available balance: Rs. "
                + String.format("%.2f", balance)
            );
        }
        balance -= amount;
        System.out.println("Withdrawal successful!");
        System.out.printf("Remaining Balance: Rs. %.2f%n", balance);
    }
    public void displayAccount() {
        System.out.println("\n===== ACCOUNT DETAILS =====");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.printf("Balance       : Rs. %.2f%n", balance);
    }
}
public class BankingSystem {
    private static final BankAccount account =
        new BankAccount("1001", "Rahul", 5000.00);
    public static void validateAccount(String enteredAccount)
            throws InvalidAccountException {
        if (!account.getAccountNumber().equals(enteredAccount)) {
            throw new InvalidAccountException(
                "Invalid account number! Please try again."
            );
        }
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
        int choice = 0;
        do {
            System.out.println("\n================================");
            System.out.println("       BANKING SYSTEM");
            System.out.println("================================");
            System.out.println("1. Check Account Details");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.println("================================");
            System.out.print("Enter your choice: ");
            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid menu number.");
                sc.nextLine();
                continue;
            }
            choice = sc.nextInt();
            sc.nextLine();
            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter account number: ");
                        String accNo = sc.nextLine();
                        validateAccount(accNo);
                        account.displayAccount();
                        break;
                    }
                    case 2 -> {
                        System.out.print("Enter account number: ");
                        String accNo = sc.nextLine();
                        validateAccount(accNo);
                        System.out.print("Enter deposit amount: ");
                        if (!sc.hasNextDouble()) {
                            System.out.println("Please enter a valid amount.");
                            sc.nextLine();
                            break;
                        }
                        double amount = sc.nextDouble();
                        sc.nextLine();
                        account.deposit(amount);
                        break;
                    }
                    case 3 -> {
                        System.out.print("Enter account number: ");
                        String accNo = sc.nextLine();
                        validateAccount(accNo);
                        System.out.print("Enter withdrawal amount: ");
                        if (!sc.hasNextDouble()) {
                            System.out.println("Please enter a valid amount.");
                            sc.nextLine();
                            break;
                        }
                        double amount = sc.nextDouble();
                        sc.nextLine();
                        account.withdraw(amount);
                        break;
                    }
                    case 4 ->
                        System.out.println("Thank you for using Banking System!");
                    default ->
                        System.out.println("Invalid choice! Select 1-4.");
                }
            } catch (InvalidAccountException e) {
                System.out.println("Account Error: " + e.getMessage());
            } catch (InsufficientBalanceException e) {
                System.out.println("Transaction Error: " + e.getMessage());
            } catch (InvalidAmountException e) {
                System.out.println("Amount Error: " + e.getMessage());
            }
        } while (choice != 4);
        }
    }
}
