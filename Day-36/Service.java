public class Service extends Offering {
    private final double price;
    public Service(int id, String name, String category,
                String description, double price) {
        super(id, name, category, description);
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public void display() {
        System.out.println("Service ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Category: " + getCategory());
        System.out.println("Description: " + getDescription());
        System.out.println("Price: Rs. " + price);
        System.out.println("--------------------------------");
    }
}