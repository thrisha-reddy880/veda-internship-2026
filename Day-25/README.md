# 📋 Log File Analyzer

## 📌 Project Overview

The Log File Analyzer is a Java console application that reads application log files and generates a summary of INFO, WARNING, and ERROR messages.

It also detects malformed log lines, displays error details, and saves the analysis report to a text file.

## 🎯 Objectives

- Practice Java file processing.
- Parse log entries line by line.
- Count different log levels.
- Identify malformed log records.
- Generate an error summary and report.

## 🛠️ Technologies Used

- Java
- File I/O
- BufferedReader and BufferedWriter
- HashMap
- ArrayList
- Regular expressions

## ✨ Features

1. **Log Parser:** Read application logs line by line.
2. **Log-Level Counts:** Count INFO, WARNING, and ERROR entries.
3. **Error Summary:** Collect and display all ERROR messages.
4. **Malformed Line Detection:** Identify lines that do not match the expected format.
5. **Report Generation:** Save statistics, errors, and malformed lines to `log_report.txt`.
6. **Exception Handling:** Handle missing input files and file access errors.

## 📂 Project Structure

```text
Day-25/
├── LogFileAnalyzer.java
├── application.log
├── log_report.txt
└── README.md
```

## ⚙️ How It Works

The application reads `application.log` using BufferedReader.

It checks each line against the expected format:

```text
YYYY-MM-DD HH:MM:SS LEVEL Message
```

The supported log levels are INFO, WARNING, and ERROR.

A HashMap stores the count for each log level. Lists store error entries and malformed lines. The program then prints the statistics and generates `log_report.txt`.

## ▶️ How to Run

### Step 1: Create the input file

Create `application.log` and add sample log entries.

### Step 2: Compile the program

```bash
javac LogFileAnalyzer.java
```

### Step 3: Run the program

```bash
java LogFileAnalyzer
```

### Step 4: View the report

Open `log_report.txt` to see the log statistics, error summary, and malformed entries.

## 📚 Concepts Learned

- Java File I/O
- BufferedReader and BufferedWriter
- HashMap and ArrayList
- String parsing
- Regular expressions
- Exception handling
- Report generation

## 📝 Conclusion

This project demonstrates how Java can analyze application logs, count message severity levels, detect malformed entries, and generate a readable report for basic log monitoring.
