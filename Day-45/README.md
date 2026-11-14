# Library Management System (Java)

A menu-driven, file-based Library Management System built using core Java and object-oriented programming.

## Features
- Add and display books
- Register library members
- Issue books and record due dates (14 days from issue)
- Return books and update availability
- Search by title, author, category, or ISBN
- Display books sorted alphabetically by title
- Track overdue books
- Store books, members, and transactions in text files
- Validate duplicate IDs, unavailable books, and invalid menu input

## Technologies Used
- Java (JDK 17 or later recommended)
- OOP: classes, objects, encapsulation
- Collections: `ArrayList`, `HashMap`-style `Map`, streams
- File I/O: `java.nio.file`
- Date handling: `java.time.LocalDate`
- Exception handling

## Project Structure
```text
Day-45/
├── src/
│   ├── Book.java
│   ├── Member.java
│   ├── Loan.java
│   ├── Library.java
│   └── LibraryManagementSystem.java
├── data/
│   ├── books.txt       # created automatically
│   ├── members.txt    # created automatically
│   └── loans.txt      # created automatically
└── README.md
```

## How to Run (Windows Command Prompt)
Open Command Prompt in the `LibraryManagementSystem` folder and run:

```bash
javac -d out src\*.java
java -cp out LibraryManagementSystem
```

The program creates the `data` folder and text files automatically after the first run. Keep the `data` folder in the same working directory when running the application so saved information can be loaded.

## How It Works
1. Add books using a unique ISBN.
2. Register members using a unique member ID.
3. Issue a book by entering its ISBN and a registered member ID. The system sets a 14-day due date.
4. Return the book using its ISBN. Its availability is updated.
5. Search books by title, author, category, or ISBN.
6. View overdue loans; a loan is overdue when its due date has passed and it has not been returned.
7. Data is saved in `data/books.txt`, `data/members.txt`, and `data/loans.txt`.

## Sample Test Flow
1. Add a book: ISBN `101`, title `Java Basics`, author `James`, category `Programming`.
2. Register a member: ID `M01`, name `Anu`, email `anu@example.com`.
3. Issue ISBN `101` to member `M01`.
4. Display books and confirm its status is `Issued`.
5. Return ISBN `101`.
6. Display books and confirm its status is `Available`.

## Notes
- ISBN and member ID must be unique.
- A book cannot be issued if it is already issued.
- A member must be registered before borrowing a book.
- Text fields replace the pipe (`|`) character with `/` because the text files use `|` as a field separator.
