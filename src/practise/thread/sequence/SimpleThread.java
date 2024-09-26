package practise.thread.sequence;

public class SimpleThread implements Runnable {
    private String name;
    private int order;
    private static final Object lock = new Object();
    private static int currentOrder = 1;

    public SimpleThread(String name, int order) {
        this.name = name;
        this.order = order;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (currentOrder != order) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread Name : " + this.name);
            currentOrder++;
            lock.notify();
        }
    }
}
