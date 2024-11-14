package assessment.slidingWindowRateLimitter;


import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantLock;

public class UsingThreads {
    private final int maxRequests; // Maximum allowed requests
    private final long windowSizeInMillis; // Sliding window size in milliseconds
    private final TreeMap<Long, Integer> requestTimestamps; // Stores request counts per millisecond
    private final ReentrantLock lock; // For thread safety

    public UsingThreads(int maxRequests, long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
        this.requestTimestamps = new TreeMap<>();
        this.lock = new ReentrantLock();
    }

    public boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        lock.lock();
        try {
            // Remove timestamps outside the sliding window
            cleanup(currentTime);

            // Calculate total requests in the current window
            int totalRequests = requestTimestamps.values().stream().mapToInt(Integer::intValue).sum();

            if (totalRequests < maxRequests) {
                // Allow the request and record the timestamp
                requestTimestamps.put(currentTime, requestTimestamps.getOrDefault(currentTime, 0) + 1);
                return true;
            } else {
                // Reject the request
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    private void cleanup(long currentTime) {
        long windowStart = currentTime - windowSizeInMillis;
        requestTimestamps.keySet().removeIf(timestamp -> timestamp < windowStart);
    }

    public static void main(String[] args) {
        // Example: Allow 5 requests per 10 seconds
        SlidingWindowRateLimiter rateLimiter = new SlidingWindowRateLimiter(5, 10000);

        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                boolean allowed = rateLimiter.allowRequest();
                System.out.println(Thread.currentThread().getName() + " - Request " + (i + 1) + " allowed: " + allowed);
                try {
                    Thread.sleep(500); // Simulate 2 requests per second per thread
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Start multiple threads simulating concurrent requests
        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
