import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
class Ticket {
    private final int ticketId;
    private final String customerName;
    private final String issue;
    private String status;
    public Ticket(int ticketId, String customerName, String issue) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.issue = issue;
        this.status = "Waiting";
    }
    public int getTicketId() {
        return ticketId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getIssue() {
        return issue;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void displayTicket() {
        System.out.println("--------------------------------");
        System.out.println("Ticket ID     : " + ticketId);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Issue         : " + issue);
        System.out.println("Status        : " + status);
        System.out.println("--------------------------------");
    }
}
public class CustomerSupportQueue {
    private static final Queue<Ticket> ticketQueue = new ArrayDeque<>();
    private static final Map<Integer, Ticket> allTickets = new HashMap<>();
    private static final List<Ticket> processedTickets = new ArrayList<>();
    private static int nextTicketId = 1;
    // Create a new customer support ticket
    public static void createTicket(Scanner sc) {
        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine().trim();
        System.out.print("Enter customer issue: ");
        String issue = sc.nextLine().trim();
        if (customerName.isEmpty() || issue.isEmpty()) {
            System.out.println("Name and issue cannot be empty!");
            return;
        }
        Ticket ticket = new Ticket(
            nextTicketId++,
            customerName,
            issue
        );
        ticketQueue.offer(ticket);
        allTickets.put(ticket.getTicketId(), ticket);
        System.out.println("\nTicket created successfully!");
        System.out.println("Your Ticket ID: " + ticket.getTicketId());
        System.out.println("Status: Waiting");
    }
    // Display all waiting tickets
    public static void viewQueue() {
        if (ticketQueue.isEmpty()) {
            System.out.println("\nNo tickets are waiting.");
            return;
        }
        System.out.println("\n===== CUSTOMER SUPPORT QUEUE =====");
        for (Ticket ticket : ticketQueue) {
            ticket.displayTicket();
        }
    }
    // Process the oldest waiting ticket
    public static void processNextTicket() {
        Ticket ticket = ticketQueue.poll();
        if (ticket == null) {
            System.out.println("\nNo tickets available for processing.");
            return;
        }
        ticket.setStatus("Resolved");
        processedTickets.add(ticket);
        System.out.println("\n===== TICKET PROCESSED =====");
        ticket.displayTicket();
        System.out.println("Ticket has been resolved.");
    }
    // Search ticket and display its current status
    public static void trackTicket(Scanner sc) {
        System.out.print("Enter Ticket ID: ");
        if (!sc.hasNextInt()) {
            System.out.println("Please enter a valid numeric Ticket ID.");
            sc.nextLine();
            return;
        }
        int id = sc.nextInt();
        sc.nextLine();
        Ticket ticket = allTickets.get(id);
        if (ticket == null) {
            System.out.println("Ticket not found!");
            return;
        }
        System.out.println("\n===== TICKET STATUS =====");
        ticket.displayTicket();
    }
    // Display resolved tickets
    public static void viewProcessedTickets() {
        if (processedTickets.isEmpty()) {
            System.out.println("\nNo tickets have been processed yet.");
            return;
        }
        System.out.println("\n===== RESOLVED TICKETS =====");
        for (Ticket ticket : processedTickets) {
            ticket.displayTicket();
        }
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int choice = 0;
            do {
                System.out.println("\n================================");
                System.out.println("   CUSTOMER SUPPORT SYSTEM");
                System.out.println("================================");
                System.out.println("1. Create New Ticket");
                System.out.println("2. View Waiting Queue");
                System.out.println("3. Process Next Ticket");
                System.out.println("4. Track Ticket Status");
                System.out.println("5. View Resolved Tickets");
                System.out.println("6. Exit");
                System.out.println("================================");
                System.out.print("Enter your choice: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    sc.nextLine();
                    continue;
                }
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1 -> createTicket(sc);
                    case 2 -> viewQueue();
                    case 3 -> processNextTicket();
                    case 4 -> trackTicket(sc);
                    case 5 -> viewProcessedTickets();
                    case 6 -> System.out.println("Thank you for using Customer Support System!");
                    default -> System.out.println("Invalid choice! Please select 1-6.");
                }
            } while (choice != 6);
        }
    }
}
