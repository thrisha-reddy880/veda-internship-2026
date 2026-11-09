import java.util.Arrays;
import java.util.List;
public class Category {
    private static final List<String> CATEGORIES = Arrays.asList(
            "Food",
            "Transport",
            "Shopping",
            "Education",
            "Health",
            "Entertainment",
            "Bills",
            "Other"
    );
    public static List<String> getCategories() {
        return CATEGORIES;
    }
    public static boolean isValidCategory(String category) {
        for (String item : CATEGORIES) {
            if (item.equalsIgnoreCase(category)) {
                return true;
            }
        }
        return false;
    }
    public static void displayCategories() {
        System.out.println("\nAvailable Categories:");
        for (int i = 0; i < CATEGORIES.size(); i++) {
            System.out.println((i + 1) + ". " + CATEGORIES.get(i));
        }
    }
    public static String getCategory(int choice) {
        if (choice >= 1 && choice <= CATEGORIES.size()) {
            return CATEGORIES.get(choice - 1);
        }
        return null;
    }
}