# 🐾 Runtime Polymorphism in Java

## 📌 Project Description

This project demonstrates runtime polymorphism in Java using a parent class and multiple child classes. Each child class overrides a common method to provide its own behavior.

## 🎯 Objective

To understand runtime polymorphism and dynamic method dispatch using inheritance and method overriding.

## ✨ Features

- 🐾 Parent class named Animal
- 🐶 Dog class with its own sound
- 🐱 Cat class with its own sound
- 🐮 Cow class with its own sound
- 🔄 Method overriding
- ♻️ Parent reference holding different child objects
- ⚙️ Runtime method selection

## 🛠️ Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Inheritance
- Method Overriding
- Runtime Polymorphism

## 📂 Project Structure

```text
Day-13/
├── Animal.java
├── Dog.java
├── Cat.java
├── Cow.java
├── PolymorphismDemo.java
└── README.md
```

## 📄 File Description

- **Animal.java:** Defines the parent class and common sound method.
- **Dog.java:** Overrides the sound method to represent a dog.
- **Cat.java:** Overrides the sound method to represent a cat.
- **Cow.java:** Overrides the sound method to represent a cow.
- **PolymorphismDemo.java:** Demonstrates runtime polymorphism.
- **README.md:** Contains project details and execution instructions.

## 🧠 Concepts Used

1. **Polymorphism:** One parent reference can represent objects of different child classes.
2. **Runtime Polymorphism:** The method implementation is selected at runtime based on the actual object.
3. **Inheritance:** Child classes extend the Animal class.
4. **Method Overriding:** Child classes provide their own implementation of `sound()`.
5. **Dynamic Method Dispatch:** Java selects the overridden method based on the object referenced at runtime.

## ⚙️ How It Works

1. Create an Animal parent reference.
2. Assign a Dog object and call `sound()`.
3. Assign a Cat object and call `sound()`.
4. Assign a Cow object and call `sound()`.
5. Java executes the appropriate overridden method for each object.

## ▶️ How to Run

Compile all Java files:

```bash
javac Animal.java Dog.java Cat.java Cow.java PolymorphismDemo.java
```

Run the main program:

```bash
java PolymorphismDemo
```

## 📌 Expected Outcome

The program displays different animal sounds through the same parent-class reference, demonstrating runtime polymorphism.

## 👩‍💻 Developed By

Thrisha Reddy

Java Programming Track — Veda Technology Internship
