import java.util.Scanner;

public class StudentManagementSystem {

    static int[] studentIds = new int[100];
    static String[] studentNames = new String[100];
    static int[] studentAges = new int[100];

    static int studentCount = 0;

    // Add a new student
    static void addStudent(Scanner scanner) {

        if (studentCount == studentIds.length) {
            System.out.println("Student limit reached.");
            return;
        }

        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        // Check if ID already exists
        if (findStudent(id) != -1) {
            System.out.println("Student ID already exists.");
            return;
        }

        scanner.nextLine();

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();

        studentIds[studentCount] = id;
        studentNames[studentCount] = name;
        studentAges[studentCount] = age;

        studentCount++;

        System.out.println("Student added successfully.");
    }

    // Search for a student
    static void searchStudent(Scanner scanner) {

        System.out.print("Enter student ID to search: ");
        int id = scanner.nextInt();

        int index = findStudent(id);

        if (index == -1) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Student found:");
            System.out.println("ID   : " + studentIds[index]);
            System.out.println("Name : " + studentNames[index]);
            System.out.println("Age  : " + studentAges[index]);
        }
    }

    // Update student details
    static void updateStudent(Scanner scanner) {

        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();

        int index = findStudent(id);

        if (index == -1) {
            System.out.println("Student not found.");
            return;
        }

        scanner.nextLine();

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new age: ");
        int age = scanner.nextInt();

        studentNames[index] = name;
        studentAges[index] = age;

        System.out.println("Student details updated successfully.");
    }

    // Display all students
    static void displayStudents() {

        if (studentCount == 0) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\n------ Student Records ------");

        for (int i = 0; i < studentCount; i++) {

            System.out.println("ID   : " + studentIds[i]);
            System.out.println("Name : " + studentNames[i]);
            System.out.println("Age  : " + studentAges[i]);
            System.out.println("-----------------------------");
        }
    }

    // Find student by ID
    static int findStudent(int id) {

        for (int i = 0; i < studentCount; i++) {

            if (studentIds[i] == id) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student");
            System.out.println("4. Display Students");
            System.out.println("5. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addStudent(scanner);
                    break;

                case 2:
                    searchStudent(scanner);
                    break;

                case 3:
                    updateStudent(scanner);
                    break;

                case 4:
                    displayStudents();
                    break;

                case 5:
                    System.out.println("Thank you for using the Student Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
