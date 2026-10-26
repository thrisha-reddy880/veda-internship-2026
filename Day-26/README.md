# 🧵 Multithreaded Number Processor

## 📌 Project Overview

The Multithreaded Number Processor is a Java application that calculates the sum of squares of numbers from 1 to 1,000,000 using both single-threaded and multithreaded execution.

It compares execution times and verifies that both approaches produce the same result.

## 🎯 Objectives

- Understand Java threads and concurrency.
- Compare single-threaded and multithreaded processing.
- Divide a large task into smaller ranges.
- Measure execution time.
- Understand thread safety and synchronization.

## 🛠️ Technologies Used

- Java
- Thread
- Runnable
- System.nanoTime()
- Thread.join()

## ✨ Features

1. **Single-Threaded Processing:** Calculate the sum using one thread.
2. **Multithreaded Processing:** Divide the number range among four threads.
3. **Execution-Time Comparison:** Measure the time taken by both approaches.
4. **Result Verification:** Check that both calculations match.
5. **Thread-Safe Design:** Each worker calculates its own local sum, avoiding shared mutable result variables.

## 📂 Project Structure

```text
Day-26/
├── MultithreadedNumberProcessor.java
└── README.md
```

## ⚙️ How It Works

The program calculates the sum of squares:

```text
1² + 2² + 3² + ... + 1,000,000²
```

The single-threaded version processes the complete range sequentially.

The multithreaded version divides the range into four smaller ranges. Each worker processes its assigned range independently. The main thread uses `join()` to wait for all workers to finish and then combines their results.

Finally, the program compares execution times and verifies the results.

## ▶️ How to Run

### Step 1: Open the terminal

Navigate to the Day-26 folder.

### Step 2: Compile the Java program

```bash
javac MultithreadedNumberProcessor.java
```

### Step 3: Run the application

```bash
java MultithreadedNumberProcessor
```

## 🧪 Expected Result

- Both methods should produce the same sum.
- The program displays the execution time of each method.
- The program confirms whether the results match.

Execution times vary depending on the computer, CPU, Java runtime, and system load. Multithreading is not guaranteed to be faster for every workload.

## 📚 Concepts Learned

- Multithreading
- Runnable interface
- Thread creation and execution
- Thread.join()
- Concurrency
- Execution-time measurement
- Thread-safe result aggregation

## 📝 Conclusion

This project demonstrates how Java multithreading can divide numerical processing into independent tasks. It compares sequential and concurrent execution while verifying the correctness of the final result.
