
public class Developer extends Employee {
    private String programmingLanguage;

    public Developer(int id, String name, double salary,
                    String programmingLanguage) {
        super(id, name, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public void work() {
        System.out.println(getName() + " develops software using "
                + programmingLanguage + ".");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Developer");
        System.out.println("Programming Language: " + programmingLanguage);
    }
}
