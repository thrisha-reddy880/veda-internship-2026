# 📝 Stack-Based Undo System

## 📌 Project Overview

The Stack-Based Undo System is a simple Java console application that simulates the undo functionality of a text editor.

It uses a Stack data structure to save previous text states and restore them when the user performs an undo operation.

## 🎯 Objectives

- Understand Stack and LIFO processing.
- Store previous text states before editing.
- Implement undo functionality.
- Support multiple undo operations.
- Perform text editing operations.

## 🛠️ Technologies Used

- Java
- Stack
- Scanner
- String

## ✨ Features

1. **Add Text:** Append new text to the current document.
2. **Delete Last Character:** Remove the final character.
3. **Replace Text:** Replace the entire document content.
4. **Display Text:** Show the current document.
5. **Undo Operation:** Restore the previous text state.
6. **Multiple Undo:** Undo multiple editing operations.
7. **Undo Count:** Display the number of available undo operations.

## 📂 Project Structure

```text
Day-21/
├── StackUndoSystem.java
└── README.md
```

## ⚙️ How It Works

The application uses a Stack to manage previous text states.

- `push()` saves the current text before an editing operation.
- `pop()` retrieves the most recent saved text state.
- Each editing operation saves a snapshot before changing the text.
- Undo restores the previous snapshot.

The Stack follows LIFO (Last In, First Out), so the most recent change is undone first.

## ▶️ How to Run

### Step 1: Open the terminal

Navigate to the Day-21 folder.

### Step 2: Compile the program

```bash
javac StackUndoSystem.java
```

### Step 3: Run the application

```bash
java StackUndoSystem
```

## 🧪 Sample Output

```text
STACK UNDO SYSTEM

1. Add Text
2. Delete Last Character
3. Replace Entire Text
4. Display Current Text
5. Undo Last Operation
6. View Undo Count
7. Exit

Enter your choice: 1

Enter text to add: Hello

Text added successfully!

Enter your choice: 1

Enter text to add: World

Text added successfully!

Enter your choice: 4

===== CURRENT TEXT =====
HelloWorld
=======================

Enter your choice: 5

Undo successful!

===== CURRENT TEXT =====
Hello
=======================
```

## 📚 Concepts Learned

- Stack data structure
- LIFO principle
- Push and pop operations
- State management
- String manipulation
- Object-oriented programming
- Menu-driven Java applications

## 📝 Conclusion

This project demonstrates how Stack can be used to implement undo functionality in a text editor. By saving previous states and restoring them in reverse order, the application supports multiple undo operations efficiently.
