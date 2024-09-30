package practise.slidingWindowRateLimitter;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowRateLimiter {

    private final int maxRequests;
    private final long timeWindowMs;
    private final Queue<Long> requestTimestamps;

    public SlidingWindowRateLimiter(int maxRequests, long timeWindowMs) {
        this.maxRequests = maxRequests;
        this.timeWindowMs = timeWindowMs;
        this.requestTimestamps = new LinkedList<>();
    }

    public synchronized boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        while (!requestTimestamps.isEmpty() && (currentTime - requestTimestamps.peek()) > timeWindowMs) {
            requestTimestamps.poll();
        }

        if (requestTimestamps.size() < maxRequests) {
            requestTimestamps.add(currentTime);
            return true;
        } else {
            return false;
        }
    }
}
