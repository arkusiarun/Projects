package practise.slidingWindowRateLimitter;

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        SlidingWindowRateLimiter rateLimiter = new SlidingWindowRateLimiter(5, 1000);
        for (int i = 0; i < 20; i++) {
            if (rateLimiter.allowRequest()) {
                System.out.println("Request " + (i + 1) + " allowed");
            } else {
                System.out.println("Request " + (i + 1) + " denied (rate limit exceeded)");
            }
            Thread.sleep(100);
        }
    }
}
