import java.util.*;
import java.util.stream.Collectors;
public class EmployeeStreamDemo {
    public static void main(String[] args) {
        // Employee data
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Thrisha", "IT", 60000, 22),
            new Employee(2, "Rahul", "HR", 45000, 25),
            new Employee(3, "Priya", "IT", 75000, 24),
            new Employee(4, "Arjun", "Finance", 55000, 28),
            new Employee(5, "Sneha", "HR", 50000, 23),
            new Employee(6, "Kiran", "Finance", 80000, 30),
            new Employee(7, "Anjali", "IT", 65000, 26)
        );
        System.out.println("===== EMPLOYEE DATA PROCESSING USING STREAMS =====");
        // 1. Display all employees
        System.out.println("\n1. ALL EMPLOYEES");
        employees.forEach(System.out::println);
        // 2. Filter employees with salary greater than 50000
        System.out.println("\n2. FILTERING (Salary > 50000)");
        employees.stream()
            .filter(e -> e.getSalary() > 50000)
            .forEach(System.out::println);
        // 3. Sort employees by salary (ascending)
        System.out.println("\n3. SORTING BY SALARY (Ascending)");
        employees.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary))
            .forEach(System.out::println);
        // 4. Transform employee names to uppercase
        System.out.println("\n4. TRANSFORMING NAMES TO UPPERCASE");
        List<String> names = employees.stream()
            .map(e -> e.getName().toUpperCase())
            .collect(Collectors.toList());
        names.forEach(System.out::println);
        // 5. Group employees by department
        System.out.println("\n5. GROUPING BY DEPARTMENT");
        Map<String, List<Employee>> groupedEmployees =
            employees.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDepartment,
                    TreeMap::new,
                    Collectors.toList()
                ));
        groupedEmployees.forEach((department, employeeList) -> {
            System.out.println("\nDepartment: " + department);
            employeeList.forEach(System.out::println);
        });
        // 6. Count total employees
        long totalEmployees = employees.stream().count();
        // 7. Calculate average salary
        double averageSalary = employees.stream()
            .mapToDouble(Employee::getSalary)
            .average()
            .orElse(0.0);
        // 8. Calculate total salary
        double totalSalary = employees.stream()
            .mapToDouble(Employee::getSalary)
            .sum();
        // 9. Find highest salary
        Optional<Employee> highestPaid = employees.stream()
            .max(Comparator.comparingDouble(Employee::getSalary));
        // 10. Department-wise employee count
        System.out.println("\n6. DEPARTMENT-WISE EMPLOYEE COUNT");
        groupedEmployees.forEach((department, employeeList) ->
            System.out.println(
                department + ": " + employeeList.size() + " employees"
            )
        );
        // 11. Summary report
        System.out.println("\n7. EMPLOYEE SUMMARY REPORT");
        System.out.println("Total Employees: " + totalEmployees);
        System.out.printf("Average Salary: %.2f%n", averageSalary);
        System.out.printf("Total Salary: %.2f%n", totalSalary);
        highestPaid.ifPresent(employee ->
            System.out.println("Highest Paid Employee: " + employee)
        );
        System.out.println("\n===== PROCESSING COMPLETED =====");
    }
}
