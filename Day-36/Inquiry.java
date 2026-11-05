public class Inquiry {
    private final int id;
    private final int customerId;
    private final String subject;
    private final String category;
    private final String status;
    public Inquiry(int id, int customerId, String subject,
                String category, String status) {
        this.id = id;
        this.customerId = customerId;
        this.subject = subject;
        this.category = category;
        this.status = status;
    }
    public int getId() {
        return id;
    }
    public int getCustomerId() {
        return customerId;
    }
    public String getCategory() {
        return category;
    }
    public String getStatus() {
        return status;
    }
    public void display() {
        System.out.println("Inquiry ID: " + id);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Subject: " + subject);
        System.out.println("Category: " + category);
        System.out.println("Status: " + status);
        System.out.println("--------------------------------");
    }
}