import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
public class LogFileAnalyzer {
    private static final String INPUT_FILE = "application.log";
    private static final String OUTPUT_FILE = "log_report.txt";
    private static final Pattern LOG_PATTERN = Pattern.compile(
        "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2} "
        + "(INFO|WARNING|ERROR) .+$"
    );
    public static void main(String[] args) {
        Map<String, Integer> logCounts = new HashMap<>();
        List<String> errors = new ArrayList<>();
        List<String> malformedLines = new ArrayList<>();
        logCounts.put("INFO", 0);
        logCounts.put("WARNING", 0);
        logCounts.put("ERROR", 0);
        int totalLines = 0;
        int validLines = 0;
        try (BufferedReader reader = new BufferedReader(
                new FileReader(INPUT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                totalLines++;
                if (!LOG_PATTERN.matcher(line).matches()) {
                    malformedLines.add(line);
                    System.out.println("Malformed log line: " + line);
                    continue;
                }
                validLines++;
                String[] parts = line.split("\\s+", 4);
                String level = parts[2];
                logCounts.put(level, logCounts.get(level) + 1);
                if (level.equals("ERROR")) {
                    errors.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Log file not found: " + INPUT_FILE);
            System.out.println("Please create application.log first.");
            return;
        } catch (IOException e) {
            System.out.println("Error reading log file: " + e.getMessage());
            return;
        }
        System.out.println("\n===== LOG ANALYSIS REPORT =====");
        System.out.println("Total Lines     : " + totalLines);
        System.out.println("Valid Log Lines : " + validLines);
        System.out.println("Malformed Lines : " + malformedLines.size());
        System.out.println("INFO Count      : " + logCounts.get("INFO"));
        System.out.println("WARNING Count   : " + logCounts.get("WARNING"));
        System.out.println("ERROR Count     : " + logCounts.get("ERROR"));
        System.out.println("\n===== ERROR SUMMARY =====");
        if (errors.isEmpty()) {
            System.out.println("No errors found.");
        } else {
            for (String error : errors) {
                System.out.println(error);
            }
        }
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(OUTPUT_FILE))) {
            writer.write("LOG FILE ANALYSIS REPORT");
            writer.newLine();
            writer.write("=========================");
            writer.newLine();
            writer.write("Total Lines: " + totalLines);
            writer.newLine();
            writer.write("Valid Log Lines: " + validLines);
            writer.newLine();
            writer.write("Malformed Lines: " + malformedLines.size());
            writer.newLine();
            writer.write("INFO Count: " + logCounts.get("INFO"));
            writer.newLine();
            writer.write("WARNING Count: " + logCounts.get("WARNING"));
            writer.newLine();
            writer.write("ERROR Count: " + logCounts.get("ERROR"));
            writer.newLine();
            writer.newLine();
            writer.write("ERROR DETAILS");
            writer.newLine();
            writer.write("-------------");
            writer.newLine();
            if (errors.isEmpty()) {
                writer.write("No errors found.");
                writer.newLine();
            } else {
                for (String error : errors) {
                    writer.write(error);
                    writer.newLine();
                }
            }
            writer.newLine();
            writer.write("MALFORMED LOG LINES");
            writer.newLine();
            writer.write("-------------------");
            writer.newLine();
            if (malformedLines.isEmpty()) {
                writer.write("No malformed lines found.");
                writer.newLine();
            } else {
                for (String malformed : malformedLines) {
                    writer.write(malformed);
                    writer.newLine();
                }
            }
            System.out.println("\nReport generated successfully: "
                    + OUTPUT_FILE);
        } catch (IOException e) {
            System.out.println("Error writing report: " + e.getMessage());
        }
    }
}