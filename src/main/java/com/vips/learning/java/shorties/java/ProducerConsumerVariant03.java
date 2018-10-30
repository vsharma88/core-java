package com.vips.learning.java.shorties.java;

import java.util.concurrent.Semaphore;

public class ProducerConsumerVariant03 {

    private Semaphore semaphore = new Semaphore(1,true);


    public void consumer() throws InterruptedException {
        while(!semaphore.tryAcquire()){
            System.out.println(Thread.currentThread()+" - waiting for semaphore !!");
            Thread.sleep(500);
        }
        System.out.println(Thread.currentThread()+" - Acquired semaphore access !!");
        Thread.sleep(1000);
        semaphore.release();
    }

    public static void main(String[] args) {
        ProducerConsumerVariant03 variant03 = new ProducerConsumerVariant03();
        Thread thread01 = new Thread(() -> {
                try {
                    variant03.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        Thread thread02 = new Thread(() -> {
            try {
                variant03.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread01.start();
        thread02.start();
    }

}
