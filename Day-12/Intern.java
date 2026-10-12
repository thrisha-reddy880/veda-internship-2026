
public class Intern extends Employee {
    private String duration;

    public Intern(int id, String name, double salary, String duration) {
        super(id, name, salary);
        this.duration = duration;
    }

    public void work() {
        System.out.println(name + " is learning and assisting the team.");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Intern");
        System.out.println("Internship Duration: " + duration);
    }
}
