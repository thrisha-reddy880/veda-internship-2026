public class Employee {
    private final int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void updateDetails(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Employee ID : " + id);
        System.out.println("Name        : " + name);
        System.out.println("Department  : " + department);
        System.out.printf("Salary      : %.2f%n", salary);
        System.out.println("-----------------------------");
    }
}
