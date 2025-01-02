package assessment.thread.numberSequence;

public class Runner {

    public static void main(String[] args) {

        SimpleThread simpleThread1 = new SimpleThread("T1", 1);
        SimpleThread simpleThread2 = new SimpleThread("T2", 2);
        SimpleThread simpleThread3 = new SimpleThread("T3", 3);

        Thread t1 = new Thread(simpleThread1);
        Thread t2 = new Thread(simpleThread2);
        Thread t3 = new Thread(simpleThread3);

        t1.start();
        t2.start();
        t3.start();
    }
}
