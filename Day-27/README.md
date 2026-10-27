# Day 27 – Thread-Safe Counter

## 📌 Project Overview
This project demonstrates the difference between an unsafe counter and thread-safe counters in Java using multiple threads.

## 🎯 Objective
- Understand race conditions.
- Learn thread synchronization.
- Implement thread safety using `synchronized` and `AtomicInteger`.
- Compare execution times of different counter implementations.

## 🛠️ Technologies Used
- Java
- Multithreading
- `synchronized` keyword
- `AtomicInteger`

## 📂 Project Structure
```text
Day-27/
├── ThreadSafeCounter.java
└── README.md
```

## ⚙️ How It Works
1. Five threads execute concurrent counter updates.
2. The unsafe counter uses a normal integer and may lose updates.
3. The synchronized counter allows only one thread at a time to execute the increment method.
4. The AtomicInteger counter uses atomic operations to update its value safely.
5. The program measures and displays the execution time of each implementation.

## ▶️ How to Run
```bash
javac ThreadSafeCounter.java
java ThreadSafeCounter
```

## 📊 Performance Comparison
The program prints the execution time of each implementation in milliseconds.

- **Unsafe Counter:** No synchronization; updates may be lost.
- **Synchronized Counter:** Uses locking to ensure correct updates.
- **AtomicInteger Counter:** Uses atomic operations to ensure thread-safe updates.

Execution times depend on the system and thread scheduling.

## 💡 Interview Questions

### 1. What is a race condition?
A race condition occurs when multiple threads access shared data concurrently and the result depends on their execution order.

### 2. What does synchronized do?
It provides mutual exclusion, allowing only one thread at a time to execute a synchronized method on the same object or class monitor.

### 3. What is AtomicInteger?
AtomicInteger is a Java class that supports thread-safe atomic operations on an integer value.

### 4. When should atomic classes be used?
Use atomic classes for independent thread-safe updates to a single variable. Use synchronization or other concurrency utilities when an operation involves multiple shared variables or a larger critical section.

## ✅ Conclusion
This project demonstrates how synchronization and atomic operations prevent lost updates in concurrent Java programs.
