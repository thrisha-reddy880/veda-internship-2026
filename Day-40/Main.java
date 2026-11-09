import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static ExpenseManager manager = new ExpenseManager();
    static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }
    static double readAmount(String message) {
        while (true) {
            try {
                System.out.print(message);
                double amount = Double.parseDouble(sc.nextLine().trim());
                if (Double.isFinite(amount) && amount > 0) {
                    return amount;
                }
                System.out.println("Amount must be greater than zero.");
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid amount!");
            }
        }
    }
    static String readText(String message) {
        while (true) {
            System.out.print(message);
            String value = sc.nextLine().trim();
            if (!value.isBlank() && !value.contains("|")) {
                return value;
            }
            System.out.println("Enter valid text without the | character.");
        }
    }
    static LocalDate readDate() {
        while (true) {
            try {
                System.out.print("Enter date (YYYY-MM-DD): ");
                return LocalDate.parse(sc.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date! Example: 2026-11-09");
            }
        }
    }
    static YearMonth readMonth() {
        while (true) {
            try {
                System.out.print("Enter month (YYYY-MM): ");
                return YearMonth.parse(sc.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Invalid month! Example: 2026-11");
            }
        }
    }
    static String selectCategory() {
        Category.displayCategories();
        while (true) {
            int choice = readInt("Select category: ");
            String category = Category.getCategory(choice);
            if (category != null) {
                return category;
            }
            System.out.println("Invalid category choice!");
        }
    }
    static void addExpense() {
        System.out.println("\n========== ADD EXPENSE ==========");
        String description = readText("Enter description: ");
        String category = selectCategory();
        double amount = readAmount("Enter amount: ");
        LocalDate date = readDate();
        manager.addExpense(description, category, amount, date);
    }
    static void updateExpense() {
        System.out.println("\n========== UPDATE EXPENSE ==========");
        int id = readInt("Enter expense ID: ");
        String description = readText("Enter new description: ");
        String category = selectCategory();
        double amount = readAmount("Enter new amount: ");
        LocalDate date = readDate();
        manager.updateExpense(id, description, category, amount, date);
    }
    static void deleteExpense() {
        System.out.println("\n========== DELETE EXPENSE ==========");
        int id = readInt("Enter expense ID to delete: ");
        manager.deleteExpense(id);
    }
    static void searchExpense() {
        System.out.println("\n========== SEARCH EXPENSE ==========");
        String keyword = readText("Enter ID, description or category: ");
        manager.searchExpense(keyword);
    }
    static void setBudget() {
        System.out.println("\n========== SET MONTHLY BUDGET ==========");
        YearMonth month = readMonth();
        double amount = readAmount("Enter monthly budget: ");
        manager.setBudget(month, amount);
    }
    static void viewBudget() {
        System.out.println("\n========== VIEW MONTHLY BUDGET ==========");
        YearMonth month = readMonth();
        manager.viewBudget(month);
    }
    static void generateReport() {
        System.out.println("\n========== EXPENSE SUMMARY ==========");
        YearMonth month = readMonth();
        manager.generateReport(month);
    }
    public static void main(String[] args) {
        System.out.println("\nWelcome to Personal Expense & Budget Manager!");
        int choice;
        do {
            System.out.println("\n==========================================");
            System.out.println(" PERSONAL EXPENSE & BUDGET MANAGEMENT");
            System.out.println("==========================================");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Update Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Search Expense");
            System.out.println("6. View Expenses by Category");
            System.out.println("7. Set Monthly Budget");
            System.out.println("8. View Monthly Budget");
            System.out.println("9. Generate Expense Summary");
            System.out.println("10. Exit");
            choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> addExpense();
                case 2 -> manager.viewExpenses();
                case 3 -> updateExpense();
                case 4 -> deleteExpense();
                case 5 -> searchExpense();
                case 6 -> {
                    String category = selectCategory();
                    manager.viewByCategory(category);
                }
                case 7 -> setBudget();
                case 8 -> viewBudget();
                case 9 -> generateReport();
                case 10 -> {
                    System.out.println("\nThank you for using the application!");
                    System.out.println("Your data is saved successfully.");
                }
                default -> System.out.println("Invalid choice! Select 1 to 10.");
            }
        } while (choice != 10);
        sc.close();
    }
}