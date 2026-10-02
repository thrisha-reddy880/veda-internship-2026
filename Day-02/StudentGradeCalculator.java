import java.util.Scanner;

public class StudentGradeCalculator {

    // Method to calculate total marks
    public static int calculateTotal(int[] marks) {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    // Method to calculate percentage
    public static double calculatePercentage(int total, int numberOfSubjects) {
        return (double) total / numberOfSubjects;
    }

    // Method to calculate grade
    public static String calculateGrade(double percentage) {

        if (percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else if (percentage >= 50) {
            return "E";
        } else {
            return "F";
        }
    }

    // Method to check whether marks are valid
    public static boolean isValidMark(int mark) {
        return mark >= 0 && mark <= 100;
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("====================================");
            System.out.println("      STUDENT GRADE CALCULATOR");
            System.out.println("====================================");

            // Get student name
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();

            // Get number of subjects
            int numberOfSubjects;

            while (true) {
                System.out.print("Enter number of subjects: ");

                if (scanner.hasNextInt()) {
                    numberOfSubjects = scanner.nextInt();

                    if (numberOfSubjects > 0) {
                        break;
                    } else {
                        System.out.println("Please enter at least 1 subject.");
                    }

                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                }
            }

            // Create array to store marks
            int[] marks = new int[numberOfSubjects];

            // Input marks
            for (int i = 0; i < numberOfSubjects; i++) {

                while (true) {

                    System.out.print("Enter marks for Subject " + (i + 1) + " (0-100): ");

                    if (scanner.hasNextInt()) {

                        int mark = scanner.nextInt();

                        if (isValidMark(mark)) {
                            marks[i] = mark;
                            break;
                        } else {
                            System.out.println(
                                    "Invalid marks! Marks must be between 0 and 100."
                            );
                        }

                    } else {
                        System.out.println("Invalid input! Please enter a number.");
                        scanner.next();
                    }
                }
            }

            // Calculate total
            int total = calculateTotal(marks);

            // Calculate percentage
            double percentage = calculatePercentage(total, numberOfSubjects);

            // Calculate grade
            String grade = calculateGrade(percentage);

            // Display result
            System.out.println();
            System.out.println("====================================");
            System.out.println("           STUDENT RESULT");
            System.out.println("====================================");

            System.out.println("Student Name : " + studentName);
            System.out.println("Subjects     : " + numberOfSubjects);
            System.out.println("------------------------------------");

            for (int i = 0; i < numberOfSubjects; i++) {
                System.out.println("Subject " + (i + 1) + "     : " + marks[i]);
            }

            System.out.println("------------------------------------");
            System.out.println("Total Marks  : " + total + "/" + (numberOfSubjects * 100));
            System.out.printf("Percentage   : %.2f%%\n", percentage);
            System.out.println("Grade        : " + grade);

            if (grade.equals("F")) {
                System.out.println("Status       : Needs Improvement");
            } else {
                System.out.println("Status       : Pass");
            }

            System.out.println("====================================");
        }
    }
}
