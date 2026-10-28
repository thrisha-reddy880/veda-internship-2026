import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;
public class FileSearchTool {
    static List<String> searchFile(Path file, String keyword)
            throws IOException {
        List<String> matches = new ArrayList<>();
        List<String> lines = Files.readAllLines(
                file, StandardCharsets.UTF_8);
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).toLowerCase()
                    .contains(keyword.toLowerCase())) {
                matches.add(file.getFileName()
                        + " | Line " + (i + 1)
                        + " | " + lines.get(i));
            }
        }
        return matches;
    }
    static List<String> sequentialSearch(
            List<Path> files, String keyword) throws Exception {
        List<String> results = new ArrayList<>();
        for (Path file : files) {
            results.addAll(searchFile(file, keyword));
        }
        return results;
    }
    static List<String> parallelSearch(
            List<Path> files, String keyword) throws Exception {
        int threadCount = Math.min(
                4, Math.max(1, files.size()));
        ExecutorService executor =
                Executors.newFixedThreadPool(threadCount);
        try {
            List<Callable<List<String>>> tasks =
                    new ArrayList<>();
            for (Path file : files) {
                tasks.add(() -> searchFile(file, keyword));
            }
            List<Future<List<String>>> futures =
                    executor.invokeAll(tasks);
            List<String> results = new ArrayList<>();
            for (Future<List<String>> future : futures) {
                results.addAll(future.get());
            }
            return results;
        } finally {
            executor.shutdown();
        }
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Multithreaded File Search Tool ===");
            System.out.print("Enter folder path (default: sample-files): ");
            String folderInput = scanner.nextLine().trim();
            if (folderInput.isEmpty()) {
                folderInput = "sample-files";
            }
            System.out.print("Enter keyword to search: ");
            String keyword = scanner.nextLine().trim();
            if (keyword.isEmpty()) {
                System.out.println("Error: Keyword cannot be empty.");
                return;
            }
            Path folder = Paths.get(folderInput);
            if (!Files.isDirectory(folder)) {
                System.out.println("Error: Folder does not exist.");
                return;
            }
            try (Stream<Path> stream = Files.walk(folder)) {
                List<Path> files = stream
                        .filter(Files::isRegularFile)
                        .filter(path -> {
                            try {
                                return Files.isReadable(path);
                            } catch (Exception e) {
                                return false;
                            }
                        })
                        .toList();
                if (files.isEmpty()) {
                    System.out.println("No files found in the folder.");
                    return;
                }
                System.out.println("\nFiles found: " + files.size());
                System.out.println("Keyword: " + keyword);
                long start = System.nanoTime();
                List<String> sequentialResults =
                        sequentialSearch(files, keyword);
                long sequentialTime = System.nanoTime() - start;
                start = System.nanoTime();
                List<String> parallelResults =
                        parallelSearch(files, keyword);
                long parallelTime = System.nanoTime() - start;
                System.out.println("\n--- Matching Lines ---");
                if (parallelResults.isEmpty()) {
                    System.out.println("No matching lines found.");
                } else {
                    for (String result : parallelResults) {
                        System.out.println(result);
                    }
                }
                System.out.println("\n--- Search Summary ---");
                System.out.println("Files searched: " + files.size());
                System.out.println(
                        "Matching lines: " + parallelResults.size());
                System.out.println("\n--- Execution Time ---");
                System.out.printf("Sequential: %.3f ms%n",
                        sequentialTime / 1_000_000.0);
                System.out.printf("Multithreaded: %.3f ms%n",
                        parallelTime / 1_000_000.0);
                System.out.println("\n--- Result Verification ---");
                System.out.println(
                        "Both methods returned the same results: "
                        + sequentialResults.equals(parallelResults));
            } catch (Exception e) {
                System.out.println("Error during search: "
                        + e.getMessage());
            }
        }
    }
}