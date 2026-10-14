# 🔷 Shape Calculator Using Abstraction

## 📌 Project Description

The Shape Calculator is a simple Java console application that calculates the area and perimeter of different shapes using Object-Oriented Programming concepts.

It uses an abstract `Shape` class and three subclasses: `Circle`, `Rectangle`, and `Triangle`.

## 🎯 Objective

To understand abstraction and inheritance by defining common methods in an abstract class and implementing them in child classes.

## ✨ Features

- 🔵 Calculate the area of a circle
- ▭ Calculate the area of a rectangle
- 🔺 Calculate the area of a triangle
- 📏 Calculate the perimeter of all three shapes
- 🔄 Use method overriding
- 🛡️ Validate dimensions and triangle sides
- 📋 Display calculation results

## 🛠️ Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Abstract classes and methods
- Inheritance
- Method overriding
- Scanner class

## 📂 Project Structure

```text
Day-14/
├── Shape.java
├── Circle.java
├── Rectangle.java
├── Triangle.java
├── ShapeCalculator.java
└── README.md
```

## 📄 File Description

- **Shape.java:** Defines the abstract parent class and common methods.
- **Circle.java:** Calculates circle area and circumference.
- **Rectangle.java:** Calculates rectangle area and perimeter.
- **Triangle.java:** Calculates triangle area and perimeter.
- **ShapeCalculator.java:** Accepts input and displays calculation results.
- **README.md:** Contains project documentation and execution instructions.

## 🧠 OOP Concepts Used

1. **Abstraction:** The Shape class defines abstract methods without specifying their implementations.
2. **Inheritance:** Circle, Rectangle, and Triangle extend Shape.
3. **Method Overriding:** Each child class implements its own area and perimeter calculations.
4. **Polymorphism:** A Shape reference can hold different child-class objects.

## ⚙️ How It Works

1. Run the application.
2. Select Circle, Rectangle, or Triangle.
3. Enter the required dimensions.
4. The program calculates the area and perimeter.
5. The results are displayed on the console.

## ▶️ How to Run

Compile all Java files:

```bash
javac Shape.java Circle.java Rectangle.java Triangle.java ShapeCalculator.java
```

Run the main program:

```bash
java ShapeCalculator
```

## 📐 Formulas Used

- **Circle:** Area = π × radius²; Perimeter = 2 × π × radius
- **Rectangle:** Area = length × width; Perimeter = 2 × (length + width)
- **Triangle:** Area = √[s(s − a)(s − b)(s − c)]; Perimeter = a + b + c

Here, `s` is half the triangle's perimeter.

## 📌 Expected Outcome

A menu-driven application that calculates shape areas and perimeters while demonstrating abstraction and inheritance in Java.

## 👩‍💻 Developed By

Thrisha Reddy

Java Programming Track — Veda Technology Internship
