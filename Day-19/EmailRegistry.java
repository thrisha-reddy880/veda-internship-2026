import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class EmailRegistry {
    private static Scanner sc;
    private static final Set<String> emails = new HashSet<>();
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            sc = scanner;
            int choice;
            do {
                System.out.println("\n===== UNIQUE EMAIL REGISTRY =====");
                System.out.println("1. Register Email");
                System.out.println("2. Remove Email");
                System.out.println("3. Search Email");
                System.out.println("4. Display All Emails");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = readInt();
                switch (choice) {
                    case 1 -> registerEmail();
                    case 2 -> removeEmail();
                    case 3 -> searchEmail();
                    case 4 -> displayEmails();
                    case 5 -> System.out.println("Thank you for using Email Registry!");
                    default -> System.out.println("Invalid choice!");
                }
            } while (choice != 5);
        }
    }
    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
    // Normalize email so case and surrounding spaces don't create duplicates.
    private static String normalizeEmail(String email) {
        return email.trim().toLowerCase();
    }
    private static boolean isValidEmail(String email) {
        return email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");
    }
    private static void registerEmail() {
        System.out.print("Enter email address: ");
        String email = normalizeEmail(sc.nextLine());
        if (!isValidEmail(email)) {
            System.out.println("Invalid email address!");
            return;
        }
        if (emails.add(email)) {
            System.out.println("Email registered successfully!");
        } else {
            System.out.println("Email already registered! Duplicate not allowed.");
        }
    }
    private static void removeEmail() {
        System.out.print("Enter email to remove: ");
        String email = normalizeEmail(sc.nextLine());
        if (emails.remove(email)) {
            System.out.println("Email removed successfully!");
        } else {
            System.out.println("Email not found!");
        }
    }
    private static void searchEmail() {
        System.out.print("Enter email to search: ");
        String email = normalizeEmail(sc.nextLine());
        if (emails.contains(email)) {
            System.out.println("Email is registered.");
        } else {
            System.out.println("Email is not registered.");
        }
    }
    private static void displayEmails() {
        if (emails.isEmpty()) {
            System.out.println("No registered emails found.");
            return;
        }
        System.out.println("\n===== REGISTERED EMAILS =====");
        for (String email : emails) {
            System.out.println(email);
        }
        System.out.println("Total registered emails: " + emails.size());
    }
}
