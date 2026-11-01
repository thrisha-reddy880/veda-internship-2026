# Day 32 – Student Grade Management System

## 📌 Project Overview

The Student Grade Management System is a menu-driven Java application designed to manage student information, subjects, marks, and academic performance.

It allows users to perform CRUD operations, calculate grades automatically, search student records, and generate academic performance summaries.

## 🎯 Objectives

- Understand Java fundamentals, classes, and objects.
- Implement CRUD operations.
- Use ArrayList to store student records.
- Manage subjects and marks.
- Calculate total marks and percentages.
- Assign grades automatically.
- Generate academic performance reports.

## 🛠️ Technologies Used

- Java
- JDK
- Object-Oriented Programming
- ArrayList
- Scanner
- Conditional Statements
- Loops
- Methods

## 📂 Project Structure

```text
Day-32/
├── Student.java
├── Subject.java
├── Grade.java
├── StudentGradeManagementSystem.java
└── README.md
```

## ✨ Features

### Student Management
- Add new students.
- View all student records.
- Search students using ID.
- Update student information.
- Delete student records.

### Subject Management
- Add subjects and marks.
- Update subject marks.
- Delete subjects.
- Validate marks and maximum marks.

### Grade Calculation
- Calculate total marks.
- Calculate percentage.
- Automatically assign grades.
- Display individual student reports.

### Performance Analytics
- Calculate average percentage.
- Identify the top-performing student.
- Count students with and without marks.
- Generate an academic performance summary.

## ⚙️ How It Works

1. The application displays a menu of available operations.
2. The user selects an operation.
3. Student records are stored using ArrayList.
4. Each student can have multiple subjects.
5. Marks are validated before being stored.
6. The Grade class calculates total marks, percentages, and grades.
7. The application generates individual reports and an overall performance summary.

## 📊 Grading System

| Percentage | Grade |
|---|---|
| 90–100 | A+ |
| 80–89 | A |
| 70–79 | B |
| 60–69 | C |
| 50–59 | D |
| Below 50 | F |

## ▶️ How to Run

Compile the Java files:

```bash
javac *.java
```

Run the application:

```bash
java StudentGradeManagementSystem
```

## 💡 Concepts Learned

- Classes and Objects
- Constructors
- Encapsulation
- ArrayList
- CRUD Operations
- Methods
- Loops and Switch Statements
- Conditional Logic
- Input Validation
- Basic Application Design

## 🔮 Future Enhancements

- Save student records permanently using files or a database.
- Add student login and administrator login.
- Generate downloadable report cards.
- Add semester-wise grade calculations.
- Create a graphical user interface.

## ✅ Conclusion

This project demonstrates the practical application of Java fundamentals and Object-Oriented Programming through a Student Grade Management System.

It provides a simple and reusable way to manage student records, calculate grades, and analyze academic performance.
