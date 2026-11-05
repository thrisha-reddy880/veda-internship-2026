public class InternshipProgram extends Offering {
    private final int duration;
    public InternshipProgram(int id, String name, String category,
                            String description, int duration) {
        super(id, name, category, description);
        this.duration = duration;
    }
    @Override
    public void display() {
        System.out.println("Internship ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Category: " + getCategory());
        System.out.println("Description: " + getDescription());
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("--------------------------------");
    }
}