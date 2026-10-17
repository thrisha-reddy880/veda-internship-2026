# 📦 Inventory Management System Using ArrayList

## 📌 Project Description

The Inventory Management System is a console-based Java application that manages product records using an ArrayList.

It allows users to add, display, search, update, and remove products through a simple menu.

## 🎯 Objective

To understand Java Collections and implement practical CRUD (Create, Read, Update, Delete) operations.

## ✨ Features

- ➕ Add new products
- 📋 Display all products
- 🔍 Search products by ID
- ✏️ Update product details
- 🗑️ Remove products
- 🛡️ Validate product information
- 🔑 Maintain unique product IDs

## 🛠️ Technologies Used

- Java
- ArrayList
- Object-Oriented Programming
- Encapsulation
- Scanner class

## 📂 Project Structure

```text id="t6rj01"
Day-17/
├── InventorySystem.java
└── README.md
```

## 📄 File Description

**InventorySystem.java**
- Defines the Product class.
- Stores products in an ArrayList.
- Implements product CRUD operations.
- Provides a menu-driven interface.
- Validates product information.

**README.md**
- Contains project documentation and execution instructions.

## 🧠 OOP Concepts Used

1. **Classes and Objects:** Product represents an inventory item.
2. **Encapsulation:** Product fields are private and accessed through methods.
3. **Collections:** ArrayList stores a dynamic collection of products.
4. **Methods:** Separate methods implement inventory operations.

## ⚙️ How It Works

1. Run the application.
2. Select an inventory operation.
3. Enter the required product information.
4. The application performs the selected operation.
5. View updated product information.
6. Exit the application.

## ▶️ How to Run

Compile the Java program:

```bash id="xd32fr"
javac InventorySystem.java
```

Run the application:

```bash id="a4jct6"
java InventorySystem
```

## 🧪 Sample Output

```text id="fn72md"
===== INVENTORY MANAGEMENT SYSTEM =====
1. Add Product
2. Display Products
3. Search Product
4. Update Product
5. Remove Product
6. Exit
Enter your choice: 1

Enter Product ID: 101
Enter Product Name: Laptop
Enter Product Price: 45000
Enter Product Quantity: 5

Product added successfully!
```

## 📚 ArrayList vs Array

- Arrays have a fixed size, while ArrayList can grow and shrink dynamically.
- ArrayList provides convenient methods such as add(), remove(), and get().
- ArrayList is useful when the number of products changes during execution.

## 📌 Expected Outcome

A menu-driven inventory application demonstrating Java ArrayList and CRUD operations.

## 👩‍💻 Developed By

Thrisha Reddy

Java Programming Track — Veda Technology Internship
