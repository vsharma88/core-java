package com.vips.shorties.java;

import java.util.Stack;

public class ProducerConsumerVariant01 {

    private static final int MAX_SIZE = 5;
    private static final int MIN_SIZE = 0;

    private Stack<Double> stack = new Stack<>();
    private final Object lock = new Object();

    public void consumer() throws InterruptedException{
        synchronized (lock){
            while(true){
                if(stack.size() == MIN_SIZE){
                    System.out.println("\n"+Thread.currentThread().getName()+" waiting !!!");
                    lock.wait();
                }else{
                    System.out.println("Removing element : "+stack.pop());
                    lock.notify();
                }
                Thread.sleep(1000);
            }
        }
    }

    public void producer() throws InterruptedException{
        synchronized (lock){
            while (true){
                if(stack.size() == MAX_SIZE){
                    System.out.println("\n"+Thread.currentThread().getName()+" waiting !!!");
                    lock.wait();
                }else{
                    Double number = Math.random();
                    System.out.println("Adding element : "+number);
                    stack.push(number);
                    lock.notify();
                }
                Thread.sleep(1000);
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumerVariant01 variant01 = new ProducerConsumerVariant01();

        Thread thread1 = new Thread(()->{
            try {
                variant01.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(()->{
            try {
                variant01.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.setName("Consumer Thread");
        thread2.setName("Producer Thread");

        thread1.start();
        thread2.start();
    }
}
