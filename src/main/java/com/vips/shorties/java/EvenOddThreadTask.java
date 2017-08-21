package com.vips.shorties.java;

public class EvenOddThreadTask {

    public static void main(String[] args) {
        Object lock = new Object();
        Thread even = new Thread(new tasks(lock,0));
        even.setName("Even ");
        Thread odd = new Thread(new tasks(lock,1));
        odd.setName("Odd ");
        even.start();
        odd.start();
    }

}


class tasks implements Runnable {
    private Object lock;
    private int number;

    public tasks(Object lock, int number) {
        this.lock = lock;
        this.number = number;
    }


    public void run(){
        while(number<=10){
            synchronized (lock) {
                try {
                    lock.notify();
                    System.out.println(Thread.currentThread().getName()+" : "+number);
                    number+=2;
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}