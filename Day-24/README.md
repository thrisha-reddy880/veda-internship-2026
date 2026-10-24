# 📊 CSV Employee Data Processor

## 📌 Project Overview

The CSV Employee Data Processor is a Java console application that reads employee records from a CSV file, validates the data, calculates employee salary statistics, and generates a processed output CSV file.

The program continues processing valid records even when some records contain errors.

## 🎯 Objectives

- Understand CSV file processing.
- Practice Java File I/O.
- Validate employee records.
- Calculate employee salary statistics.
- Generate a processed CSV output file.
- Handle invalid records without crashing.

## 🛠️ Technologies Used

- Java
- CSV
- File I/O
- BufferedReader
- BufferedWriter
- ArrayList
- HashSet

## ✨ Features

1. **CSV Reader:** Read employee records from `employees.csv`.
2. **Data Validation:** Check missing fields, malformed records, duplicate IDs, and invalid salaries.
3. **Employee Statistics:** Calculate total, average, highest, and lowest salary.
4. **Output CSV:** Generate `processed_employees.csv` containing valid records.
5. **Error Handling:** Skip invalid records and display their reasons.
6. **File Handling:** Handle missing input files and file errors.

## 📂 Project Structure

```text
Day-24/
├── EmployeeDataProcessor.java
├── employees.csv
├── processed_employees.csv
└── README.md
```

## ⚙️ How It Works

The application reads the input CSV file line by line.

Each employee record is checked for:
- Correct number of fields.
- Missing employee details.
- Duplicate employee IDs.
- Numeric and non-negative salary.

Valid records are stored in an ArrayList and written to the output CSV.

The program calculates total salary, average salary, highest salary, and lowest salary using the valid employee records.

## ▶️ How to Run

### Step 1: Create the input CSV

Create `employees.csv` in the Day-24 folder and add employee records.

### Step 2: Compile the Java program

```bash
javac EmployeeDataProcessor.java
```

### Step 3: Run the program

```bash
java EmployeeDataProcessor
```

### Step 4: Check the output

Open `processed_employees.csv` to view the validated employee records.

## 📚 Concepts Learned

- Java File I/O
- CSV processing
- BufferedReader and BufferedWriter
- ArrayList and HashSet
- Data validation
- Exception handling
- Statistical calculations

## 📝 Conclusion

This project demonstrates how Java can process structured CSV data, validate employee information, calculate statistics, and generate output files while handling invalid records safely.
