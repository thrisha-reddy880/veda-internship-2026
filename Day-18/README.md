# 👨‍💼 Employee Lookup System Using HashMap

## 📌 Project Description

The Employee Lookup System is a console-based Java application that manages employee records using a HashMap.

Employee IDs are used as unique keys to quickly retrieve employee information.

## 🎯 Objective

To understand HashMap, key-value data structures, hashing, and employee CRUD operations.

## ✨ Features

- ➕ Add employee records
- 🔍 Search employees by ID
- ✏️ Update employee information
- 🗑️ Delete employee records
- 📋 Display all employees
- 🔑 Prevent duplicate employee IDs
- 🛡️ Validate employee information

## 🛠️ Technologies Used

- Java
- HashMap
- Object-Oriented Programming
- Encapsulation
- Scanner class

## 📂 Project Structure

```text
Day-18/
├── EmployeeLookupSystem.java
└── README.md
```

## 📄 File Description

**EmployeeLookupSystem.java**
- Defines the Employee class.
- Stores employees in a HashMap.
- Implements employee CRUD operations.
- Searches employee records using employee IDs.
- Provides a menu-driven interface.

**README.md**
- Contains project documentation and execution instructions.

## 🧠 OOP and Collection Concepts

1. **Classes and Objects:** Employee represents an employee record.
2. **Encapsulation:** Employee fields are private.
3. **HashMap:** Stores employee ID and employee object as key-value pairs.
4. **Unique Keys:** Each employee ID must be unique.
5. **CRUD Operations:** Add, search, update, and delete employee records.

## ⚙️ How It Works

1. Run the application.
2. Select an employee operation.
3. Enter the employee ID and required information.
4. The HashMap performs the selected operation.
5. View the employee details.
6. Exit the application.

## ▶️ How to Run

Compile the Java file:

```bash
javac EmployeeLookupSystem.java
```

Run the program:

```bash
java EmployeeLookupSystem
```

## 🧪 Sample Output

```text
===== EMPLOYEE LOOKUP SYSTEM =====
1. Add Employee
2. Search Employee by ID
3. Update Employee
4. Delete Employee
5. Display All Employees
6. Exit

Enter your choice: 1
Enter Employee ID: 101
Enter Employee Name: Thrisha
Enter Department: Data Science
Enter Salary: 25000

Employee added successfully!
```

## 📚 HashMap vs ArrayList

- HashMap stores data as key-value pairs.
- ArrayList stores elements in an indexed sequence.
- HashMap is useful for searching employee records using a unique ID.
- HashMap provides average O(1) lookup, insertion, and deletion when hashing is well distributed.

## 📌 Expected Outcome

A menu-driven Java application demonstrating HashMap-based employee lookup and CRUD operations.

## 👩‍💻 Developed By

Thrisha Reddy

Java Programming Track — Veda Technology Internship
