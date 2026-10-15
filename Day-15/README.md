# 💳 Payment System Using Interfaces

## 📌 Project Description

The Payment System is a simple Java console application that demonstrates how interfaces can be used to implement different payment methods.

It supports simulated Card, UPI, and Wallet payments using a common `PaymentMethod` interface.

## 🎯 Objective

To understand Java interfaces, multiple implementations, loose coupling, and input validation.

## ✨ Features

- 💳 Card payment simulation
- 📱 UPI payment simulation
- 👛 Wallet payment simulation
- 💰 Amount validation
- 🛡️ Invalid payment option handling
- 💵 Wallet balance checking and updating
- ♻️ Common payment interface

## 🛠️ Technologies Used

- Java
- Interfaces
- Polymorphism
- Method overriding
- Scanner class

## 📂 Project Structure

```text
Day-15/
├── PaymentSystem.java
└── README.md
```

## 📄 File Description

**PaymentSystem.java**
- Defines the PaymentMethod interface.
- Implements CardPayment, UPIPayment, and WalletPayment.
- Validates the payment option and amount.
- Processes simulated payments.
- Displays payment status and wallet balance.

**README.md**
- Describes the project, features, implementation, and execution steps.

## 🧠 OOP Concepts Used

1. **Interface:** PaymentMethod defines a common `pay()` method.
2. **Implementation:** CardPayment, UPIPayment, and WalletPayment implement the interface.
3. **Polymorphism:** A PaymentMethod reference can hold different payment objects.
4. **Method Overriding:** Each payment class provides its own implementation of `pay()`.
5. **Loose Coupling:** The main program works with the interface instead of depending on a specific payment class.

## ⚙️ How It Works

1. Run the application.
2. Select Card, UPI, or Wallet.
3. Enter the payment amount.
4. The application validates the selection and amount.
5. The selected payment method processes the simulated transaction.
6. Wallet payments check and update the available balance.

## ▶️ How to Run

Compile the Java file:

```bash
javac PaymentSystem.java
```

Run the application:

```bash
java PaymentSystem
```

## 🧪 Sample Output

```text
===== PAYMENT SYSTEM =====
1. Card Payment
2. UPI Payment
3. Wallet Payment
Choose payment method: 2
Enter payment amount: 1500
Payment of Rs. 1500.00 processed using UPI.
```

## ⚠️ Note

This is an educational simulation. It does not connect to a real bank, payment gateway, card network, or UPI service. The wallet starts with a sample balance of Rs. 5000 for each program run.

## 📌 Expected Outcome

A menu-driven Java application demonstrating interfaces and multiple payment implementations.

## 👩‍💻 Developed By

Thrisha Reddy

Java Programming Track — Veda Technology Internship
