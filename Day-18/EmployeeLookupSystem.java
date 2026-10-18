import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class Employee {
    private final int id;
    private String name;
    private String department;
    private double salary;
    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    void update(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    void display() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.printf("Salary: Rs. %.2f%n", salary);
    }
}
public class EmployeeLookupSystem {
    private static final HashMap<Integer, Employee> employees = new HashMap<>();
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int choice;
            do {
                System.out.println("\n===== EMPLOYEE LOOKUP SYSTEM =====");
                System.out.println("1. Add Employee");
                System.out.println("2. Search Employee by ID");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Display All Employees");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = readInt(sc);
                switch (choice) {
                    case 1 -> addEmployee(sc);
                    case 2 -> searchEmployee(sc);
                    case 3 -> updateEmployee(sc);
                    case 4 -> deleteEmployee(sc);
                    case 5 -> displayEmployees();
                    case 6 -> System.out.println("Thank you for using the system!");
                    default -> System.out.println("Invalid choice!");
                }
            } while (choice != 6);
        }
    }
    private static int readInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid integer: ");
            }
        }
    }
    private static double readDouble(Scanner sc) {
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
    private static void addEmployee(Scanner sc) {
        System.out.print("Enter Employee ID: ");
        int id = readInt(sc);
        if (employees.containsKey(id)) {
            System.out.println("Employee ID already exists!");
            return;
        }
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter Department: ");
        String department = sc.nextLine().trim();
        System.out.print("Enter Salary: ");
        double salary = readDouble(sc);
        if (id <= 0 || name.isEmpty() || department.isEmpty() || salary < 0) {
            System.out.println("Invalid employee details!");
            return;
        }
        employees.put(id, new Employee(id, name, department, salary));
        System.out.println("Employee added successfully!");
    }
    private static void searchEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to search: ");
        int id = readInt(sc);
        Employee employee = employees.get(id);
        if (employee == null) {
            System.out.println("Employee not found!");
        } else {
            System.out.println("\n===== EMPLOYEE DETAILS =====");
            employee.display();
        }
    }
    private static void updateEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to update: ");
        int id = readInt(sc);
        Employee employee = employees.get(id);
        if (employee == null) {
            System.out.println("Employee not found!");
            return;
        }
        System.out.print("Enter new Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter new Department: ");
        String department = sc.nextLine().trim();
        System.out.print("Enter new Salary: ");
        double salary = readDouble(sc);
        if (name.isEmpty() || department.isEmpty() || salary < 0) {
            System.out.println("Invalid employee details!");
            return;
        }
        employee.update(name, department, salary);
        System.out.println("Employee updated successfully!");
    }
    private static void deleteEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to delete: ");
        int id = readInt(sc);
        Employee removed = employees.remove(id);
        if (removed == null) {
            System.out.println("Employee not found!");
        } else {
            System.out.println("Employee deleted successfully!");
        }
    }
    private static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("\n===== ALL EMPLOYEES =====");
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            System.out.println("--------------------");
            entry.getValue().display();
        }
    }
}
