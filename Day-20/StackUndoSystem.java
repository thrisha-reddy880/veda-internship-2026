import java.util.Scanner;
import java.util.Stack;
public class StackUndoSystem {
    private static String text = "";
    private static final Stack<String> undoStack = new Stack<>();
    // Add new text
    public static void addText(Scanner sc) {
        System.out.print("Enter text to add: ");
        String newText = sc.nextLine();
        // Save previous state before editing
        undoStack.push(text);
        text = text + newText;
        System.out.println("Text added successfully!");
    }
    // Delete the last character
    public static void deleteLastCharacter() {
        if (text.isEmpty()) {
            System.out.println("Nothing to delete!");
            return;
        }
        // Save previous state
        undoStack.push(text);
        text = text.substring(0, text.length() - 1);
        System.out.println("Last character deleted!");
    }
    // Replace the entire text
    public static void replaceText(Scanner sc) {
        System.out.print("Enter new text: ");
        String newText = sc.nextLine();
        // Save previous state
        undoStack.push(text);
        text = newText;
        System.out.println("Text replaced successfully!");
    }
    // Display current text
    public static void displayText() {
        System.out.println("\n===== CURRENT TEXT =====");
        if (text.isEmpty()) {
            System.out.println("[Empty]");
        } else {
            System.out.println(text);
        }
        System.out.println("=======================");
    }
    // Undo the most recent editing operation
    public static void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo!");
            return;
        }
        text = undoStack.pop();
        System.out.println("Undo successful!");
        displayText();
    }
    // Display number of available undo operations
    public static void viewUndoCount() {
        System.out.println("Available undo operations: "
                + undoStack.size());
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int choice = 0;
            do {
                System.out.println("\n================================");
                System.out.println("      STACK UNDO SYSTEM");
                System.out.println("================================");
                System.out.println("1. Add Text");
                System.out.println("2. Delete Last Character");
                System.out.println("3. Replace Entire Text");
                System.out.println("4. Display Current Text");
                System.out.println("5. Undo Last Operation");
                System.out.println("6. View Undo Count");
                System.out.println("7. Exit");
                System.out.println("================================");
                System.out.print("Enter your choice: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid number!");
                    sc.nextLine();
                    continue;
                }
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1 -> {
                        addText(sc);
                    }
                    case 2 -> {
                        deleteLastCharacter();
                    }
                    case 3 -> {
                        replaceText(sc);
                    }
                    case 4 -> {
                        displayText();
                    }
                    case 5 -> {
                        undo();
                    }
                    case 6 -> {
                        viewUndoCount();
                    }
                    case 7 -> {
                        System.out.println("Thank you for using Stack Undo System!");
                    }
                    default -> {
                        System.out.println("Invalid choice! Select 1-7.");
                    }
                }
            } while (choice != 7);
        }
    }
}
