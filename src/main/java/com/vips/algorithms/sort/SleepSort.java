package com.vips.algorithms.sort;


import java.util.concurrent.CountDownLatch;

/**
 * @author Vipin Sharma
 * @category <blockquote>Concepts</blockquote>
 * @DATE 29/8/17
 *
 * An algorithm that works on the principle of assigning  all possible values(number type only) to a thread
 * and sleep in accordance to a number assigned.
 *
 * Time Complexity - very inefficient
 * Space Complexity - very inefficient
 *
 *
 **/

public class SleepSort implements Algorithms {


    public void sortArray(int[] array){
        CountDownLatch latch = new CountDownLatch(array.length);

        for (Integer integer: array) {
            new Thread(() -> {
                latch.countDown();
                try {
                    latch.await();
                    Thread.sleep(integer*100);
                    System.out.print(integer+"  ");
                }catch (InterruptedException e){
                    //do nothing
                }

            }).start();

        }

    }

    public static void main(String[] args) {
        SleepSort sort = new SleepSort();
        int[] unsortedArray = {1,12,3,5,8,9,100,65,34};
        System.out.println("Before Sorting array : ");
        sort.printArray(unsortedArray);

        System.out.println();
        System.out.println("After sort : ");
        sort.sortArray(unsortedArray);

    }

}
