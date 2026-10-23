import java.io.*;
import java.util.*;

public class StudentRecordSystem {

    private static final String FILE_NAME = "students.txt";
    public static void addStudent(Scanner sc) {

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine().trim();

        if (id.isEmpty() || findStudent(id) != null) {
            System.out.println("Invalid or duplicate Student ID!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter Student Course: ");
        String course = sc.nextLine().trim();

        System.out.print("Enter Student Marks: ");

        double marks;
        try {
            marks = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid marks!");
            return;
        }

        if (name.isEmpty() || course.isEmpty()
                || marks < 0 || marks > 100) {
            System.out.println("Invalid student details or marks!");
            return;
        }

        // Save record in file
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
            BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(id + "|" + name + "|" + course + "|" + marks);
            bw.newLine();

            System.out.println("Student record added successfully!");

        } catch (IOException e) {
            System.out.println("Error saving student: " + e.getMessage());
        }
    }

    // Display all student records
    public static void readStudents() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No student records found!");
            return;
        }

        System.out.println("\n===== ALL STUDENT RECORDS =====");

        try (BufferedReader br = new BufferedReader(
                new FileReader(FILE_NAME))) {

            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|", -1);

                if (data.length == 4) {
                    displayRecord(data);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No student records found!");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Search for a student by ID
    public static void searchStudent(Scanner sc) {

        System.out.print("Enter Student ID to search: ");
        String id = sc.nextLine().trim();

        String[] data = findStudent(id);

        if (data == null) {
            System.out.println("Student record not found!");
        } else {
            System.out.println("\n===== STUDENT FOUND =====");
            displayRecord(data);
        }
    }

    // Find a student record in the file
    private static String[] findStudent(String id) {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return null;
        }

        try (BufferedReader br = new BufferedReader(
                new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|", -1);

                if (data.length == 4 && data[0].equals(id)) {
                    return data;
                }
            }

        } catch (IOException e) {
            System.out.println("Error searching file: " + e.getMessage());
        }

        return null;
    }

    // Update an existing student's details
    public static void updateStudent(Scanner sc) {

        System.out.print("Enter Student ID to update: ");
        String id = sc.nextLine().trim();

        String[] existing = findStudent(id);

        if (existing == null) {
            System.out.println("Student record not found!");
            return;
        }

        System.out.println("Current student details:");
        displayRecord(existing);

        System.out.print("Enter new Student Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter new Student Course: ");
        String course = sc.nextLine().trim();

        System.out.print("Enter new Student Marks: ");

        double marks;
        try {
            marks = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid marks!");
            return;
        }

        if (name.isEmpty() || course.isEmpty()
                || marks < 0 || marks > 100) {
            System.out.println("Invalid student details or marks!");
            return;
        }

        File originalFile = new File(FILE_NAME);
        File tempFile = new File("students_temp.txt");

        boolean updated = false;

        try (BufferedReader br = new BufferedReader(
                    new FileReader(originalFile));
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(tempFile))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split("\\|", -1);

                if (data.length == 4 && data[0].equals(id)) {
                    bw.write(id + "|" + name + "|" + course + "|" + marks);
                    updated = true;
                } else {
                    bw.write(line);
                }

                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error updating record: " + e.getMessage());
            tempFile.delete();
            return;
        }

        if (updated) {
            if (originalFile.delete() && tempFile.renameTo(originalFile)) {
                System.out.println("Student record updated successfully!");
            } else {
                System.out.println("Could not replace the original file.");
                System.out.println("Updated records are in students_temp.txt");
            }
        } else {
            tempFile.delete();
            System.out.println("Student record not found!");
        }
    }

    // Display one student record
    private static void displayRecord(String[] data) {

        System.out.println("--------------------------------");
        System.out.println("Student ID   : " + data[0]);
        System.out.println("Student Name : " + data[1]);
        System.out.println("Course       : " + data[2]);
        System.out.println("Marks        : " + data[3]);
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int choice = 0;

            do {
            System.out.println("\n================================");
            System.out.println("   STUDENT RECORD SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Student Record");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student Record");
            System.out.println("5. Exit");
            System.out.println("================================");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> addStudent(sc);

                case 2 -> readStudents();

                case 3 -> searchStudent(sc);

                case 4 -> updateStudent(sc);

                case 5 ->
                    System.out.println("Thank you for using Student Record System!");

                default ->
                    System.out.println("Invalid choice! Select 1-5.");
            }

        } while (choice != 5);

        sc.close();
        }
    }
}