# Veda Technology Business & Service Management System

## Project Overview
A Java console-based application that represents the operations of a technology and digital-services organization.

The system manages technology services, training programs, internship programs, customer information, and customer inquiries.

## Objectives
- Apply object-oriented programming concepts.
- Implement inheritance and encapsulation.
- Manage records using Java collections.
- Implement search and filtering functionality.
- Generate basic business reports.
- Handle invalid inputs and missing records.

## Technologies Used
- Java
- JDK
- VS Code
- Git and GitHub

## Project Structure

```text
Day-36/
│
├── Offering.java
├── Service.java
├── TrainingProgram.java
├── InternshipProgram.java
├── Customer.java
├── Inquiry.java
├── BusinessManagementSystem.java
├── dataset.txt
├── README.md
│
└── screenshots/
    ├── main-menu.png
    ├── services-programs.png
    ├── customer-registration.png
    ├── inquiry-submission.png
    ├── category-search.png
    └── business-report.png
```

## Features
1. Customer registration and management.
2. Technology service management.
3. Training program management.
4. Internship program management.
5. Customer inquiry submission.
6. Search and filtering by category.
7. Inquiry search by status.
8. Business reporting.
9. Input validation and exception handling.

## OOP Concepts Used
- **Encapsulation:** Private fields with public getter methods.
- **Inheritance:** Service, TrainingProgram, and InternshipProgram inherit from Offering.
- **Abstraction:** Offering is an abstract class.
- **Polymorphism:** The display() method is overridden in different classes.
- **Collections:** ArrayList is used to store records.
- **Exception Handling:** NumberFormatException is handled for invalid numeric input.

## How to Run

1. Open the Day-34 folder in VS Code.
2. Open the terminal.
3. Compile all Java files:

```bash
javac *.java
```

4. Run the application:

```bash
java BusinessManagementSystem
```

## Sample Data
The application starts with sample services, programs, customers, and inquiries.

## Future Enhancements
- Update and delete customer records.
- Update inquiry status.
- Save data permanently using files or a database.
- Add an admin login system.
- Generate advanced business reports.

## Author
Veda Technology Java Internship Project

## Project Status
Day 2 of 4 – Project Development
