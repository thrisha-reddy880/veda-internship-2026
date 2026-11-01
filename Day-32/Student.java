import java.util.ArrayList;
public class Student {
    private final int id;
    private String name;
    private int age;
    private final ArrayList<Subject> subjects;
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.subjects = new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void addSubject(Subject subject) {
        subjects.add(subject);
    }
    public boolean removeSubject(String subjectName) {
        return subjects.removeIf(
            subject -> subject.getSubjectName()
                .equalsIgnoreCase(subjectName)
        );
    }
    public Subject findSubject(String subjectName) {
        for (Subject subject : subjects) {
            if (subject.getSubjectName()
                    .equalsIgnoreCase(subjectName)) {
                return subject;
            }
        }
        return null;
    }
    public void displayStudent() {
        System.out.println("----------------------------------------");
        System.out.println("Student ID   : " + id);
        System.out.println("Student Name : " + name);
        System.out.println("Age          : " + age);
        if (subjects.isEmpty()) {
            System.out.println("No subject records available.");
            return;
        }

        System.out.println("\nSubject Details:");
        System.out.printf("%-20s %s%n", "Subject", "Marks");
        System.out.println("----------------------------------------");

        for (Subject subject : subjects) {
            System.out.println(subject);
        }

        double total = Grade.calculateTotal(subjects);
        double maxTotal = Grade.calculateMaxTotal(subjects);
        double percentage = Grade.calculatePercentage(subjects);

        System.out.println("----------------------------------------");
        System.out.printf("Total Marks : %.2f / %.2f%n",
                total, maxTotal);
        System.out.printf("Percentage  : %.2f%%%n", percentage);
        System.out.println("Grade       : "
                + Grade.calculateGrade(percentage));
        System.out.println("----------------------------------------");
    }
}
