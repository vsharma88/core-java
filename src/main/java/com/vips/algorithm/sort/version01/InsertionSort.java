package com.vips.algorithm.sort.version01;

/**
 * @author Vsharma
 *
 * Insertion sort is a simple sorting algorithm that works the way we sort playing cards in our hands.
 *
 *   - In place
 *   - Online Alogrithm (streaming data problems are slved with it)
 *   - Write intensive
 *   - Adaptive algorithm
 *
 * Time Complexity - O(n2)
 * Space Complexity - O(1)
 *
 */
public class InsertionSort implements Algorithms {

    public void sortArray(int[] array){
        System.out.println("\nBefore sorting : ");
        printArray(array);
        for(int i = 1; i < array.length; i++){
            for(int j = 0 ; j < i-1; j++){
                if(array[j] > array[i]){
                    swap(array,j,i);
                }
            }
        }
        System.out.println("\n\nAfter sorting : ");
        printArray(array);
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();

        int arr [] = {1,21,3,32,42,3,12};
        insertionSort.sortArray(arr);

    }

}