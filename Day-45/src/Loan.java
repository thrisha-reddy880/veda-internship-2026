import java.time.LocalDate;
public class Loan {
    private final String loanId;
    private final String isbn;
    private final String memberId;
    private final LocalDate issueDate;
    private final LocalDate dueDate;
    private LocalDate returnDate;
    public Loan(String loanId, String isbn, String memberId,
                LocalDate issueDate, LocalDate dueDate, LocalDate returnDate) {
        this.loanId = loanId;
        this.isbn = isbn;
        this.memberId = memberId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }
    public String getLoanId() { return loanId; }
    public String getIsbn() { return isbn; }
    public String getMemberId() { return memberId; }
    public LocalDate getIssueDate() { return issueDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public boolean isActive() { return returnDate == null; }
    public boolean isOverdue() { return isActive() && LocalDate.now().isAfter(dueDate); }
    public void markReturned() { returnDate = LocalDate.now(); }
    public String toFileLine() {
        return String.join("|", loanId, isbn, memberId, issueDate.toString(),
                dueDate.toString(), returnDate == null ? "-" : returnDate.toString());
    }
    public static Loan fromFileLine(String line) {
        String[] p = line.split("\\|", -1);
        if (p.length != 6) throw new IllegalArgumentException("Invalid loan record");
        return new Loan(p[0], p[1], p[2], LocalDate.parse(p[3]), LocalDate.parse(p[4]),
                p[5].equals("-") ? null : LocalDate.parse(p[5]));
    }
    @Override
    public String toString() {
        return String.format("Loan: %s | ISBN: %s | Member: %s | Issued: %s | Due: %s | Returned: %s",
                loanId, isbn, memberId, issueDate, dueDate,
                returnDate == null ? "Not returned" : returnDate);
    }
}