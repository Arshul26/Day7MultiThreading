package com.threaddemo;

class MyThread extends Thread {

    public MyThread(String name) {
        super(name); // Set thread name
    }

    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {

            // Showing the thread name
            System.out.println(getName() + " is running: " + i);

            // Example of yield()
            if(i == 2) {
                System.out.println(getName() + " is yielding...");
                Thread.yield();
            }

            // Sleep example
            try {
                Thread.sleep(500); // 0.5 sec
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted!");
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {

        // Create threads with names
        MyThread t1 = new MyThread("Worker-1");
        MyThread t2 = new MyThread("Worker-2");

        // Set priorities
        t1.setPriority(Thread.MAX_PRIORITY);  // 10
        t2.setPriority(Thread.MIN_PRIORITY);  // 1

        // Make t2 a daemon thread
        t2.setDaemon(true);

        // Start threads (creates new call stack)
        t1.start();
        t2.start();

        // join() – main thread waits for t1 to finish
        t1.join();
        System.out.println("Main thread waited for Worker-1 to finish.");

        // Interrupt t2 to stop it earlier
        t2.interrupt();

        System.out.println("Main thread finished.");
    }
}
