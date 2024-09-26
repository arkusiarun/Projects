package practise.thread.printoddeven;

public class PrintEvenOdd {
    static int count = 1;

    static int N = 10;

    private static final Object lock = new Object();

    public void printOddNumber() {
        synchronized (lock) {
            while (count < N) {
                while (count % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(count + " ");
                count++;
                lock.notify();
            }
        }
    }

    public void printEvenNumber() {
        synchronized (this) {
            while (count < N) {
                while (count % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(count + " ");
                count++;
                notify();
            }
        }
    }
}
