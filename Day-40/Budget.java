import java.time.YearMonth;
public class Budget {
    private final YearMonth month;
    private double amount;
    public Budget(YearMonth month, double amount) {
        this.month = month;
        this.amount = amount;
    }
    public YearMonth getMonth() {
        return month;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String toFileString() {
        return month + "|" + amount;
    }
    public void display() {
        System.out.println("Month: " + month);
        System.out.printf("Monthly Budget: Rs. %.2f%n", amount);
    }
}