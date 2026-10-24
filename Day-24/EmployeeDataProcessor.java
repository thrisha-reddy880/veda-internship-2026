import java.io.*;
import java.util.*;
class Employee {
    String id;
    String name;
    String department;
    double salary;
    Employee(String id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}
public class EmployeeDataProcessor {
    private static final String INPUT_FILE = "employees.csv";
    private static final String OUTPUT_FILE = "processed_employees.csv";
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Set<String> employeeIds = new HashSet<>();
        int totalRecords = 0;
        int invalidRecords = 0;
        // Read and validate CSV records
        try (BufferedReader br = new BufferedReader(
                new FileReader(INPUT_FILE))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                totalRecords++;
                String[] data = line.split(",", -1);
                if (data.length != 4) {
                    System.out.println("Invalid record: " + line);
                    System.out.println("Reason: Incorrect number of fields.");
                    invalidRecords++;
                    continue;
                }
                String id = data[0].trim();
                String name = data[1].trim();
                String department = data[2].trim();
                String salaryText = data[3].trim();
                if (id.isEmpty() || name.isEmpty()
                        || department.isEmpty() || salaryText.isEmpty()) {
                    System.out.println("Invalid record: " + line);
                    System.out.println("Reason: Missing employee fields.");
                    invalidRecords++;
                    continue;
                }
                if (employeeIds.contains(id)) {
                    System.out.println("Invalid record: " + line);
                    System.out.println("Reason: Duplicate employee ID.");
                    invalidRecords++;
                    continue;
                }
                double salary;
                try {
                    salary = Double.parseDouble(salaryText);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid record: " + line);
                    System.out.println("Reason: Salary must be numeric.");
                    invalidRecords++;
                    continue;
                }
                if (!Double.isFinite(salary) || salary < 0) {
                    System.out.println("Invalid record: " + line);
                    System.out.println("Reason: Salary cannot be negative or invalid.");
                    invalidRecords++;
                    continue;
                }
                Employee employee = new Employee(id, name, department, salary);
                employees.add(employee);
                employeeIds.add(id);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + INPUT_FILE);
            System.out.println("Please create employees.csv first.");
            return;
        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(OUTPUT_FILE))) {
            bw.write("EmployeeID,Name,Department,Salary");
            bw.newLine();
            for (Employee employee : employees) {
                bw.write(employee.id + ","
                        + employee.name + ","
                        + employee.department + ","
                        + employee.salary);
                bw.newLine();
            }
            System.out.println("\nProcessed CSV created successfully!");
        } catch (IOException e) {
            System.out.println("Error writing output: " + e.getMessage());
            return;
        }
        System.out.println("\n===== EMPLOYEE STATISTICS =====");
        System.out.println("Total Records   : " + totalRecords);
        System.out.println("Valid Employees : " + employees.size());
        System.out.println("Invalid Records: " + invalidRecords);
        if (!employees.isEmpty()) {
            double totalSalary = 0;
            double highestSalary = employees.get(0).salary;
            double lowestSalary = employees.get(0).salary;
            for (Employee employee : employees) {
                totalSalary += employee.salary;
                if (employee.salary > highestSalary) {
                    highestSalary = employee.salary;
                }
                if (employee.salary < lowestSalary) {
                    lowestSalary = employee.salary;
                }
            }
            double averageSalary = totalSalary / employees.size();
            System.out.printf("Total Salary    : Rs. %.2f%n", totalSalary);
            System.out.printf("Average Salary   : Rs. %.2f%n", averageSalary);
            System.out.printf("Highest Salary   : Rs. %.2f%n", highestSalary);
            System.out.printf("Lowest Salary    : Rs. %.2f%n", lowestSalary);
        } else {
            System.out.println("No valid employee records to calculate statistics.");
        }
        System.out.println("Output File     : " + OUTPUT_FILE);
    }
}