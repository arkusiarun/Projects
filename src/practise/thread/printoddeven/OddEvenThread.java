package practise.thread.printoddeven;

public class OddEvenThread {
    static void run() {
        PrintEvenOdd printEvenOdd = new PrintEvenOdd();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                printEvenOdd.printOddNumber();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                printEvenOdd.printEvenNumber();
            }
        });

        t1.start();
        t2.start();
    }
}