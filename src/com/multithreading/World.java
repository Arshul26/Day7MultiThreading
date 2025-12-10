package com.multithreading;

//public class World extends Thread{
//    @Override
//    public void run() {
//        for(; ;){
//            System.out.println("World Thread: " + Thread.currentThread().getName());
//        }
//    }
//}

public class World implements Runnable {
    @Override
    public void run() {
        for(; ;){
            System.out.println("World Thread: " + Thread.currentThread().getName());
        }
    }
}
