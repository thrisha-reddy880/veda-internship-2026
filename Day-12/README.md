# 👨‍💼 Employee Hierarchy Using Inheritance

## 📌 Project Description

The Employee Hierarchy project is a simple Java application that demonstrates inheritance and code reuse using Object-Oriented Programming (OOP).

It contains a base `Employee` class and three specialized classes: `Developer`, `Manager`, and `Intern`.

## 🎯 Objective

To understand inheritance, the `extends` keyword, constructor chaining, and method overriding in Java.

## ✨ Features

- 👤 Base Employee class with common properties
- 💻 Developer class with programming language details
- 👔 Manager class with team size
- 🎓 Intern class with internship duration
- ♻️ Reuse common properties and methods
- 🔄 Override methods for specialized behavior
- 📋 Display details for all employee types

## 🛠️ Technologies Used

- Java
- Object-Oriented Programming
- Inheritance
- Method Overriding
- VS Code / Command Prompt

## 📂 Project Structure

```text
Day-12/
├── Employee.java
├── Developer.java
├── Manager.java
├── Intern.java
├── EmployeeHierarchyDemo.java
└── README.md
```

## 📄 File Description

- **Employee.java:** Defines common employee properties and methods.
- **Developer.java:** Extends Employee and adds programming language details.
- **Manager.java:** Extends Employee and adds team size.
- **Intern.java:** Extends Employee and adds internship duration.
- **EmployeeHierarchyDemo.java:** Creates objects and demonstrates inheritance and method overriding.
- **README.md:** Documents the project and instructions.

## 🧠 OOP Concepts Used

1. **Inheritance:** Child classes reuse the properties and methods of the Employee class.
2. **Method Overriding:** Each child class provides its own implementation of `work()` and `displayDetails()`.
3. **Constructor Chaining:** The `super()` keyword calls the parent class constructor.
4. **Polymorphism:** Parent-class references are used to refer to Developer, Manager, and Intern objects.

## ⚙️ How It Works

1. The Employee class defines common employee details.
2. Developer, Manager, and Intern extend the Employee class.
3. Each child class adds its own specialized field.
4. Overridden methods display role-specific information.
5. The main program creates objects and displays their details.

## ▶️ How to Run

Compile all Java files:

```bash
javac Employee.java Developer.java Manager.java Intern.java EmployeeHierarchyDemo.java
```

Run the main program:

```bash
java EmployeeHierarchyDemo
```

## 📌 Expected Outcome

The program displays the details and work behavior of a Developer, Manager, and Intern, demonstrating inheritance and code reuse.

## 👩‍💻 Developed By

Thrisha Reddy

Java Programming Track — Veda Technology Internship
