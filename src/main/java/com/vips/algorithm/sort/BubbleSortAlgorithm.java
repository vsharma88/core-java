package com.vips.algorithm.sort;

import java.util.Arrays;

/**
 * Created by vipinsharma on 31/05/18
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
public class BubbleSortAlgorithm implements SortingAlgorithms{

    // This implementation sorts in ascending order
    public static void main(String[] args) {
        int [] arrayToSort = SortingAlgorithms.getArrayOfRandomIntegers(20);
        System.out.println("\nUnsorted array : "+Arrays.toString(arrayToSort));
        sortArrayAscendingOrder(arrayToSort);
        System.out.println("Array sorted in ascending order using Bubble sort : "+Arrays.toString(arrayToSort));
        sortArrayDescendingOrder(arrayToSort);
        System.out.println("Array sorted in descending order using Bubble sort : "+Arrays.toString(arrayToSort));
    }

    private static void sortArrayDescendingOrder(int[] arrayToSort){
        for(int pivotPoint = arrayToSort.length-1; pivotPoint > 0; pivotPoint--){
            for(int initialPosition = 0 ; initialPosition < pivotPoint ; initialPosition++ ){
                if(arrayToSort[initialPosition] < arrayToSort[initialPosition+1])
                    SortingAlgorithms.swapElements(arrayToSort,initialPosition,initialPosition+1);
            }
        }
    }

    private static void sortArrayAscendingOrder(int[] arrayToSort) {
        for(int pivotPoint = arrayToSort.length-1; pivotPoint > 0; pivotPoint--){
            for(int initialPosition = 0 ; initialPosition < pivotPoint ; initialPosition++ ){
                if(arrayToSort[initialPosition] > arrayToSort[initialPosition+1])
                    SortingAlgorithms.swapElements(arrayToSort,initialPosition,initialPosition+1);
            }
        }
    }
}
