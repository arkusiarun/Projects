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
        while (true) {
            synchronized (lock) {
                int seq = (currentOrder % 3 == 0) ? 3 : currentOrder % 3;
                if (seq != order) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                } else if (currentOrder > limit) {
                    lock.notifyAll();
                    break;
                } else {
                    System.out.println("Thread Name: " + name + " - Number: " + currentOrder);
                    currentOrder++;
                    lock.notifyAll();
                }
            }
        }
    }
}