package com.vips.algorithm.sort;


import com.vips.algorithm.Algorithms;

/**
 * @author Vsharma
 *
 * Sorting algorithm that works by repeatedly swapping
 * the adjacent elements if they are in wrong order.
 *
 *   - Stable
 *   - In place sorting
 *
 * Time Complexity - O(n2)
 * Space Complexity - O(1)
 *
 */
public class BubbleSort implements Algorithms {

    public void sortArray(int[] array){
        System.out.println("Before sorting : ");
        printArray(array);
        for(int i = 0; i < array.length-1; i++){
            for(int j = 0; j < array.length-1-i; j++){
                if(array[j] > array[j+1]){
                    swap(array,j,j+1);
                }
            }
        }
        System.out.println("\nAfter sorting : ");
        printArray(array);
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int arr [] = {1,21,3,32,42,3,12};
        sort.sortArray(arr);
    }

}