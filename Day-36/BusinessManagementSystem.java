import java.util.ArrayList;
import java.util.Scanner;
public class BusinessManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Offering> offerings = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Inquiry> inquiries = new ArrayList<>();
    static int nextOfferingId = 4;
    static int nextCustomerId = 3;
    static int nextInquiryId = 3;
    static void loadSampleData() {
        offerings.add(new Service(1, "Web Development",
                "IT Services", "Website development services", 15000));
        offerings.add(new TrainingProgram(2, "Java Training",
                "Training", "Core Java programming", 6));
        offerings.add(new InternshipProgram(3, "Software Internship",
                "Internship", "Practical software development", 8));
        customers.add(new Customer(1, "Rahul",
                "rahul@example.com", "9876543210"));
        customers.add(new Customer(2, "Priya",
                "priya@example.com", "9876501234"));
        inquiries.add(new Inquiry(1, 1, "Website Development",
                "IT Services", "Pending"));
        inquiries.add(new Inquiry(2, 2, "Java Training Details",
                "Training", "Resolved"));
    }
    static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(sc.nextLine());
                if (value < 0) {
                    System.out.println("Enter a valid positive number.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a number.");
            }
        }
    }
    static double readDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                double value = Double.parseDouble(sc.nextLine());
                if (value < 0) {
                    System.out.println("Enter a valid amount.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a valid amount.");
            }
        }
    }
    static void addCustomer() {
        System.out.println("\n--- Register Customer ---");
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();
        if (name.isBlank() || email.isBlank() || phone.isBlank()) {
            System.out.println("All fields are required!");
            return;
        }
        Customer customer = new Customer(
                nextCustomerId++, name, email, phone);
        customers.add(customer);
        System.out.println("Customer registered successfully!");
    }
    static void viewCustomers() {
        System.out.println("\n--- Customer List ---");
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        for (Customer customer : customers) {
            customer.display();
        }
    }
    static void addOffering() {
        System.out.println("\n--- Add Service / Program ---");
        System.out.println("1. Technology Service");
        System.out.println("2. Training Program");
        System.out.println("3. Internship Program");
        int choice = readInt("Enter choice: ");
        if (choice < 1 || choice > 3) {
            System.out.println("Invalid choice!");
            return;
        }
        int id = nextOfferingId++;
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter category: ");
        String category = sc.nextLine();
        System.out.print("Enter description: ");
        String description = sc.nextLine();
        if (name.isBlank() || category.isBlank()
                || description.isBlank()) {
            System.out.println("All fields are required!");
            nextOfferingId--;
            return;
        }
        if (choice == 1) {
            double price = readDouble("Enter service price: ");
            offerings.add(new Service(id, name, category,
                    description, price));
        } else {
            int duration = readInt("Enter duration in weeks: ");
            if (duration <= 0) {
                System.out.println("Duration must be greater than zero.");
                nextOfferingId--;
                return;
            }
            if (choice == 2) {
                offerings.add(new TrainingProgram(id, name,
                        category, description, duration));
            } else {
                offerings.add(new InternshipProgram(id, name,
                        category, description, duration));
            }
        }
        System.out.println("Service / Program added successfully!");
    }
    static void viewOfferings() {
        System.out.println("\n--- Services and Programs ---");
        if (offerings.isEmpty()) {
            System.out.println("No services or programs found.");
            return;
        }
        for (Offering offering : offerings) {
            offering.display();
        }
    }
    static void searchOfferings() {
        System.out.print("\nEnter category to search: ");
        String category = sc.nextLine();
        boolean found = false;
        for (Offering offering : offerings) {
            if (offering.getCategory().equalsIgnoreCase(category)) {
                offering.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching service or program found.");
        }
    }
    static void submitInquiry() {
        System.out.println("\n--- Submit Inquiry ---");
        int customerId = readInt("Enter customer ID: ");
        boolean customerFound = false;
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                customerFound = true;
                break;
            }
        }
        if (!customerFound) {
            System.out.println("Customer record not found!");
            return;
        }
        System.out.print("Enter inquiry subject: ");
        String subject = sc.nextLine();
        System.out.print("Enter category: ");
        String category = sc.nextLine();
        if (subject.isBlank() || category.isBlank()) {
            System.out.println("Subject and category are required!");
            return;
        }
        Inquiry inquiry = new Inquiry(nextInquiryId++,
                customerId, subject, category, "Pending");
        inquiries.add(inquiry);
        System.out.println("Inquiry submitted successfully!");
    }
    static void viewInquiries() {
        System.out.println("\n--- Customer Inquiries ---");
        if (inquiries.isEmpty()) {
            System.out.println("No inquiries available.");
            return;
        }
        for (Inquiry inquiry : inquiries) {
            inquiry.display();
        }
    }
    static void searchInquiries() {
        System.out.print("\nEnter inquiry status (Pending/Resolved): ");
        String status = sc.nextLine();
        boolean found = false;
        for (Inquiry inquiry : inquiries) {
            if (inquiry.getStatus().equalsIgnoreCase(status)) {
                inquiry.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No inquiries found with that status.");
        }
    }
    static void generateReport() {
        System.out.println("\n========== BUSINESS REPORT ==========");
        System.out.println("Total Services / Programs: " + offerings.size());
        System.out.println("Total Customers: " + customers.size());
        System.out.println("Total Inquiries: " + inquiries.size());
        int pending = 0;
        int resolved = 0;
        for (Inquiry inquiry : inquiries) {
            if (inquiry.getStatus().equalsIgnoreCase("Pending")) {
                pending++;
            } else if (inquiry.getStatus().equalsIgnoreCase("Resolved")) {
                resolved++;
            }
        }
        System.out.println("Pending Inquiries: " + pending);
        System.out.println("Resolved Inquiries: " + resolved);
        System.out.println("=====================================");
    }
    public static void main(String[] args) {
        loadSampleData();
        int choice;
        do {
            System.out.println("\n======================================");
            System.out.println(" VEDA TECHNOLOGY BUSINESS MANAGEMENT");
            System.out.println("======================================");
            System.out.println("1. Register Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Add Service / Program");
            System.out.println("4. View Services and Programs");
            System.out.println("5. Search / Filter by Category");
            System.out.println("6. Submit Customer Inquiry");
            System.out.println("7. View All Inquiries");
            System.out.println("8. Search Inquiries by Status");
            System.out.println("9. Generate Business Report");
            System.out.println("10. Exit");
            choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> addCustomer();
                case 2 -> viewCustomers();
                case 3 -> addOffering();
                case 4 -> viewOfferings();
                case 5 -> searchOfferings();
                case 6 -> submitInquiry();
                case 7 -> viewInquiries();
                case 8 -> searchInquiries();
                case 9 -> generateReport();
                case 10 -> System.out.println("Thank you for using Veda Technology!");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 10);
        sc.close();
    }
}