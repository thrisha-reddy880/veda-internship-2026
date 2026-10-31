# Day 31 – Employee Analytics System Using Java Streams

## 📌 Project Overview
This project is a Java-based Employee Analytics System that uses Java Streams and Collectors to analyze employee records and generate useful business statistics.

## 🎯 Objective
- Apply Java Streams to a real-world business analytics problem.
- Calculate average and total salaries.
- Generate department-wise statistics.
- Identify highest- and lowest-paid employees.
- Rank employees based on salary.
- Generate a summary report.

## 🛠️ Technologies Used
- Java
- Java Streams API
- Lambda Expressions
- Collectors
- Collections Framework
- Comparator

## 📂 Project Structure
```text
Day-31/
├── Employee.java
├── EmployeeAnalyticsDemo.java
└── README.md
```

## ✨ Features
- Display all employee records.
- Department-wise employee count.
- Department-wise average salary.
- Department-wise total salary.
- Find highest-paid employee.
- Find lowest-paid employee.
- Rank employees by salary.
- Calculate overall salary statistics.
- Generate a summary report.

## ⚙️ How It Works
1. Employee records are stored in a List.
2. `groupingBy()` groups employees by department.
3. `counting()` calculates department-wise employee counts.
4. `averagingDouble()` calculates department-wise average salaries.
5. `summingDouble()` calculates total department salaries.
6. `max()` and `min()` identify the highest- and lowest-paid employees.
7. `sorted()` ranks employees by salary.
8. `sum()` and `average()` calculate overall salary statistics.

## ▶️ How to Run
```bash
javac *.java
java EmployeeAnalyticsDemo
```

## 📊 Sample Analytics
- Total Employees: 9
- Total Salary: Rs. 518000.00
- Average Salary: Rs. 57555.56
- Highest Salary: Rs. 80000.00
- Lowest Salary: Rs. 40000.00
- Departments: 4

## 💡 Interview Questions

### 1. What is Collectors.groupingBy()?
It groups stream elements based on a specified classification function and returns a Map.

### 2. How do you find the maximum salary using Streams?
Use `max()` with `Comparator.comparingDouble()`.

### 3. When should Streams not be used?
Avoid Streams when simple loops are clearer, when complex debugging is required, or when stream overhead is unnecessary for a small operation.

### 4. What is averagingDouble()?
It calculates the average of double-valued elements in a stream.

## ✅ Conclusion
This project demonstrates practical employee analytics using Java Streams, including department statistics, salary analysis, employee rankings, and report generation.
