package com.synchronization;

public class Test{
    public static void main(String[] args) {
        Counter counter = new Counter();//both threads share the same counter object(resources)
        MyThread t1 = new MyThread(counter);//counter ka object diya hai constructor mein t1 ko usko increment krenge
        MyThread t2 = new MyThread(counter);
        t1.start();
        t2.start();
        try {
            t1.join();//main thread waits for t1 to finish
            t2.join();//main thread waits for t2 to finish
        } catch (InterruptedException e) {

        }

        System.out.println(counter.getCount());//expected 2000 but due to race condition it may be less than 2000
        //To overcome this we use synchronization
    }
}
