package com.vips.shorties.java;

public class NaturalNumberPrint {

    private int maxLimit;
    private final Object lock = new Object();

    public NaturalNumberPrint(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    public void printSeries(int num) throws InterruptedException {
        synchronized (lock){
            while (num <= maxLimit) {
                lock.notify();
                System.out.println("Printed by "+Thread.currentThread().getName()+" -" + num + " ");
                num = num + 2;
                lock.wait();
            }
        }
    }

    public static void main(String[] args) {
        NaturalNumberPrint numberPrint = new NaturalNumberPrint(20);

        Thread threadOdd = new Thread(() -> {
            try {
                numberPrint.printSeries(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        });
        threadOdd.setName("odd Thread ");

        Thread threadEven = new Thread(() -> {
            try {
                numberPrint.printSeries(0);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        });

        threadEven.setName("Even Thread");

        threadEven.start();
        threadOdd.start();
    }
}
