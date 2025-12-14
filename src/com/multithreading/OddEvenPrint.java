package com.multithreading;

//////public class OddRunnable implements Runnable {
//////
//////    @Override
//////    public void run() {
//////        for (int i = 1; i <= 20; i += 2) {
//////            System.out.println("Odd: " + i + " | " + Thread.currentThread().getName());
//////        }
//////    }
//////
//////    public static void main(String[] args) {
//////        Thread t = new Thread(new OddRunnable());
//////        t.start();
//////    }
//////}
////
////
public class OddEvenPrint {

    private int counter = 1;
    private final int MAX = 20;

    public void printOdd() {
        synchronized (this) {
            while (counter <= MAX) {

                while (counter % 2 == 0) {
                    try { wait(); } catch (Exception e) {}
                }

                System.out.println("Odd : " + counter);
                counter++;
                notify();
            }
        }
    }

    public void printEven() {
        synchronized (this) {
            while (counter <= MAX) {

                while (counter % 2 != 0) {
                    try { wait(); } catch (Exception e) {}
                }

                System.out.println("Even: " + counter);
                counter++;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        OddEvenPrint obj = new OddEvenPrint();

        Thread odd = new Thread(() -> obj.printOdd());// Using lambda expression jo hum padhe thei ki anonymous class ka short form hai
        Thread even = new Thread(() -> obj.printEven());// lambda expression is used here in reference to Runnable interface

        odd.start();
        even.start();
    }
}



//public class OddEvenPrint {
//
//    private int counter = 1;      // Starting number
//    private final int MAX = 20;   // Limit
//
//    public void printOdd() {
//        synchronized (this) {
//            while (counter <= MAX) {
//
//                // Odd thread should wait if number is even
//                while (counter % 2 == 0) {
//                    try {
//                        wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                System.out.println("Odd  : " + counter);
//                counter++;
//
//                notify(); // Wake up even thread
//            }
//        }
//    }
//
//    public void printEven() {
//        synchronized (this) {
//            while (counter <= MAX) {
//
//                // Even thread should wait if number is odd
//                while (counter % 2 != 0) {
//                    try {
//                        wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                System.out.println("Even : " + counter);
//                counter++;
//
//                notify(); // Wake up odd thread
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//
//        OddEvenPrint obj = new OddEvenPrint();
//
//        // Thread for Odd numbers using Runnable (no lambda)
//        Thread odd = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                obj.printOdd();
//            }
//        });
//
//        // Thread for Even numbers using Runnable (no lambda)
//        Thread even = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                obj.printEven();
//            }
//        });
//
//        // Start both threads
//        odd.start();
//        even.start();
//    }
//}
