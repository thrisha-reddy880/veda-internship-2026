import java.util.concurrent.atomic.AtomicInteger;
public class ThreadSafeCounter {
    static int unsafeCounter = 0;
    static int safeCounter = 0;
    static AtomicInteger atomicCounter = new AtomicInteger(0);
    static final int THREADS = 5;
    static final int INCREMENTS = 100000;
    static void unsafeIncrement() {
        unsafeCounter++;
    }
    static synchronized void safeIncrement() {
        safeCounter++;
    }
    static void atomicIncrement() {
        atomicCounter.incrementAndGet();
    }
    public static void main(String[] args)
            throws InterruptedException {
        Thread[] threads = new Thread[THREADS];
        long start = System.nanoTime();
        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS; j++) {
                    unsafeIncrement();
                }
            });
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }
        long unsafeTime = System.nanoTime() - start;
        start = System.nanoTime();
        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS; j++) {
                    safeIncrement();
                }
            });
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }
        long safeTime = System.nanoTime() - start;
        start = System.nanoTime();
        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS; j++) {
                    atomicIncrement();
                }
            });
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }
        long atomicTime = System.nanoTime() - start;
        int expected = THREADS * INCREMENTS;
        System.out.println("=== Thread-Safe Counter Demo ===");
        System.out.println("Number of threads: " + THREADS);
        System.out.println("Increments per thread: " + INCREMENTS);
        System.out.println("Expected count: " + expected);
        System.out.println("\n--- Counter Results ---");
        System.out.println("Unsafe Counter: " + unsafeCounter);
        System.out.println("Synchronized Counter: " + safeCounter);
        System.out.println("AtomicInteger Counter: " + atomicCounter.get());
        System.out.println("\n--- Performance Comparison ---");
        System.out.printf("Unsafe: %.3f ms%n",
                unsafeTime / 1_000_000.0);
        System.out.printf("Synchronized: %.3f ms%n",
                safeTime / 1_000_000.0);
        System.out.printf("AtomicInteger: %.3f ms%n",
                atomicTime / 1_000_000.0);
    }
}