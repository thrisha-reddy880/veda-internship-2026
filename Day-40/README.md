# Personal Expense & Budget Management System

## Project Overview
A Java console-based application that helps users record daily expenses, categorize transactions, manage monthly budgets and generate financial summaries.

## Objectives
- Apply Java object-oriented programming.
- Use Java collections to manage transactions.
- Implement file handling for permanent data storage.
- Handle dates using LocalDate and YearMonth.
- Implement exception handling and input validation.
- Generate monthly and category-wise expense reports.

## Technologies Used
- Java
- JDK
- Java Collections Framework
- Java File Handling
- VS Code
- Git and GitHub

## Features
1. Add expenses.
2. View all expenses.
3. Update expenses.
4. Delete expenses.
5. Search expenses by ID, description or category.
6. View expenses by category.
7. Set monthly budgets.
8. View monthly budget and remaining balance.
9. Generate monthly expense summaries.
10. Save and load records using text files.

## Expense Categories
- Food
- Transport
- Shopping
- Education
- Health
- Entertainment
- Bills
- Other

## Project Structure

```text
Day-40/
├── Expense.java
├── Category.java
├── Budget.java
├── ExpenseManager.java
├── Main.java
├── expenses.txt
├── budgets.txt
├── README.md
└── screenshots/
```

## How to Run

Compile:

```bash
javac *.java
```

Run:

```bash
java Main
```

## File Storage
- `expenses.txt` stores expense records.
- `budgets.txt` stores monthly budget records.

The application automatically loads existing records when started and saves changes when expenses or budgets are modified.

## Concepts Used
- Encapsulation
- Classes and Objects
- ArrayList
- LocalDate and YearMonth
- FileReader and FileWriter
- BufferedReader and BufferedWriter
- Exception Handling

## Future Enhancements
- Expense charts and visual analytics.
- Export reports to CSV.
- Category-specific budgets.
- Database integration.

## Project Status
Day 1 of 4 – Project Development