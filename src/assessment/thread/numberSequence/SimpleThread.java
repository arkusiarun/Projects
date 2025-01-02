package assessment.thread.numberSequence;

public class SimpleThread implements Runnable {
    private String name;
    private int order;
    private static final Object lock = new Object();
    private static int currentOrder = 1;
    private static final int limit = 20;

    public SimpleThread(String name, int order) {
        this.name = name;
        this.order = order;
    }

    @Override
    public void run() {
        while (currentOrder <= limit) {
            synchronized (lock) {
                while (currentOrder % 3 != order && currentOrder <= limit) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (currentOrder <= limit) {
                    System.out.println("Thread Name: " + this.name + " - Number: " + currentOrder);
                    currentOrder++;
                    lock.notifyAll();
                }
            }
        }
    }
}