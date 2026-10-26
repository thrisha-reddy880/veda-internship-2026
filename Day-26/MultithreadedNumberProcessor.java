public class MultithreadedNumberProcessor {
    private static final int LIMIT = 1_000_000;
    private static final int THREAD_COUNT = 4;
    public static long singleThreadSum() {
        long sum = 0;
        for (int i = 1; i <= LIMIT; i++) {
            sum += (long) i * i;
        }
        return sum;
    }
    static class NumberWorker implements Runnable {
        private final int start;
        private final int end;
        private long result;
        public NumberWorker(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public void run() {
            long localSum = 0;
            for (int i = start; i <= end; i++) {
                localSum += (long) i * i;
            }
            result = localSum;
        }
        public long getResult() {
            return result;
        }
    }
    public static long multiThreadSum() throws InterruptedException {
        Thread[] threads = new Thread[THREAD_COUNT];
        NumberWorker[] workers = new NumberWorker[THREAD_COUNT];
        int chunkSize = LIMIT / THREAD_COUNT;
        for (int i = 0; i < THREAD_COUNT; i++) {
            int start = i * chunkSize + 1;
            int end = (i == THREAD_COUNT - 1)
                    ? LIMIT
                    : (i + 1) * chunkSize;
            workers[i] = new NumberWorker(start, end);
            threads[i] = new Thread(workers[i]);
            threads[i].start();
        }
        long total = 0;
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i].join();
            total += workers[i].getResult();
        }
        return total;
    }
    public static void main(String[] args) {
        try {
            System.out.println("======================================");
            System.out.println("  MULTITHREADED NUMBER PROCESSOR");
            System.out.println("======================================");
            System.out.println("Range       : 1 to " + LIMIT);
            System.out.println("Thread Count: " + THREAD_COUNT);
            long startSingle = System.nanoTime();
            long singleResult = singleThreadSum();
            long endSingle = System.nanoTime();
            double singleTime =
                    (endSingle - startSingle) / 1_000_000.0;
            long startMulti = System.nanoTime();
            long multiResult = multiThreadSum();
            long endMulti = System.nanoTime();
            double multiTime =
                    (endMulti - startMulti) / 1_000_000.0;
            System.out.println("\n===== RESULTS =====");
            System.out.println("Single-thread sum : " + singleResult);
            System.out.println("Multithreaded sum : " + multiResult);
            System.out.printf(
                    "Single-thread time: %.3f ms%n", singleTime);
            System.out.printf(
                    "Multithread time  : %.3f ms%n", multiTime);
            System.out.println("\n===== VERIFICATION =====");
            if (singleResult == multiResult) {
                System.out.println("SUCCESS: Both results match!");
            } else {
                System.out.println("ERROR: Results do not match!");
            }
            System.out.println("\nProcessing completed.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Processing was interrupted.");
        }
    }
}