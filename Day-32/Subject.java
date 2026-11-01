public class Subject {
    private final String subjectName;
    private double marks;
    private final double maxMarks;
    public Subject(String subjectName, double marks, double maxMarks) {
        this.subjectName = subjectName;
        this.marks = marks;
        this.maxMarks = maxMarks;
    }
    public String getSubjectName() {
        return subjectName;
    }
    public double getMarks() {
        return marks;
    }
    public double getMaxMarks() {
        return maxMarks;
    }
    public void setMarks(double marks) {
        this.marks = marks;
    }
    @Override
    public String toString() {
        return String.format(
            "%-20s %.2f / %.2f",
            subjectName, marks, maxMarks
        );
    }
}
