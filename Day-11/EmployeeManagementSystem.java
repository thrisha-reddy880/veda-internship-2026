import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {
    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. List All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = readInt();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> searchEmployee();
                case 3 -> updateEmployee();
                case 4 -> listEmployees();
                case 5 -> System.out.println("Thank you for using the system!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }

    static int readInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            sc.next();
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    static double readSalary() {
        while (true) {
            System.out.print("Enter salary: ");

            if (sc.hasNextDouble()) {
                double salary = sc.nextDouble();
                sc.nextLine();

                if (Double.isFinite(salary) && salary >= 0) {
                    return salary;
                }
            } else {
                sc.next();
                sc.nextLine();
            }

            System.out.println("Enter a valid non-negative salary.");
        }
    }

    static Employee findEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    static void addEmployee() {
        System.out.print("Enter employee ID: ");
        int id = readInt();

        if (findEmployee(id) != null) {
            System.out.println("Employee ID already exists!");
            return;
        }

        System.out.print("Enter employee name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter department: ");
        String department = sc.nextLine().trim();

        if (name.isEmpty() || department.isEmpty()) {
            System.out.println("Name and department cannot be empty.");
            return;
        }

        double salary = readSalary();

        Employee employee = new Employee(id, name, department, salary);
        employees.add(employee);

        System.out.println("Employee added successfully!");
    }

    static void searchEmployee() {
        System.out.print("Enter employee ID to search: ");
        int id = readInt();

        Employee employee = findEmployee(id);

        if (employee != null) {
            System.out.println("\nEmployee Found:");
            employee.displayDetails();
        } else {
            System.out.println("Employee not found!");
        }
    }

    static void updateEmployee() {
        System.out.print("Enter employee ID to update: ");
        int id = readInt();

        Employee employee = findEmployee(id);

        if (employee == null) {
            System.out.println("Employee not found!");
            return;
        }

        System.out.print("Enter new name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter new department: ");
        String department = sc.nextLine().trim();

        if (name.isEmpty() || department.isEmpty()) {
            System.out.println("Name and department cannot be empty.");
            return;
        }

        double salary = readSalary();

        employee.updateDetails(name, department, salary);
        System.out.println("Employee updated successfully!");
    }

    static void listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees available.");
            return;
        }

        System.out.println("\n===== EMPLOYEE LIST =====");

        for (Employee employee : employees) {
            employee.displayDetails();
        }
    }

    static class Employee {
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

        int getId() {
            return id;
        }

        void updateDetails(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        void displayDetails() {
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Department: " + department);
            System.out.println("Salary: " + salary);
        }
    }
}