import java.io.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
public class ExpenseManager {
    private final ArrayList<Expense> expenses = new ArrayList<>();
    private final ArrayList<Budget> budgets = new ArrayList<>();
    private final String EXPENSE_FILE = "expenses.txt";
    private final String BUDGET_FILE = "budgets.txt";
    private int nextId = 1;
    public ExpenseManager() {
        loadExpenses();
        loadBudgets();
    }
    private Expense findExpense(int id) {
        for (Expense expense : expenses) {
            if (expense.getId() == id) {
                return expense;
            }
        }
        return null;
    }
    public void addExpense(String description, String category,
                        double amount, LocalDate date) {
        Expense expense = new Expense(nextId++, description,
                category, amount, date);
        expenses.add(expense);
        saveExpenses();
        System.out.println("Expense added successfully!");
    }
    public void viewExpenses() {
        System.out.println("\n========== ALL EXPENSES ==========");
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }
        System.out.printf("%-5s %-20s %-15s %-15s %-12s%n",
                "ID", "Description", "Category", "Amount", "Date");
        System.out.println("----------------------------------------------------------------");
        for (Expense expense : expenses) {
            expense.display();
        }
    }
    public void updateExpense(int id, String description,
                            String category, double amount,
                            LocalDate date) {
        Expense expense = findExpense(id);
        if (expense == null) {
            System.out.println("Expense not found!");
            return;
        }
        expense.setDescription(description);
        expense.setCategory(category);
        expense.setAmount(amount);
        expense.setDate(date);
        saveExpenses();
        System.out.println("Expense updated successfully!");
    }
    public void deleteExpense(int id) {
        Expense expense = findExpense(id);
        if (expense == null) {
            System.out.println("Expense not found!");
            return;
        }
        expenses.remove(expense);
        saveExpenses();
        System.out.println("Expense deleted successfully!");
    }
    public void searchExpense(String keyword) {
        boolean found = false;
        System.out.println("\n========== SEARCH RESULTS ==========");
        for (Expense expense : expenses) {
            if (String.valueOf(expense.getId()).equalsIgnoreCase(keyword)
                    || expense.getDescription().toLowerCase()
                    .contains(keyword.toLowerCase())
                    || expense.getCategory().equalsIgnoreCase(keyword)) {
                expense.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching expenses found.");
        }
    }
    public void viewByCategory(String category) {
        boolean found = false;
        double total = 0;
        System.out.println("\nExpenses in category: " + category);
        for (Expense expense : expenses) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                expense.display();
                total += expense.getAmount();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No expenses found in this category.");
        } else {
            System.out.printf("Category Total: Rs. %.2f%n", total);
        }
    }
    public void setBudget(YearMonth month, double amount) {
        for (Budget budget : budgets) {
            if (budget.getMonth().equals(month)) {
                budget.setAmount(amount);
                saveBudgets();

                System.out.println("Monthly budget updated successfully!");
                return;
            }
        }
        budgets.add(new Budget(month, amount));
        saveBudgets();
        System.out.println("Monthly budget set successfully!");
    }
    public void viewBudget(YearMonth month) {
        Budget selectedBudget = null;
        for (Budget budget : budgets) {
            if (budget.getMonth().equals(month)) {
                selectedBudget = budget;
                break;
            }
        }
        if (selectedBudget == null) {
            System.out.println("No budget found for " + month);
            return;
        }
        double spent = getMonthlyTotal(month);
        double budgetAmount = selectedBudget.getAmount();
        double remaining = budgetAmount - spent;
        System.out.println("\n========== MONTHLY BUDGET ==========");
        System.out.println("Month: " + month);
        System.out.printf("Budget: Rs. %.2f%n", budgetAmount);
        System.out.printf("Spent: Rs. %.2f%n", spent);
        System.out.printf("Remaining: Rs. %.2f%n", remaining);
        if (remaining < 0) {
            System.out.println("Warning: Monthly budget exceeded!");
        } else {
            System.out.println("You are within your budget.");
        }
        System.out.println("====================================");
    }
    private double getMonthlyTotal(YearMonth month) {
        double total = 0;
        for (Expense expense : expenses) {
            if (YearMonth.from(expense.getDate()).equals(month)) {
                total += expense.getAmount();
            }
        }
        return total;
    }
    public void generateReport(YearMonth month) {
        double total = 0;
        int count = 0;
        System.out.println("\n========== MONTHLY EXPENSE REPORT ==========");
        System.out.println("Month: " + month);
        for (Expense expense : expenses) {
            if (YearMonth.from(expense.getDate()).equals(month)) {
                expense.display();
                total += expense.getAmount();
                count++;
            }
        }
        System.out.println("--------------------------------------------");
        System.out.println("Total Transactions: " + count);
        System.out.printf("Total Expenses: Rs. %.2f%n", total);
        System.out.println("\nCategory-wise Summary:");
        for (String category : Category.getCategories()) {
            double categoryTotal = 0;
            for (Expense expense : expenses) {
                if (expense.getCategory().equalsIgnoreCase(category)
                        && YearMonth.from(expense.getDate()).equals(month)) {
                    categoryTotal += expense.getAmount();
                }
            }
            if (categoryTotal > 0) {
                System.out.printf("%-18s Rs. %.2f%n",
                        category, categoryTotal);
            }
        }
        System.out.println("============================================");
    }
    private void saveExpenses() {
        try (BufferedWriter writer =
                    new BufferedWriter(new FileWriter(EXPENSE_FILE))) {
            for (Expense expense : expenses) {
                writer.write(expense.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }
    private void loadExpenses() {
        File file = new File(EXPENSE_FILE);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader reader =
                    new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] data = line.split("\\|", -1);
                    if (data.length != 5) {
                        continue;
                    }
                    int id = Integer.parseInt(data[0]);
                    String description = data[1];
                    String category = data[2];
                    double amount = Double.parseDouble(data[3]);
                    LocalDate date = LocalDate.parse(data[4]);
                    if (description.isBlank()
                            || !Category.isValidCategory(category)
                            || amount <= 0) {
                        continue;
                    }
                    expenses.add(new Expense(id, description,
                            category, amount, date));
                    nextId = Math.max(nextId, id + 1);
                } catch (NumberFormatException | DateTimeParseException e) {
                    System.out.println("Skipping invalid expense record.");
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
        }
    }
    private void saveBudgets() {
        try (BufferedWriter writer =
                    new BufferedWriter(new FileWriter(BUDGET_FILE))) {
            for (Budget budget : budgets) {
                writer.write(budget.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving budgets: " + e.getMessage());
        }
    }
    private void loadBudgets() {
        File file = new File(BUDGET_FILE);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader reader =
                    new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] data = line.split("\\|", -1);
                    if (data.length != 2) {
                        continue;
                    }
                    YearMonth month = YearMonth.parse(data[0]);
                    double amount = Double.parseDouble(data[1]);
                    if (amount <= 0) {
                        continue;
                    }
                    budgets.add(new Budget(month, amount));
                } catch (java.time.format.DateTimeParseException | NumberFormatException e) {
                    System.out.println("Skipping invalid budget record.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading budgets: " + e.getMessage());
        }
    }
}