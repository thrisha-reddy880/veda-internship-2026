
public class Student {
    private String name;
    private int age;
    private String course;

    // Constructor 1: No arguments
    public Student() {
        name = "Unknown";
        age = 0;
        course = "Not Assigned";
    }

    // Constructor 2: Name only
    public Student(String name) {
        this.name = name;
        age = 0;
        course = "Not Assigned";
    }

    // Constructor 3: Name and age
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        course = "Not Assigned";
    }

    // Constructor 4: Name, age, and course
    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Display student details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {

        System.out.println("CONSTRUCTOR OVERLOADING DEMO");
        System.out.println("============================");

        Student student1 = new Student();
        Student student2 = new Student("Thrisha");
        Student student3 = new Student("Rahul", 20);
        Student student4 = new Student("Priya", 19, "Computer Science");

        System.out.println("\nStudent 1: Default Constructor");
        student1.displayDetails();

        System.out.println("Student 2: Name Constructor");
        student2.displayDetails();

        System.out.println("Student 3: Name and Age Constructor");
        student3.displayDetails();

        System.out.println("Student 4: Full Constructor");
        student4.displayDetails();
    }
}
