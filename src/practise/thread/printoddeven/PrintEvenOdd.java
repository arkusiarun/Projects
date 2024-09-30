package practise.thread.printoddeven;

public class PrintEvenOdd {
    static int counter = 1;

    static int limit = 10;

    static final Object lock = new Object();

    public void printOddNum() {
        synchronized (lock) {
            while (counter <= limit) {
                if (counter % 2 == 1) {
                    System.out.println(counter);
                    counter++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void printEvenNum() {
        synchronized (lock) {
            while (counter <= limit) {
                if (counter % 2 == 0) {
                    System.out.println(counter);
                    counter++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
