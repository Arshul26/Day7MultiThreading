package com.synchronization;

public class MyThread extends Thread {

    private Counter counter;//Counter reference aur usko set krwayenge with the help of constructor

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
