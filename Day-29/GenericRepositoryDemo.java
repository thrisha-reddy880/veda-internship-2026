
public class GenericRepositoryDemo {

    public static void main(String[] args) {

        // Student repository
        GenericRepository<Student> students =
                new GenericRepository<>();

        System.out.println("=== STUDENT REPOSITORY ===");

        // Create
        students.save(1, new Student("Thrisha", 20));
        students.save(2, new Student("Rahul", 21));

        System.out.println("\nAll Students:");
        students.displayAll();

        // Read
        System.out.println("\nFind Student with ID 1:");
        System.out.println(students.findById(1));

        // Update
        students.update(2, new Student("Rahul", 22));
        System.out.println("\nAfter Updating Student:");
        students.displayAll();

        // Delete
        students.delete(1);
        System.out.println("\nAfter Deleting Student ID 1:");
        students.displayAll();

        // Product repository
        GenericRepository<Product> products =
                new GenericRepository<>();

        System.out.println("\n=== PRODUCT REPOSITORY ===");

        products.save(101, new Product("Laptop", 55000));
        products.save(102, new Product("Mouse", 500));

        System.out.println("\nAll Products:");
        products.displayAll();

        System.out.println("\nFind Product with ID 101:");
        System.out.println(products.findById(101));

        products.update(102, new Product("Wireless Mouse", 800));
        System.out.println("\nAfter Updating Product:");
        products.displayAll();

        products.delete(101);
        System.out.println("\nAfter Deleting Product ID 101:");
        products.displayAll();
    }
}
