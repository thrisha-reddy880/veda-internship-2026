import java.util.Scanner;

public class BankAccount {

```
private String accountNumber;
private String holderName;
private double balance;

// Constructor
public BankAccount(String accountNumber, String holderName, double balance) {
    this.accountNumber = accountNumber;
    this.holderName = holderName;

    if (balance >= 0) {
        this.balance = balance;
    } else {
        this.balance = 0;
    }
}

// Deposit money
public void deposit(double amount) {
    if (amount <= 0) {
        System.out.println("Invalid deposit amount.");
        return;
    }

    balance += amount;
    System.out.println("Deposit successful!");
    System.out.printf("Deposited: Rs. %.2f%n", amount);
}

// Withdraw money
public void withdraw(double amount) {
    if (amount <= 0) {
        System.out.println("Invalid withdrawal amount.");
    } else if (amount > balance) {
        System.out.println("Insufficient balance.");
    } else {
        balance -= amount;
        System.out.println("Withdrawal successful!");
        System.out.printf("Withdrawn: Rs. %.2f%n", amount);
    }
}

// Display balance
public void displayBalance() {
    System.out.printf("Current balance: Rs. %.2f%n", balance);
}

// Display account details
public void displayAccountDetails() {
    System.out.println("\n------ Account Details ------");
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Account Holder: " + holderName);
    displayBalance();
    System.out.println("-----------------------------");
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("================================");
    System.out.println("     BANK ACCOUNT SYSTEM");
    System.out.println("================================");

    System.out.print("Enter account number: ");
    String accountNumber = scanner.nextLine();

    System.out.print("Enter account holder name: ");
    String holderName = scanner.nextLine();

    System.out.print("Enter opening balance: ");
    double openingBalance = scanner.nextDouble();

    if (openingBalance < 0) {
        System.out.println("Opening balance cannot be negative.");
        scanner.close();
        return;
    }

    BankAccount account =
            new BankAccount(accountNumber, holderName, openingBalance);

    int choice;

    do {
        System.out.println("\n========== BANK MENU ==========");
        System.out.println("1. Display Account Details");
        System.out.println("2. Check Balance");
        System.out.println("3. Deposit Money");
        System.out.println("4. Withdraw Money");
        System.out.println("5. Exit");
        System.out.println("===============================");

        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                account.displayAccountDetails();
                break;

            case 2:
                account.displayBalance();
                break;

            case 3:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                break;

            case 4:
                System.out.print("Enter withdrawal amount: ");
                double withdrawalAmount = scanner.nextDouble();
                account.withdraw(withdrawalAmount);
                break;

            case 5:
                System.out.println("Thank you for using our banking system!");
                break;

            default:
                System.out.println("Invalid choice. Please select 1 to 5.");
        }

    } while (choice != 5);

    scanner.close();
}
```

}
