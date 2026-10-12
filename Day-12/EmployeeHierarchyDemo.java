
public class EmployeeHierarchyDemo {
    public static void main(String[] args) {

        Employee developer = new Developer(
                101, "Rahul", 45000, "Java");

        Employee manager = new Manager(
                102, "Priya", 65000, 5);

        Employee intern = new Intern(
                103, "Arun", 15000, "3 Months");

        System.out.println("===== DEVELOPER DETAILS =====");
        developer.displayDetails();
        developer.work();

        System.out.println("\n===== MANAGER DETAILS =====");
        manager.displayDetails();
        manager.work();

        System.out.println("\n===== INTERN DETAILS =====");
        intern.displayDetails();
        intern.work();
    }

        private abstract static class Employee {
                private final int id;
                private final String name;
                private final double salary;

                Employee(int id, String name, double salary) {
                        this.id = id;
                        this.name = name;
                        this.salary = salary;
                }

                void displayDetails() {
                        System.out.println("ID: " + id);
                        System.out.println("Name: " + name);
                        System.out.println("Salary: " + salary);
                }

                abstract void work();
        }

        private static class Developer extends Employee {
                private final String language;

                Developer(int id, String name, double salary, String language) {
                        super(id, name, salary);
                        this.language = language;
                }

                @Override
                void work() {
                        System.out.println("Developing software using " + language + ".");
                }
        }

        private static class Manager extends Employee {
                private final int teamSize;

                Manager(int id, String name, double salary, int teamSize) {
                        super(id, name, salary);
                        this.teamSize = teamSize;
                }

                @Override
                void displayDetails() {
                        super.displayDetails();
                        System.out.println("Team size: " + teamSize);
                }

                @Override
                void work() {
                        System.out.println("Managing a team of " + teamSize + " employees.");
                }
        }

        private static class Intern extends Employee {
                private final String duration;

                Intern(int id, String name, double salary, String duration) {
                        super(id, name, salary);
                        this.duration = duration;
                }

                @Override
                void displayDetails() {
                        super.displayDetails();
                        System.out.println("Internship duration: " + duration);
                }

                @Override
                void work() {
                        System.out.println("Assisting the team during the internship.");
                }
        }
}
