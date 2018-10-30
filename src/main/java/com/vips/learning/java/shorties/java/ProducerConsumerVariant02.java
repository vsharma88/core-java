package com.vips.learning.java.shorties.java;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerVariant02 {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void consumer() throws InterruptedException {
        lock.lock();
        System.out.println("In consumer thread !!");
        condition.await();
        System.out.println("Back in consumer thread !!");
        lock.unlock();
    }

    public void producer() throws InterruptedException {
        lock.lock();
        System.out.println("In producer thread !!");
        Thread.sleep(1000);
        condition.signalAll();
        lock.unlock();
    }

    public static void main(String[] args) {
        ProducerConsumerVariant02 variant02 = new ProducerConsumerVariant02();

        Thread thread01 = new Thread(()->{
            try {
                variant02.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread02 = new Thread(()->{
            try {
                variant02.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread01.start();
        thread02.start();
    }

}
