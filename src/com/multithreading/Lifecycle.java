package com.multithreading;

class Lifecycle extends Thread {
    public Lifecycle(String name){
        super(name);
    }
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        Lifecycle thread = new Lifecycle("Arshul's Thread");
        System.out.println("Thread state before start: " + thread.getState());
        thread.start();
        //System.out.println(thread.getState());
        System.out.println("Thread state after start: " + thread.getState());
        Thread.sleep(100); // Give some time for the thread to finish
        System.out.println("Thread state after completion: " + thread.getState());
        System.out.println("Main Thread: " + Thread.currentThread().getName());
        thread.join();//join se kya hoga - main thread tab tak wait karega jab tak ye thread apna kaam complete nahi kar leta
        //main thread ruk raha hai ki pehle t1 finish(terminate) hoga uske baad aage badhega
        System.out.println(thread.getState());
    }
}
