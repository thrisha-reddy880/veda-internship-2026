# 📚 Library Management System in Java

## 📌 Project Description

The Library Management System is a console-based Java application that manages books, library members, book issuing, returns, and overdue tracking.

It uses Object-Oriented Programming (OOP) concepts and Java Collections to organize library information.

## 🎯 Objective

To apply OOP concepts and Java Collections to a practical library management application.

## ✨ Features

- 📖 Add and list books
- 👥 Register and list members
- 📤 Issue books to registered members
- 📥 Return issued books
- 📅 Track issue dates and due dates
- ⏰ Identify overdue books
- 💰 Calculate overdue fines
- 🔍 Validate book and member IDs

## 🛠️ Technologies Used

- Java
- ArrayList
- HashMap
- LocalDate
- Object-Oriented Programming
- VS Code

## 📂 Project Structure

```text
Day-16/
├── LibraryManagementSystem.java
└── README.md
```

## 📄 File Description

**LibraryManagementSystem.java**
- Contains the main menu and application logic.
- Defines the Book, Member, and IssueRecord classes.
- Manages book and member records.
- Implements issuing, returning, and overdue tracking.

**README.md**
- Documents the project, features, and execution steps.

## 🧠 OOP Concepts Used

1. **Classes and Objects:** Represent books, members, and issue records.
2. **Encapsulation:** Organizes related information and behavior into classes.
3. **Collections:** Uses HashMap for book/member lookup and ArrayList for issue records.
4. **Methods:** Separates library operations into reusable methods.

## ⚙️ How It Works

1. Add books to the library.
2. Register members.
3. Issue an available book to a registered member.
4. Return books using their IDs.
5. Check overdue books and calculated fines.
6. Exit the application.

## 📅 Library Rules

- Each book is assigned a unique ID.
- Each member is assigned a unique ID.
- The loan period is 14 days.
- The overdue fine is Rs. 2 per day.
- A book can only be issued when available.

## ▶️ How to Run

Compile the program:

```bash
javac LibraryManagementSystem.java
```

Run the application:

```bash
java LibraryManagementSystem
```

## ⚠️ Note

This beginner-level application stores records in memory. Books, members, and issue records are cleared when the program exits. Database persistence can be added in a future version.

## 📌 Expected Outcome

A menu-driven application that demonstrates book management, member management, issuing and returning books, and overdue tracking.

## 👩‍💻 Developed By

Thrisha Reddy

Java Programming Track — Veda Technology Internship
