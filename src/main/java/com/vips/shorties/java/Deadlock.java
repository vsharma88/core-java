package com.vips.shorties.java;

import static java.lang.Thread.sleep;

public class Deadlock {

    private Object resourceA = new Object();
    private Object resourceB = new Object();


    public void createDeadlock(){

        Thread threadA = new Thread(() -> {
            try {
                synchronized (resourceA){
                    System.out.println("Acquired lock on resource A by Thread "+Thread.currentThread().getName());
                        sleep(1000);
                    synchronized (resourceB){
                     System.out.println("Acquired lock on resource B by Thread "+Thread.currentThread().getName());
                        sleep(10);
                    }
                }
            }catch (InterruptedException e) {
            e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                synchronized (resourceB){
                    System.out.println("Acquired lock on resource B by Thread "+Thread.currentThread().getName());
                    sleep(1000);
                    synchronized (resourceA){
                     System.out.println("Acquired lock on resource A by Thread "+Thread.currentThread().getName());
                        sleep(10);
                    }
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
    }

    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();
        deadlock.createDeadlock();
    }
}
