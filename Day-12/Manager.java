
public class Manager extends Employee {
    private int teamSize;

    public Manager(int id, String name, double salary, int teamSize) {
        super(id, name, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void work() {
        System.out.println(name + " manages a team of "
                + teamSize + " employees.");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Manager");
        System.out.println("Team Size: " + teamSize);
    }
}
