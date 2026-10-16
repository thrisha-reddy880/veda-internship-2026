import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Book {
    int id;
    String title;
    String author;
    boolean available = true;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("Book ID: " + id + " | Title: " + title + " | Author: " + author + " | Status: " + (available ? "Available" : "Issued"));
    }
}

class Member {
    int id;
    String name;

    Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("Member ID: " + id + " | Name: " + name);
    }
}

class BorrowRecord {
    int bookId;
    int memberId;
    LocalDate issueDate;
    LocalDate dueDate;

    BorrowRecord(int bookId, int memberId) {
        this.bookId = bookId;
        this.memberId = memberId;
        issueDate = LocalDate.now();
        dueDate = issueDate.plusDays(14);
    }
}

public class LibraryManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer, Book> books = new HashMap<>();
    static Map<Integer, Member> members = new HashMap<>();
    static List<BorrowRecord> records = new ArrayList<>();
    static int nextBookId = 1;
    static int nextMemberId = 1;
    static final int FINE_PER_DAY = 5;

    static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
            }
        }
    }

    static String readText(String message) {
        System.out.print(message);
        return sc.nextLine().trim();
    }

    static void addBook() {
        String title = readText("Enter book title: ");
        String author = readText("Enter author name: ");

        if (title.isEmpty() || author.isEmpty()) {
            System.out.println("Title and author cannot be empty.");
        } else {
            Book book = new Book(nextBookId++, title, author);
            books.put(book.id, book);
            System.out.println("Book added successfully. ID: " + book.id);
        }
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books.values()) {
                book.display();
            }
        }
    }

    static void searchBook() {
        int id = readInt("Enter book ID: ");
        Book book = books.get(id);

        if (book != null) {
            book.display();
        } else {
            System.out.println("Book not found.");
        }
    }

    static void registerMember() {
        String name = readText("Enter member name: ");

        if (name.isEmpty()) {
            System.out.println("Member name cannot be empty.");
        } else {
            Member member = new Member(nextMemberId++, name);
            members.put(member.id, member);
            System.out.println("Member registered successfully. ID: " + member.id);
        }
    }

    static void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
        } else {
            for (Member member : members.values()) {
                member.display();
            }
        }
    }

    static void issueBook() {
        int bookId = readInt("Enter book ID: ");
        int memberId = readInt("Enter member ID: ");

        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book == null) {
            System.out.println("Book not found.");
        } else if (member == null) {
            System.out.println("Member not found.");
        } else if (!book.available) {
            System.out.println("Book is already issued.");
        } else {
            book.available = false;
            BorrowRecord record = new BorrowRecord(bookId, memberId);
            records.add(record);
            System.out.println("Book issued successfully to " + member.name);
            System.out.println("Due date: " + record.dueDate);
        }
    }

    static void returnBook() {
        int bookId = readInt("Enter book ID: ");
        int memberId = readInt("Enter member ID: ");

        Book book = books.get(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        BorrowRecord found = null;

        for (BorrowRecord record : records) {
            if (record.bookId == bookId && record.memberId == memberId) {
                found = record;
                break;
            }
        }

        if (found == null) {
            System.out.println("No matching issue record found.");
        } else {
            long overdueDays = Math.max(0, ChronoUnit.DAYS.between(found.dueDate, LocalDate.now()));
            long fine = overdueDays * FINE_PER_DAY;

            records.remove(found);
            book.available = true;

            System.out.println("Book returned successfully.");
            System.out.println("Overdue days: " + overdueDays);
            System.out.println("Fine: Rs. " + fine);
        }
    }

    static void viewIssuedBooks() {
        if (records.isEmpty()) {
            System.out.println("No books are currently issued.");
        } else {
            for (BorrowRecord record : records) {
                Book book = books.get(record.bookId);
                Member member = members.get(record.memberId);
                long overdueDays = Math.max(0, ChronoUnit.DAYS.between(record.dueDate, LocalDate.now()));

                System.out.println("Book: " + book.title
                        + " | Member: " + member.name
                        + " | Issue Date: " + record.issueDate
                        + " | Due Date: " + record.dueDate
                        + " | Overdue Days: " + overdueDays
                        + " | Fine: Rs. " + (overdueDays * FINE_PER_DAY));
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Register Member");
            System.out.println("5. View Members");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. View Issued Books and Overdue Fines");
            System.out.println("9. Exit");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 ->
                    addBook();
                case 2 ->
                    viewBooks();
                case 3 ->
                    searchBook();
                case 4 ->
                    registerMember();
                case 5 ->
                    viewMembers();
                case 6 ->
                    issueBook();
                case 7 ->
                    returnBook();
                case 8 ->
                    viewIssuedBooks();
                case 9 -> {
                    System.out.println("Thank you for using the Library Management System!");
                    sc.close();
                    return;
                }
                default ->
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
