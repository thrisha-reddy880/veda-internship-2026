# 👨‍💼 Employee Management System Using OOP

## 📌 Project Overview

The Employee Management System is a simple Java console application developed using Object-Oriented Programming (OOP) concepts.

It helps users manage employee records by adding, searching, updating, and displaying employee details.

## 🎯 Objectives

- Understand classes and objects.
- Implement constructors and methods.
- Apply encapsulation using private fields.
- Perform basic employee record management.

## ✨ Features

- **Add Employee:** Create a new employee record with a unique ID.
- **Search Employee:** Find an employee using their ID.
- **Update Employee:** Modify employee name, department, and salary.
- **List Employees:** Display all employee records.
- **Duplicate ID Validation:** Prevent duplicate employee IDs.
- **Input Validation:** Handle invalid menu choices and salary inputs.
- **Exit:** Close the application safely.

## 🛠️ Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- Scanner class
- VS Code
- JDK

## 📂 Project Structure

```text
Day-11/
├── Employee.java
├── EmployeeManagementSystem.java
└── README.md
```

## 📄 File Description

- **Employee.java:** Defines employee properties, constructor, getter methods, update method, and display method.
- **EmployeeManagementSystem.java:** Contains the main menu and operations for managing employee records.
- **README.md:** Documents the project, features, and execution steps.

## 🧠 OOP Concepts Used

### 1. Class
The `Employee` class defines the properties and behavior of an employee.

### 2. Object
Each employee record is created as an object of the `Employee` class.

### 3. Constructor
The constructor initializes employee ID, name, department, and salary.

### 4. Encapsulation
Employee fields are declared `private` and accessed through public getter methods and update methods.

### 5. Methods
Methods perform operations such as adding, searching, updating, and displaying employee details.

## ⚙️ How It Works

1. Run the application.
2. Select an option from the menu.
3. Enter employee details to add a record.
4. Search or update a record using its employee ID.
5. Select the listing option to view all employees.
6. Choose Exit to close the program.

## ▶️ How to Run

Make sure Java JDK is installed.

Open the terminal in the `Day-11` folder and execute:

```bash
javac Employee.java EmployeeManagementSystem.java
```

Then run the application:

```bash
java EmployeeManagementSystem
```

## 📌 Limitations

Employee records are stored in memory using an `ArrayList`. They are cleared when the application exits. Database or file storage can be added in a future version.

## 🚀 Future Enhancements

- Save employee records to a file or database.
- Add employee deletion functionality.
- Add sorting and filtering.
- Develop a graphical user interface.

## ✅ Conclusion

This project demonstrates how Java OOP concepts can be applied to a practical business problem. It provides basic employee record management through a simple, menu-driven console application.

**Task:** Day 11 – Employee Management System Using OOP  
**Track:** Java Programming  
**Organization:** Veda Technology
