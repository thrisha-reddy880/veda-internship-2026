import java.util.ArrayList;
import java.util.Scanner;
class Product {
    private final int id;
    private String name;
    private double price;
    private int quantity;
    Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    int getId() {
        return id;
    }
    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }
    void setPrice(double price) {
        this.price = price;
    }
    void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    void display() {
        System.out.printf(
            "ID: %d | Name: %s | Price: Rs. %.2f | Quantity: %d%n",
            id, getName(), price, quantity
        );
    }
}
public class InventorySystem {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Product> inventory = new ArrayList<>();
    public static void main(String[] args) {
        int choice;
        try (sc) {
            do {
                System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");
                System.out.println("1. Add Product");
                System.out.println("2. Display Products");
                System.out.println("3. Search Product");
                System.out.println("4. Update Product");
                System.out.println("5. Remove Product");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = readInt();
                switch (choice) {
                    case 1 -> addProduct();
                    case 2 -> displayProducts();
                    case 3 -> searchProduct();
                    case 4 -> updateProduct();
                    case 5 -> removeProduct();
                    case 6 -> System.out.println("Thank you for using Inventory System!");
                    default -> System.out.println("Invalid choice!");
                }
            } while (choice != 6);
        }
    }
    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid integer: ");
            }
        }
    }
    private static double readDouble() {
        while (true) {
            try {
                double value = Double.parseDouble(sc.nextLine().trim());
                if (Double.isFinite(value)) {
                    return value;
                }
            } catch (NumberFormatException e) {
                // Ask again below.
            }
            System.out.print("Enter a valid number: ");
        }
    }
    private static Product findProduct(int id) {
        for (Product product : inventory) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
    private static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = readInt();
        if (findProduct(id) != null) {
            System.out.println("Product ID already exists!");
            return;
        }
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter Product Price: ");
        double price = readDouble();
        System.out.print("Enter Product Quantity: ");
        int quantity = readInt();
        if (name.isEmpty() || price < 0 || quantity < 0) {
            System.out.println("Invalid product details!");
            return;
        }
        inventory.add(new Product(id, name, price, quantity));
        System.out.println("Product added successfully!");
    }
    private static void displayProducts() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("\n===== PRODUCT LIST =====");
        for (Product product : inventory) {
            product.display();
        }
    }
    private static void searchProduct() {
        System.out.print("Enter Product ID to search: ");
        int id = readInt();
        Product product = findProduct(id);
        if (product == null) {
            System.out.println("Product not found!");
        } else {
            System.out.println("Product found:");
            product.display();
        }
    }
    private static void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int id = readInt();
        Product product = findProduct(id);
        if (product == null) {
            System.out.println("Product not found!");
            return;
        }
        System.out.print("Enter new Product Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter new Product Price: ");
        double price = readDouble();
        System.out.print("Enter new Product Quantity: ");
        int quantity = readInt();
        if (name.isEmpty() || price < 0 || quantity < 0) {
            System.out.println("Invalid product details!");
            return;
        }
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        System.out.println("Product updated successfully!");
    }
    private static void removeProduct() {
        System.out.print("Enter Product ID to remove: ");
        int id = readInt();
        Product product = findProduct(id);
        if (product == null) {
            System.out.println("Product not found!");
        } else {
            inventory.remove(product);
            System.out.println("Product removed successfully!");
        }
    }
}
