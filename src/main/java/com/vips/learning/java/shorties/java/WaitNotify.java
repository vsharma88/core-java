package com.vips.learning.java.shorties.java;

public class WaitNotify {

    private final Object resource = new Object();

    public void usage(){
        Thread threadA = new Thread(()->{
           synchronized (resource){
               System.out.println("Acquired lock on resource by Thread : "+Thread.currentThread().getName());
               try {
                   resource.wait();
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
               System.out.println("Notified by thread, resuming now !!");
           }
        });

        Thread threadB = new Thread(()->{
            synchronized (resource){
                System.out.println("Acquired lock on resource by Thread : "+Thread.currentThread().getName());
                resource.notifyAll();
                System.out.println("Notifying to waiting thread !!");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        });

       threadA.start();
       threadB.start();
    }

    public static void main(String[] args) {
        WaitNotify waitNotify = new WaitNotify();
        waitNotify.usage();
    }

}
