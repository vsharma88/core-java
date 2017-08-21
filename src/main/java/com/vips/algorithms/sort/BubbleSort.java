package com.vips.algorithms.sort;


import java.util.Arrays;

/**
 * @author Vsharma
 *
 * Sorting algorithm that works by repeatedly swapping
 * the adjacent elements if they are in wrong order.
 *
 * Time Complexity - O(n2)
 * Space Complexity - O(1)
 *
 */
public class BubbleSort {

    public static void sort(int[] array){
        System.out.println("Before sorting - "+ Arrays.toString(array));
        int temp;
        for(int j = array.length-1; j >0 ;j-- ){
            for(int i = 0 ; i < j ; i++){
                if(array[i]>array[i+1]){
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
        System.out.println("After sorting - "+Arrays.toString(array));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int arr [] = {1,21,3,32,42,3,12};
        sort(arr);
    }

}