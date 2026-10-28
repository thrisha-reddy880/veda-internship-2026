# Day 28 – Multithreaded File Search Tool

## 📌 Project Overview
A Java application that searches multiple files for a given keyword using sequential processing and multithreading.

## 🎯 Objective
- Apply concurrency to file processing.
- Search files for matching keywords.
- Display matching filenames, line numbers, and content.
- Compare sequential and multithreaded execution times.

## 🛠️ Technologies Used
- Java
- ExecutorService
- Callable and Future
- Java File I/O
- Multithreading

## 📂 Project Structure
```text
Day-28/
├── FileSearchTool.java
├── sample-files/
│   ├── java.txt
│   ├── threads.txt
│   └── programming.txt
└── README.md
```

## ✨ Features
- Searches all readable files in a directory, including subdirectories.
- Performs case-insensitive keyword matching.
- Displays matching filenames and line numbers.
- Uses a fixed-size thread pool.
- Compares sequential and parallel search performance.
- Verifies that both approaches return identical results.
- Handles invalid directories and empty keywords.

## ⚙️ How It Works
1. The user enters a directory and a search keyword.
2. The application collects the files in the directory.
3. Sequential search processes the files one at a time.
4. Multithreaded search uses ExecutorService to distribute file-search tasks across a bounded thread pool.
5. Matching lines are collected using Future results.
6. Execution times and result verification are displayed.

## ▶️ How to Run
```bash
javac FileSearchTool.java
java FileSearchTool
```

Enter the directory path or press Enter to use `sample-files`. Then enter the keyword.

## 📊 Performance Comparison
The application measures both sequential and multithreaded execution.

Multithreading may improve performance for larger workloads. For a small number of small files, thread creation and coordination overhead may make it slower.

## 💡 Interview Questions

### 1. What is ExecutorService?
ExecutorService manages a pool of worker threads and executes submitted tasks.

### 2. Why should thread pools be used?
Thread pools reuse a limited number of threads, reducing overhead and preventing uncontrolled thread creation.

### 3. What is thread starvation?
Thread starvation occurs when a task cannot obtain sufficient execution time or access to the resources it needs because other tasks occupy them.

### 4. Why is creating thousands of threads a bad idea?
It increases memory usage, scheduling overhead, and context switching, which can reduce performance.

## ✅ Conclusion
This project demonstrates practical Java concurrency by implementing a multithreaded file search tool and comparing its results and execution time with sequential processing.
