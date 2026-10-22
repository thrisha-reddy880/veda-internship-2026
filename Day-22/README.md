# 🏦 Banking System with Custom Exception Handling

## 📌 Project Overview

The Banking System is a Java console application that demonstrates custom exception handling through basic banking operations.

It handles invalid accounts, insufficient balance, and invalid transaction amounts using application-specific exceptions.

## 🎯 Objectives

- Understand Java exception handling.
- Create custom exception classes.
- Handle banking transaction errors.
- Display meaningful error messages.
- Prevent invalid transactions.

## 🛠️ Technologies Used

- Java
- Exception
- try-catch
- Custom Exceptions
- Scanner

## ✨ Features

1. **Check Account Details:** View account number, account holder, and balance.
2. **Deposit Money:** Add money to the account.
3. **Withdraw Money:** Withdraw money after checking the balance.
4. **Invalid Account Handling:** Reject incorrect account numbers.
5. **Insufficient Balance Handling:** Prevent withdrawals greater than the available balance.
6. **Invalid Amount Handling:** Reject zero or negative transaction amounts.

## 📂 Project Structure

```text
Day-22/
├── BankingSystem.java
└── README.md
```

## ⚙️ How It Works

The application uses three custom exceptions:

- `InvalidAccountException` — thrown for an incorrect account number.
- `InsufficientBalanceException` — thrown when the withdrawal exceeds the balance.
- `InvalidAmountException` — thrown for zero or negative transaction amounts.

The exceptions are caught using try-catch blocks, and the appropriate error messages are displayed.

## ▶️ How to Run

### Step 1: Open the terminal

Navigate to the Day-22 folder.

### Step 2: Compile the program

```bash
javac BankingSystem.java
```

### Step 3: Run the application

```bash
java BankingSystem
```

## 🧪 Sample Output

```text
BANKING SYSTEM

1. Check Account Details
2. Deposit Money
3. Withdraw Money
4. Exit

Enter your choice: 3
Enter account number: 1001
Enter withdrawal amount: 8000

Transaction Error: Insufficient balance!
Available balance: Rs. 5000.00
```

## 📚 Concepts Learned

- Exception handling
- try-catch blocks
- Custom exception classes
- Checked exceptions
- throw and throws
- Banking transaction validation
- Object-oriented programming

## 📝 Conclusion

This project demonstrates how custom exceptions improve error handling in Java applications. They help prevent invalid banking operations and provide clear messages when a transaction cannot be completed.
