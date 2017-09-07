package com.vips.algorithm.sort;

import com.vips.algorithm.Algorithms;

/**
 * @author Vipin Sharma
 * The selection sort algorithm sorts an array
 *  by repeatedly finding the minimum element (considering ascending order) from
 *  unsorted part and putting it at the beginning
 *
 *    - In place
 *    - Not stable
 *
 * Time Complexity -  O(n2)
 * Space Complexity - O(1)
 *
 */
public class SelectionSort implements Algorithms {

    public void sort(int[] array){
        System.out.println("Before sorting - ");
        printArray(array);
        for(int i = 0; i < array.length ; i++){
            for (int j = i+1 ; j < array.length; j++){
                if(array[i]>array[j]){
                 swap(array, i, j);
                }
            }
        }
        System.out.println("\nAfter sorting - ");
        printArray(array);
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();

        int arr [] = {1,21,3,32,42,3,12};
        selectionSort.sort(arr);
    }

}