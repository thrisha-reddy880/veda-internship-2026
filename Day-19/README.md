# 📧 Unique Email Registry Using HashSet

## 📌 Project Description

The Unique Email Registry is a console-based Java application that stores and manages email addresses using a HashSet.

It prevents duplicate registrations and allows users to register, search, remove, and display email addresses.

## 🎯 Objective

To understand Java HashSet, uniqueness constraints, and set operations.

## ✨ Features

- ➕ Register email addresses
- 🛡️ Prevent duplicate registrations
- 🔍 Search emails
- 🗑️ Remove registered emails
- 📋 Display all registered emails
- 🔄 Normalize emails before storing
- ✅ Validate email format

## 🛠️ Technologies Used

- Java
- HashSet
- Set interface
- Scanner class
- Object-Oriented Programming

## 📂 Project Structure

```text
Day-19/
├── EmailRegistry.java
└── README.md
```

## 📄 File Description

**EmailRegistry.java**
- Stores registered emails in a HashSet.
- Implements registration and duplicate detection.
- Provides email search and removal.
- Displays all registered email addresses.
- Validates and normalizes user input.

**README.md**
- Documents the project and execution instructions.

## 🧠 Concepts Used

1. **HashSet:** Stores unique email addresses.
2. **Uniqueness:** Duplicate values are not stored.
3. **Normalization:** Converts emails to lowercase and removes surrounding spaces.
4. **Set Operations:** Uses add(), remove(), and contains().
5. **Validation:** Checks that the entered email has a basic email format.

## ⚙️ How It Works

1. Run the application.
2. Select an operation from the menu.
3. Enter an email address.
4. The application validates and normalizes the email.
5. HashSet checks whether the email is already registered.
6. The application adds, searches, removes, or displays the email.

## ▶️ How to Run

Compile the program:

```bash
javac EmailRegistry.java
```

Run the program:

```bash
java EmailRegistry
```

## 🧪 Sample Output

```text
===== UNIQUE EMAIL REGISTRY =====
1. Register Email
2. Remove Email
3. Search Email
4. Display All Emails
5. Exit

Enter your choice: 1
Enter email address: thrisha@example.com
Email registered successfully!

Enter your choice: 1
Enter email address: THRISHA@example.com
Email already registered! Duplicate not allowed.
```

## 📚 HashSet vs HashMap

- HashSet stores unique values.
- HashMap stores key-value pairs.
- HashSet is suitable for maintaining a unique email registry.
- HashSet is backed by a HashMap internally in Java.

## 📌 Expected Outcome

A menu-driven Java application demonstrating unique email registration and duplicate detection using HashSet.

## 👩‍💻 Developed By

Thrisha Reddy

Java Programming Track — Veda Technology Internship
