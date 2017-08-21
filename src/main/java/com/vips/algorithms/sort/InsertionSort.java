package com.vips.algorithms.sort;

import java.util.Arrays;

/**
 * @author Vsharma
 *
 * Insertion sort is a simple sorting algorithm that works the way we sort playing cards in our hands.
 *
 * Time Complexity - O(n2)
 * Space Complexity - O(1)
 *
 */
public class InsertionSort {

    public static void sort(int[] array){
        System.out.println("Before sorting - "+Arrays.toString(array));
        int temp;
        for(int i = 1; i < array.length ; i++){
            for(int j = 0; j < i-1 ; j ++){
                if(array[j] > array[i]){
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
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