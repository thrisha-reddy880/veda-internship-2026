import java.util.*;
import java.util.stream.Collectors;
public class EmployeeAnalyticsDemo {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Thrisha", "IT", 60000),
            new Employee(2, "Rahul", "HR", 45000),
            new Employee(3, "Priya", "IT", 75000),
            new Employee(4, "Arjun", "Finance", 55000),
            new Employee(5, "Sneha", "HR", 50000),
            new Employee(6, "Kiran", "Finance", 80000),
            new Employee(7, "Anjali", "IT", 65000),
            new Employee(8, "Vikram", "Sales", 40000),
            new Employee(9, "Meena", "Sales", 48000)
        );
        System.out.println("======================================");
        System.out.println("     EMPLOYEE ANALYTICS SYSTEM");
        System.out.println("======================================");
        System.out.println("\n1. ALL EMPLOYEE RECORDS");
        employees.forEach(System.out::println);
        System.out.println("\n2. DEPARTMENT-WISE EMPLOYEE COUNT");
        Map<String, Long> departmentCount =
            employees.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDepartment,
                    TreeMap::new,
                    Collectors.counting()
                ));
        departmentCount.forEach((department, count) ->
            System.out.println(department + ": " + count + " employees")
        );
        System.out.println("\n3. DEPARTMENT-WISE AVERAGE SALARY");
        Map<String, Double> departmentAverage =
            employees.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDepartment,
                    TreeMap::new,
                    Collectors.averagingDouble(Employee::getSalary)
                ));
        departmentAverage.forEach((department, average) ->
            System.out.printf("%s: Rs. %.2f%n", department, average)
        );
        System.out.println("\n4. DEPARTMENT-WISE TOTAL SALARY");
        Map<String, Double> departmentTotal =
            employees.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDepartment,
                    TreeMap::new,
                    Collectors.summingDouble(Employee::getSalary)
                ));
        departmentTotal.forEach((department, total) ->
            System.out.printf("%s: Rs. %.2f%n", department, total)
        );
        System.out.println("\n5. HIGHEST-PAID EMPLOYEE");
        Employee highestPaid = employees.stream()
            .max(Comparator.comparingDouble(Employee::getSalary))
            .orElseThrow();
        System.out.println(highestPaid);
        System.out.println("\n6. LOWEST-PAID EMPLOYEE");
        Employee lowestPaid = employees.stream()
            .min(Comparator.comparingDouble(Employee::getSalary))
            .orElseThrow();
        System.out.println(lowestPaid);
        System.out.println("\n7. EMPLOYEE RANKING (Highest to Lowest)");
        List<Employee> ranking = employees.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary)
                    .reversed())
            .collect(Collectors.toList());
        for (int i = 0; i < ranking.size(); i++) {
            System.out.println(
                (i + 1) + ". " + ranking.get(i)
            );
        }
        double totalSalary = employees.stream()
            .mapToDouble(Employee::getSalary)
            .sum();
        double averageSalary = employees.stream()
            .mapToDouble(Employee::getSalary)
            .average()
            .orElse(0.0);
        System.out.println("\n======================================");
        System.out.println("          SUMMARY REPORT");
        System.out.println("======================================");
        System.out.println("Total Employees: " + employees.size());
        System.out.printf("Total Salary: Rs. %.2f%n", totalSalary);
        System.out.printf("Average Salary: Rs. %.2f%n", averageSalary);
        System.out.println(
            "Highest Salary: Rs. " + highestPaid.getSalary()
        );
        System.out.println(
            "Lowest Salary: Rs. " + lowestPaid.getSalary()
        );
        System.out.println(
            "Number of Departments: " + departmentCount.size()
        );
        System.out.println("\nAnalytics Completed Successfully!");
    }
}