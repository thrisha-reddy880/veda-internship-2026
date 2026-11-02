import java.util.ArrayList;
import java.util.Scanner;
public class StudentGradeManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
    static double readDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                double value =
                    Double.parseDouble(sc.nextLine().trim());
                if (!Double.isFinite(value)) {
                    System.out.println("Enter a valid finite number.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    static void addStudent() {
        System.out.println("\n--- ADD STUDENT ---");
        int id = readInt("Enter Student ID: ");
        if (id <= 0) {
            System.out.println("Student ID must be positive!");
            return;
        }
        if (findStudent(id) != null) {
            System.out.println("Student ID already exists!");
            return;
        }
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }
        int age = readInt("Enter Age: ");
        if (age <= 0) {
            System.out.println("Invalid age!");
            return;
        }
        students.add(new Student(id, name, age));
        System.out.println("Student added successfully!");
    }
    static void viewStudents() {
        System.out.println("\n--- ALL STUDENTS ---");
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        for (Student student : students) {
            student.displayStudent();
        }
    }
    static void searchStudent() {
        System.out.println("\n--- SEARCH STUDENT ---");
        int id = readInt("Enter Student ID: ");
        Student student = findStudent(id);
        if (student != null) {
            System.out.println("Student found!");
            student.displayStudent();
        } else {
            System.out.println("Student not found!");
        }
    }
    static void updateStudent() {
        System.out.println("\n--- UPDATE STUDENT ---");
        int id = readInt("Enter Student ID: ");
        Student student = findStudent(id);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        System.out.print("Enter New Name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }
        int age = readInt("Enter New Age: ");
        if (age <= 0) {
            System.out.println("Invalid age!");
            return;
        }
        student.setName(name);
        student.setAge(age);
        System.out.println("Student updated successfully!");
    }
    static void deleteStudent() {
        System.out.println("\n--- DELETE STUDENT ---");
        int id = readInt("Enter Student ID: ");
        Student student = findStudent(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
    static void addSubject() {
        System.out.println("\n--- ADD SUBJECT / MARKS ---");
        int id = readInt("Enter Student ID: ");
        Student student = findStudent(id);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        System.out.print("Enter Subject Name: ");
        String subjectName = sc.nextLine().trim();
        if (subjectName.isEmpty()) {
            System.out.println("Subject name cannot be empty!");
            return;
        }
        if (student.findSubject(subjectName) != null) {
            System.out.println("Subject already exists!");
            return;
        }
        double maxMarks = readDouble("Enter Maximum Marks: ");
        if (maxMarks <= 0) {
            System.out.println("Maximum marks must be positive!");
            return;
        }
        double marks = readDouble("Enter Obtained Marks: ");
        if (marks < 0 || marks > maxMarks) {
            System.out.println("Marks must be between 0 and "
                    + maxMarks + "!");
            return;
        }
        student.addSubject(
            new Subject(subjectName, marks, maxMarks)
        );
        System.out.println("Subject added successfully!");
    }
    static void updateMarks() {
        System.out.println("\n--- UPDATE SUBJECT MARKS ---");
        int id = readInt("Enter Student ID: ");
        Student student = findStudent(id);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        System.out.print("Enter Subject Name: ");
        String subjectName = sc.nextLine().trim();
        Subject subject = student.findSubject(subjectName);
        if (subject == null) {
            System.out.println("Subject not found!");
            return;
        }
        double marks = readDouble("Enter New Marks: ");
        if (marks < 0 || marks > subject.getMaxMarks()) {
            System.out.println("Invalid marks! Maximum allowed: "
                    + subject.getMaxMarks());
            return;
        }
        subject.setMarks(marks);
        System.out.println("Marks updated successfully!");
    }
    static void deleteSubject() {
        System.out.println("\n--- DELETE SUBJECT ---");
        int id = readInt("Enter Student ID: ");
        Student student = findStudent(id);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        System.out.print("Enter Subject Name: ");
        String subjectName = sc.nextLine().trim();
        if (student.removeSubject(subjectName)) {
            System.out.println("Subject deleted successfully!");

        } else {
            System.out.println("Subject not found!");
        }
    }
    static void performanceSummary() {
        System.out.println("\n--- ACADEMIC PERFORMANCE SUMMARY ---");
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }
        int gradedCount = 0;
        double totalPercentage = 0;
        Student topper = null;
        double highestPercentage = -1;
        for (Student student : students) {
            if (student.getSubjects().isEmpty()) {
                continue;
            }
            double percentage =
                Grade.calculatePercentage(student.getSubjects());
            totalPercentage += percentage;
            gradedCount++;
            if (percentage > highestPercentage) {
                highestPercentage = percentage;
                topper = student;
            }
        }
        System.out.println("Total Students: " + students.size());
        System.out.println("Students with Marks: " + gradedCount);
        System.out.println("Students without Marks: "
                + (students.size() - gradedCount));
        if (gradedCount == 0) {
            System.out.println("No marks available for analysis.");
            return;
        }
        System.out.printf("Average Percentage: %.2f%%%n",
                totalPercentage / gradedCount);
        System.out.println("\nTop Performing Student:");
        if (topper == null) {
            System.out.println("No top performing student available.");
            return;
        }
        System.out.println("Name: " + topper.getName());
        System.out.println("ID: " + topper.getId());
        System.out.printf("Percentage: %.2f%%%n",
                highestPercentage);
        System.out.println("Grade: "
                + Grade.calculateGrade(highestPercentage));
    }
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n======================================");
            System.out.println("   STUDENT GRADE MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Add Subject and Marks");
            System.out.println("7. Update Subject Marks");
            System.out.println("8. Delete Subject");
            System.out.println("9. Performance Summary");
            System.out.println("0. Exit");
            System.out.println("======================================");
            choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> addSubject();
                case 7 -> updateMarks();
                case 8 -> deleteSubject();
                case 9 -> performanceSummary();
                case 0 -> System.out.println(
                    "Thank you for using Student Grade Management System!"
                );
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);
        sc.close();
    }
}