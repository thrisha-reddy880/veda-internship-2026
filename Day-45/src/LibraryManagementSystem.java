import java.util.List;
import java.util.Scanner;
public class LibraryManagementSystem {
    private static final Library library = new Library();
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("==================================");
            System.out.println("     LIBRARY MANAGEMENT SYSTEM");
            System.out.println("==================================");
            boolean running = true;
            while (running) {
                showMenu();
                int choice = readInt("Enter your choice: ", input);
                switch (choice) {
                    case 1 -> addBook(input);
                    case 2 -> addMember(input);
                    case 3 -> displayBooks();
                    case 4 -> searchBooks(input);
                    case 5 -> issueBook(input);
                    case 6 -> returnBook(input);
                    case 7 -> showOverdueBooks();
                    case 8 -> showLoans();
                    case 9 -> running = false;
                    default -> System.out.println("Invalid choice. Please select 1-9.");
                }
                System.out.println();
            }
            System.out.println("Thank you for using the Library Management System!");
        }
    }
    private static void showMenu() {
        System.out.println("\n------------- MENU -------------");
        System.out.println("1. Add Book");
        System.out.println("2. Register Member");
        System.out.println("3. Display All Books (Sorted)");
        System.out.println("4. Search Books");
        System.out.println("5. Issue Book");
        System.out.println("6. Return Book");
        System.out.println("7. View Overdue Books");
        System.out.println("8. View All Transactions");
        System.out.println("9. Exit");
        System.out.println("--------------------------------");
    }
    private static String readText(String prompt, Scanner input) {
        System.out.print(prompt);
        return input.nextLine().trim();
    }
    private static int readInt(String prompt, Scanner input) {
        while (true) {
            try {
                return Integer.parseInt(readText(prompt, input));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    private static void addBook(Scanner input) {
        System.out.println("\n--- Add Book ---");
        String isbn = readText("Enter ISBN: ", input);
        String title = readText("Enter title: ", input);
        String author = readText("Enter author: ", input);
        String category = readText("Enter category: ", input);
        if (title.isBlank() || author.isBlank()) {
            System.out.println("Title and author cannot be empty.");
            return;
        }
        boolean added = library.addBook(new Book(isbn, title, author, category));
        System.out.println(added ? "Book added successfully." : "Book not added. ISBN is empty or already exists.");
    }
    private static void addMember(Scanner input) {
        System.out.println("\n--- Register Member ---");
        String id = readText("Enter member ID: ", input);
        String name = readText("Enter member name: ", input);
        String email = readText("Enter email: ", input);
        if (name.isBlank()) {
            System.out.println("Member name cannot be empty.");
            return;
        }
        boolean added = library.addMember(new Member(id, name, email));
        System.out.println(added ? "Member registered successfully." : "Member not registered. ID is empty or already exists.");
    }
    private static void displayBooks() {
        System.out.println("\n--- Books (Sorted by Title) ---");
        List<Book> books = library.getBooksSortedByTitle();
        if (books.isEmpty()) {
            System.out.println("No books found. Add a book first.");
            return;
        }
        books.forEach(System.out::println);
    }
    private static void searchBooks(Scanner input) {
        String keyword = readText("Enter title, author, category, or ISBN to search: ", input);
        List<Book> results = library.searchBooks(keyword);
        if (results.isEmpty()) System.out.println("No matching books found.");
        else results.forEach(System.out::println);
    }
    private static void issueBook(Scanner input) {
        System.out.println("\n--- Issue Book ---");
        String isbn = readText("Enter book ISBN: ", input);
        String memberId = readText("Enter member ID: ", input);
        System.out.println(library.issueBook(isbn, memberId));
    }
    private static void returnBook(Scanner input) {
        System.out.println("\n--- Return Book ---");
        String isbn = readText("Enter book ISBN: ", input);
        System.out.println(library.returnBook(isbn));
    }
    private static void showOverdueBooks() {
        System.out.println("\n--- Overdue Books ---");
        List<Loan> overdue = library.getOverdueLoans();
        if (overdue.isEmpty()) {
            System.out.println("No overdue books.");
            return;
        }
        overdue.forEach(System.out::println);
    }
    private static void showLoans() {
        System.out.println("\n--- All Issue / Return Transactions ---");
        List<Loan> loans = library.getAllLoans();
        if (loans.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }
        loans.forEach(System.out::println);
    }
}