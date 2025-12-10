package com.multithreading;

public class test {
    public static void main(String[] args) {

        World w = new World();
        Thread t1 = new Thread(w);
        t1.start();
        //w.start();


        for(;;){
            System.out.println("Main Thread: " + Thread.currentThread().getName());
        }
//        for(int i=0; i<100000; i++){
//            System.out.println(Thread.currentThread().getName());
//        }
    }
}
