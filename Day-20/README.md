# 🎫 Customer Support Queue System

## 📌 Project Overview

The Customer Support Queue System is a Java console application that manages customer support tickets using the Queue data structure.

It follows the FIFO (First In, First Out) principle, ensuring that the oldest waiting ticket is processed first.

## 🎯 Objectives

- Understand Queue and FIFO processing.
- Create and manage customer support tickets.
- Process tickets in the correct order.
- Track ticket status.
- Maintain a history of resolved tickets.

## 🛠️ Technologies Used

- Java
- Queue Interface
- ArrayDeque
- HashMap
- ArrayList
- Scanner

## ✨ Features

1. **Create Ticket:** Register a customer issue with a unique ticket ID.
2. **View Waiting Queue:** Display all tickets waiting for support.
3. **Process Next Ticket:** Resolve the oldest waiting ticket.
4. **Track Ticket Status:** Search tickets using their ticket ID.
5. **View Resolved Tickets:** Display previously processed tickets.
6. **Exit:** Safely close the application.

## 📂 Project Structure

```text
Day-20/
├── CustomerSupportQueue.java
└── README.md
```

## ⚙️ How It Works

The application uses an ArrayDeque to implement the Queue.

- `offer()` adds a new ticket to the end of the queue.
- `poll()` removes the oldest ticket from the front.
- A HashMap stores tickets for status tracking.
- An ArrayList stores resolved tickets.

The ticket status changes from Waiting to Resolved when it is processed.

## ▶️ How to Run

### Step 1: Open the terminal

Navigate to the Day-20 folder.

### Step 2: Compile the Java program

```bash
javac CustomerSupportQueue.java
```

### Step 3: Run the application

```bash
java CustomerSupportQueue
```

## 🧪 Sample Output

```text
CUSTOMER SUPPORT SYSTEM

1. Create New Ticket
2. View Waiting Queue
3. Process Next Ticket
4. Track Ticket Status
5. View Resolved Tickets
6. Exit

Enter your choice: 1

Enter customer name: Rahul
Enter customer issue: Payment failed

Ticket created successfully!
Your Ticket ID: 1
Status: Waiting
```

## 📚 Concepts Learned

- Queue data structure
- FIFO processing
- ArrayDeque
- Object-oriented programming
- Ticket status management
- HashMap and ArrayList
- Menu-driven Java applications

## 📝 Conclusion

This project demonstrates how a Queue can be used to manage customer support requests efficiently. Tickets are processed in the order they arrive, and their statuses can be tracked throughout the application.