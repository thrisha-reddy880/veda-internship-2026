import java.util.List;
public class Grade {
    public static double calculateTotal(List<Subject> subjects) {
        double total = 0;
        for (Subject subject : subjects) {
            total += subject.getMarks();
        }
        return total;
    }
    public static double calculateMaxTotal(List<Subject> subjects) {
        double total = 0;
        for (Subject subject : subjects) {
            total += subject.getMaxMarks();
        }
        return total;
    }
    public static double calculatePercentage(List<Subject> subjects) {
        double maxTotal = calculateMaxTotal(subjects);
        if (maxTotal == 0) {
            return 0;
        }
        return (calculateTotal(subjects) / maxTotal) * 100;
    }
    public static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
