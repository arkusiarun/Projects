package assessment.slidingWindowRateLimitter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class UserSlidingWindowRateLimiter {
    private final int maxRequests; // Maximum allowed requests per user
    private final long windowSizeInMillis; // Sliding window size in milliseconds
    private final ConcurrentHashMap<String, TreeMap<Long, Integer>> userRequestTimestamps; // User-specific timestamps
    private final ReentrantLock lock; // For thread safety during cleanup

    public UserSlidingWindowRateLimiter(int maxRequests, long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
        this.userRequestTimestamps = new ConcurrentHashMap<>();
        this.lock = new ReentrantLock();
    }

    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();

        // Ensure user-specific map exists
        userRequestTimestamps.putIfAbsent(userId, new TreeMap<>());

        TreeMap<Long, Integer> requestTimestamps = userRequestTimestamps.get(userId);

        lock.lock();
        try {
            // Remove timestamps outside the sliding window for the user
            cleanup(requestTimestamps, currentTime);

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

    private void cleanup(TreeMap<Long, Integer> requestTimestamps, long currentTime) {
        long windowStart = currentTime - windowSizeInMillis;
        requestTimestamps.keySet().removeIf(timestamp -> timestamp < windowStart);
    }

    public static void main(String[] args) {
        // Example: Allow 5 requests per 10 seconds for each user
        UserSlidingWindowRateLimiter rateLimiter = new UserSlidingWindowRateLimiter(5, 10000);

        // Simulate requests from different users
        Runnable user1Task = () -> {
            for (int i = 0; i < 10; i++) {
                boolean allowed = rateLimiter.allowRequest("User1");
                System.out.println(Thread.currentThread().getName() + " - User User1 - Request " + (i + 1) + " allowed: " + allowed);
                try {
                    Thread.sleep(500); // Simulate 2 requests per second
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable user2Task = () -> {
            for (int i = 0; i < 10; i++) {
                boolean allowed = rateLimiter.allowRequest("User2");
                System.out.println(Thread.currentThread().getName() + " - User User2 - Request " + (i + 1) + " allowed: " + allowed);
                try {
                    Thread.sleep(500); // Simulate 2 requests per second
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Start threads simulating different users
        Thread user1Thread = new Thread(user1Task, "Thread-User1");
        Thread user2Thread = new Thread(user2Task, "Thread-User2");

        user1Thread.start();
        user2Thread.start();

        try {
            user1Thread.join();
            user2Thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}