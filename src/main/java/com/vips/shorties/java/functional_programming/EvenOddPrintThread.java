package com.vips.shorties.java.functional_programming;

import com.vips.shorties.java.ObjectCreation;

/**
 * Created by vipinsharma on 30/05/18.
 */
public class EvenOddPrintThread {
    private static final Object lock = new Object();

    private static void printNumber(int seed) {
        try {
            synchronized (lock) {
                while (seed < 10) {
                    lock.notify();
                    System.out.println(seed);
                    seed = seed + 2;
                    lock.wait();
                }
            }
        }catch (InterruptedException e ){
            //do nothing
        }
    }

    // implemented using lambda
    public static void main(String[] args) throws InterruptedException {
        Thread evenThread = new Thread(() -> printNumber(0));
        Thread oddThread = new Thread(() -> printNumber(1));
        evenThread.start();
        oddThread.start();
    }
}
