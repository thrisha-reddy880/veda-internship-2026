public class Employee {
    private final int id;
    private final String name;
    private final String department;
    private final double salary;
    private final int age;
    public Employee(int id, String name, String department,
                    double salary, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
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
    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return String.format(
            "ID: %d | Name: %s | Department: %s | Salary: %.2f | Age: %d",
            id, name, department, salary, age
        );
    }
}