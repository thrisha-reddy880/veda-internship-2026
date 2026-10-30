
# Day 30 – Process Employee Data Using Java Streams

## 📌 Project Overview
This project demonstrates employee data processing using Java Streams, Lambda Expressions, and the Collections Framework.

It performs filtering, sorting, grouping, transformation, and aggregation operations on employee records.

## 🎯 Objective
- Understand Java Streams.
- Learn functional-style programming.
- Perform filtering and sorting.
- Group employees by department.
- Calculate employee statistics.
- Generate a summary report.

## 🛠️ Technologies Used
- Java
- Java Streams API
- Lambda Expressions
- Collections Framework
- Comparator
- Collectors

## 📂 Project Structure
```text
Day-30/
├── Employee.java
├── EmployeeStreamDemo.java
└── README.md
```

## ✨ Features
- Display all employee records.
- Filter employees based on salary.
- Sort employees by salary.
- Convert employee names to uppercase.
- Group employees by department.
- Calculate department-wise employee count.
- Calculate total and average salary.
- Find the highest-paid employee.
- Generate an employee summary report.

## ⚙️ How It Works
1. Employee details are stored in an ArrayList.
2. The `stream()` method creates a stream from the employee collection.
3. `filter()` selects employees based on conditions.
4. `sorted()` arranges employees by salary.
5. `map()` transforms employee names.
6. `groupingBy()` groups employees by department.
7. `count()`, `sum()`, and `average()` calculate statistics.
8. `max()` identifies the highest-paid employee.

## ▶️ How to Run
```bash
javac *.java
java EmployeeStreamDemo
```

## 📊 Sample Summary
- Total Employees: 7
- Total Salary: 430000.00
- Average Salary: 61428.57
- Highest Salary: 80000.00

## 💡 Interview Questions

### 1. What is a Stream?
A Stream is a sequence of elements that supports functional-style operations for processing data.

### 2. Stream vs Collection
A Collection stores data, whereas a Stream processes data through a pipeline of operations.

### 3. What is lazy evaluation?
Intermediate Stream operations are not executed until a terminal operation is called.

### 4. Difference between map() and filter()
- `map()` transforms each element.
- `filter()` selects elements based on a condition.

## ✅ Conclusion
This project demonstrates how Java Streams simplify employee data processing through filtering, sorting, grouping, transformation, and aggregation.

