package com.synchronization;

public class Counter {
    private int count = 0;//private field

//    public void increment() {
//        count++;
//    }

    public synchronized void increment() {
        //synchronized(this) {} //synchronization block aise bhi likh sakte hai
        count++;
    }

    public int getCount() {//getter method to access private field
        return count;
    }
}
