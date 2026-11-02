# Student Grade Management System

## 📌 Project Overview

The Student Grade Management System is a menu-driven Java application designed to manage student records, subjects, marks, grades, and academic performance.

It allows users to add, view, search, update, and delete student records while automatically calculating total marks, percentages, and grades.

## 🎯 Objectives

- Learn Java fundamentals, classes, and objects.
- Implement CRUD operations.
- Use ArrayList to store student records.
- Manage subjects and marks.
- Calculate total marks and percentages.
- Assign grades automatically.
- Generate academic performance summaries.

## 🛠️ Technologies Used

- Java
- JDK
- Object-Oriented Programming
- ArrayList
- Scanner
- Conditional Statements
- Loops and Methods

## 📂 Project Structure

```text
Day-33/
│
├── Student.java
├── Subject.java
├── Grade.java
├── StudentGradeManagementSystem.java
├── README.md
│
└── screenshots/
    ├── main-menu.png
    ├── add-student.png
    ├── add-subject-marks.png
    ├── student-report.png
    └── performance-summary.png
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
- Validate marks.

### Grade Calculation
- Calculate total marks.
- Calculate percentage.
- Automatically assign grades.
- Display individual student reports.

### Performance Analytics
- Calculate average percentage.
- Identify the top-performing student.
- Count students with and without marks.
- Generate academic performance summaries.

## 📊 Grading System

| Percentage | Grade |
|---|---|
| 90–100 | A+ |
| 80–89 | A |
| 70–79 | B |
| 60–69 | C |
| 50–59 | D |
| Below 50 | F |

## ⚙️ How It Works

1. The application displays a menu of operations.
2. Users select an operation.
3. Student records are stored using ArrayList.
4. Each student can have multiple subjects.
5. Marks are validated before storage.
6. The Grade class calculates total marks, percentages, and grades.
7. The application generates individual reports and performance summaries.

## ▶️ How to Run

Compile all Java files:

```bash
javac *.java
```

Run the application:

```bash
java StudentGradeManagementSystem
```
## Screenshots

### Main Menu
![Main Menu](screenshots/main-menu.png)

### Student Report
![Student Report](screenshots/student-report.png)

### Performance Summary
![Performance Summary](screenshots/performance-summary.png)

## 💡 Java Concepts Learned

- Classes and Objects
- Constructors
- Encapsulation
- ArrayList
- CRUD Operations
- Methods
- Loops
- Switch Statements
- Conditional Logic
- Input Validation

## 🔮 Future Enhancements

- Database integration.
- Student and administrator login.
- GUI using Java Swing or JavaFX.
- PDF report card generation.
- Permanent student record storage.

## ✅ Conclusion

This project demonstrates the practical implementation of Java fundamentals and Object-Oriented Programming through a Student Grade Management System.

It provides an easy way to manage student information, calculate grades, and analyze academic performance.
