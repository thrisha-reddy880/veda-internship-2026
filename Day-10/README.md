# 🏫 Constructor Overloading in Java

## 📌 Project Overview

Constructor Overloading is a Java program that demonstrates how multiple constructors can be defined in the same class with different parameter lists.

The program creates student objects using different sets of information, including name, age, and course.

---

## 🎯 Objective

The objective of this project is to practice:

- Constructors in Java
- Constructor overloading
- Classes and objects
- Object initialization
- Instance variables
- Methods

---

## ✨ Features

- 🏫 Create student objects using multiple constructors
- 👤 Initialize a student without providing details
- 📝 Initialize a student using only a name
- 🎂 Initialize a student using name and age
- 🎓 Initialize a student using name, age, and course
- 📋 Display student details
- 🔄 Demonstrate constructor overloading

---

## 🛠️ Technologies Used

- Java
- Classes and objects
- Constructors
- Methods
- Instance variables

---

## 📂 Project Structure

```text
Day-10/
│
├── Student.java
└── README.md
```

---

## 📄 File Description

- **Student.java** – Contains the `Student` class, multiple constructors, the `displayDetails()` method, and the `main()` method to demonstrate object creation.
- **README.md** – Contains the project overview, features, execution instructions, and sample output.

---

## ⚙️ How It Works

1. The program defines a `Student` class with name, age, and course fields.
2. Multiple constructors are created with different parameter lists.
3. Each constructor initializes an object using the provided information.
4. Four student objects are created using different constructors.
5. The `displayDetails()` method displays each student's information.

---

## ▶️ How to Run

**Step 1:** Open the terminal in the `Day-10` folder.

```bash
cd Day-10
```

**Step 2:** Compile the Java program.

```bash
javac Student.java
```

**Step 3:** Run the program.

```bash
java Student
```

---

## 🧪 Sample Output

```text
CONSTRUCTOR OVERLOADING DEMO
============================

Student 1: Default Constructor
Name: Unknown
Age: 0
Course: Not Assigned
-------------------------

Student 2: Name Constructor
Name: Thrisha
Age: 0
Course: Not Assigned
-------------------------

Student 3: Name and Age Constructor
Name: Rahul
Age: 20
Course: Not Assigned
-------------------------

Student 4: Full Constructor
Name: Priya
Age: 19
Course: Computer Science
-------------------------
```

---

## 🧠 Concepts Learned

- **Constructor:** Initializes an object when it is created.
- **Constructor Overloading:** Defines multiple constructors with different parameter lists.
- **Class:** A blueprint for creating objects.
- **Object:** An instance of a class.
- **`this` keyword:** Refers to the current object and distinguishes instance variables from parameters.

---

## 💡 Interview Questions

### 1. What is a constructor?

A constructor is a special member of a class used to initialize objects. It has the same name as the class and no return type.

### 2. What is constructor overloading?

Constructor overloading means defining multiple constructors in the same class with different parameter lists.

### 3. Can constructors be inherited?

No. Constructors are not inherited by subclasses, but a subclass can call a superclass constructor.

### 4. Can a constructor be private?

Yes. A private constructor restricts object creation from outside the class.

### 5. Can constructors have a return type?

No. Constructors cannot have a return type, not even `void`.

### 6. What is the difference between a constructor and a method?

A constructor initializes an object during its creation, while a method performs a specific operation.

---

## 🚀 Future Improvements

- Accept student details through keyboard input
- Add age validation
- Store multiple student records
- Add methods to update student information
- Display student records in a formatted table

---

## 👩‍💻 Author

**Thrisha Reddy**

## 📌 Internship Details

- **Day:** 10
- **Task:** Implement Constructor Overloading
- **Track:** Java Programming
- **Language:** Java

---

*This project was created for educational and internship practice purposes.*