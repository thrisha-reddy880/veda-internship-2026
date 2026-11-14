import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
public class Library {
    private final Map<String, Book> books = new LinkedHashMap<>();
    private final Map<String, Member> members = new LinkedHashMap<>();
    private final List<Loan> loans = new ArrayList<>();
    private final Path dataDirectory = Paths.get("data");
    private final Path booksFile = dataDirectory.resolve("books.txt");
    private final Path membersFile = dataDirectory.resolve("members.txt");
    private final Path loansFile = dataDirectory.resolve("loans.txt");
    public Library() {
        loadData();
    }
    private void loadData() {
        try {
            Files.createDirectories(dataDirectory);
            if (Files.exists(booksFile)) {
                for (String line : Files.readAllLines(booksFile)) {
                    if (!line.isBlank()) {
                        try {
                            Book b = Book.fromFileLine(line);
                            books.put(b.getIsbn(), b);
                        } catch (RuntimeException ex) {
                            System.out.println("Skipping invalid book record: " + line);
                        }
                    }
                }
            }
            if (Files.exists(membersFile)) {
                for (String line : Files.readAllLines(membersFile)) {
                    if (!line.isBlank()) {
                        try {
                            Member m = Member.fromFileLine(line);
                            members.put(m.getMemberId(), m);
                        } catch (RuntimeException ex) {
                            System.out.println("Skipping invalid member record: " + line);
                        }
                    }
                }
            }
            if (Files.exists(loansFile)) {
                for (String line : Files.readAllLines(loansFile)) {
                    if (!line.isBlank()) {
                        try {
                            loans.add(Loan.fromFileLine(line));
                        } catch (RuntimeException ex) {
                            System.out.println("Skipping invalid loan record: " + line);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load saved data: " + e.getMessage());
        }
    }
    private void saveData() {
        try {
            Files.createDirectories(dataDirectory);
            Files.write(booksFile, books.values().stream().map(Book::toFileLine).collect(Collectors.toList()));
            Files.write(membersFile, members.values().stream().map(Member::toFileLine).collect(Collectors.toList()));
            Files.write(loansFile, loans.stream().map(Loan::toFileLine).collect(Collectors.toList()));
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
    public boolean addBook(Book book) {
        if (book.getIsbn().isBlank() || books.containsKey(book.getIsbn())) return false;
        books.put(book.getIsbn(), book);
        saveData();
        return true;
    }
    public boolean addMember(Member member) {
        if (member.getMemberId().isBlank() || members.containsKey(member.getMemberId())) return false;
        members.put(member.getMemberId(), member);
        saveData();
        return true;
    }
    public Collection<Book> getAllBooks() { return books.values(); }
    public Collection<Member> getAllMembers() { return members.values(); }
    public List<Book> searchBooks(String keyword) {
        String q = keyword.toLowerCase(Locale.ROOT);
        return books.values().stream()
                .filter(b -> b.getTitle().toLowerCase(Locale.ROOT).contains(q)
                        || b.getAuthor().toLowerCase(Locale.ROOT).contains(q)
                        || b.getCategory().toLowerCase(Locale.ROOT).contains(q)
                        || b.getIsbn().toLowerCase(Locale.ROOT).contains(q))
                .collect(Collectors.toList());
    }
    public List<Book> getBooksSortedByTitle() {
        return books.values().stream()
                .sorted(Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }
    public String issueBook(String isbn, String memberId) {
        Book book = books.get(isbn);
        if (book == null) return "Book not found. Check the ISBN.";
        if (!members.containsKey(memberId)) return "Member not found. Register the member first.";
        if (!book.isAvailable()) return "Book is already issued.";
        LocalDate today = LocalDate.now();
        String loanId = "L" + (loans.size() + 1);
        Loan loan = new Loan(loanId, isbn, memberId, today, today.plusDays(14), null);
        loans.add(loan);
        book.setAvailable(false);
        saveData();
        return "Book issued successfully. Loan ID: " + loanId + " | Due date: " + loan.getDueDate();
    }
    public String returnBook(String isbn) {
        Book book = books.get(isbn);
        if (book == null) return "Book not found.";
        Optional<Loan> activeLoan = loans.stream()
                .filter(l -> l.getIsbn().equals(isbn) && l.isActive())
                .findFirst();
        if (activeLoan.isEmpty()) return "This book has no active issue record.";
        activeLoan.get().markReturned();
        book.setAvailable(true);
        saveData();
        return "Book returned successfully on " + LocalDate.now() + ".";
    }
    public List<Loan> getOverdueLoans() {
        return loans.stream().filter(Loan::isOverdue).collect(Collectors.toList());
    }
    public List<Loan> getAllLoans() { return Collections.unmodifiableList(loans); }
}