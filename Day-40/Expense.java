import java.time.LocalDate;
public class Expense {
    private final int id;
    private String description;
    private String category;
    private double amount;
    private LocalDate date;
    public Expense(int id, String description, String category,
                double amount, LocalDate date) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }
    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public String getCategory() {
        return category;
    }
    public double getAmount() {
        return amount;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String toFileString() {
        return id + "|" + description + "|" + category
                + "|" + amount + "|" + date;
    }
    public void display() {
        System.out.printf("%-5d %-20s %-15s Rs.%-10.2f %-12s%n",
                id, description, category, amount, date);
    }
}