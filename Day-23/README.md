# 🎓 File-Based Student Record System

## 📌 Project Overview

The File-Based Student Record System is a Java console application that stores and manages student information using file handling.

It allows users to create, read, search, and update student records. The records are stored in a text file and remain available after the program is closed.

## 🎯 Objectives

- Understand Java File I/O.
- Store student records permanently.
- Perform record creation and retrieval.
- Search records using Student ID.
- Update existing student details.
- Handle missing files and input errors.

## 🛠️ Technologies Used

- Java
- File I/O
- FileReader and FileWriter
- BufferedReader and BufferedWriter
- Scanner
- try-with-resources

## ✨ Features

1. **Add Student:** Store Student ID, name, course, and marks.
2. **View All Students:** Display all records stored in the file.
3. **Search Student:** Find a student using their ID.
4. **Update Student:** Modify the name, course, or marks of an existing student.
5. **Persistent Storage:** Records remain saved after the program exits.
6. **Input Validation:** Prevent duplicate IDs and invalid marks.

## 📂 Project Structure

```text
Day-23/
├── StudentRecordSystem.java
├── students.txt
└── README.md
```

## ⚙️ How It Works

The program stores each student record in the following format:

```text
StudentID|Name|Course|Marks
```

For example:

```text
101|Rahul|CSE|85.5
```

- `FileWriter` writes records to the file.
- `BufferedReader` reads records line by line.
- `findStudent()` searches for a matching Student ID.
- `updateStudent()` replaces the selected record while preserving other records.
- try-with-resources automatically closes file streams.

## ▶️ How to Run

### Step 1: Open the terminal

Navigate to the Day-23 folder.

### Step 2: Compile the program

```bash
javac StudentRecordSystem.java
```

### Step 3: Run the application

```bash
java StudentRecordSystem
```

## 🧪 Sample Output

```text
STUDENT RECORD SYSTEM

1. Add Student Record
2. View All Students
3. Search Student
4. Update Student Record
5. Exit

Enter your choice: 1

Enter Student ID: 101
Enter Student Name: Rahul
Enter Student Course: CSE
Enter Student Marks: 85.5

Student record added successfully!
```

## 📚 Concepts Learned

- Java File Handling
- FileReader and FileWriter
- BufferedReader and BufferedWriter
- try-with-resources
- Persistent data storage
- Record searching and updating
- Exception handling

## 📝 Conclusion

This project demonstrates how Java file handling can be used to build a simple student record management system. It supports persistent storage and basic record operations without requiring a database.
