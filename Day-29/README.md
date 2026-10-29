# Day 29 – Generic Data Repository

## 📌 Project Overview
A reusable Java repository that stores, retrieves, updates, and deletes different types of objects using Java Generics and Collections.

## 🎯 Objective
- Understand Java Generics.
- Build a reusable, type-safe repository.
- Implement CRUD operations.
- Work with multiple object types using one generic class.

## 🛠️ Technologies Used
- Java
- Generics
- Collections Framework
- LinkedHashMap

## 📂 Project Structure
```text
Day-29/
├── GenericRepository.java
├── Student.java
├── Product.java
├── GenericRepositoryDemo.java
└── README.md
```

## ✨ Features
- Create and store objects with unique integer IDs.
- Retrieve an object by ID.
- Retrieve all stored objects.
- Update existing records.
- Delete records.
- Reuse the same repository for Student and Product objects.

## ⚙️ How It Works
1. `GenericRepository<T>` uses a generic type parameter.
2. A `LinkedHashMap` stores records using integer IDs.
3. CRUD methods operate on the stored objects.
4. `GenericRepository<Student>` stores students.
5. `GenericRepository<Product>` stores products.
6. Java generics provide compile-time type checking and reduce unnecessary casting.

## ▶️ How to Run
```bash
javac *.java
java GenericRepositoryDemo
```

## 💡 Interview Questions

### 1. What are Generics?
Generics allow classes, interfaces, and methods to work with parameterized types.

### 2. Why are Generics useful?
They improve type safety, reduce explicit casting, and promote code reuse.

### 3. What is type safety?
Type safety helps prevent incompatible types from being used where another type is expected.

### 4. What is type erasure?
Type erasure is the process by which Java removes most generic type information during compilation while preserving the required runtime behavior.

## ✅ Conclusion
This project demonstrates a reusable generic repository with CRUD operations for multiple Java object types.
