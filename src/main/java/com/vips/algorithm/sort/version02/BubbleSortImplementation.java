package com.vips.algorithm.sort.version02;

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
public class BubbleSortImplementation implements SortingAlgorithms {

    public static void main(String[] args) {
        SortingAlgorithms implementation = new BubbleSortImplementation();
        int [] arrayToSort = SortingAlgorithms.getArrayOfRandomIntegers(20);
        System.out.println("\nUnsorted array : "+Arrays.toString(arrayToSort));
        implementation.sortArrayAscendingOrder(arrayToSort);
        System.out.println("Array sorted in ascending order using Bubble sort : "+Arrays.toString(arrayToSort));
        implementation.sortArrayDescendingOrder(arrayToSort);
        System.out.println("Array sorted in descending order using Bubble sort : "+Arrays.toString(arrayToSort));
    }

    @Override
    public  void sortArrayDescendingOrder(int[] arrayToSort){
        for(int pivotPoint = arrayToSort.length-1; pivotPoint > 0; pivotPoint--){
            for(int initialPosition = 0 ; initialPosition < pivotPoint ; initialPosition++ ){
                if(arrayToSort[initialPosition] < arrayToSort[initialPosition+1])
                    SortingAlgorithms.swapElements(arrayToSort,initialPosition,initialPosition+1);
            }
        }
    }

    @Override
    public void sortArrayAscendingOrder(int[] arrayToSort) {
        for(int pivotPoint = arrayToSort.length-1; pivotPoint > 0; pivotPoint--){
            for(int initialPosition = 0 ; initialPosition < pivotPoint ; initialPosition++ ){
                if(arrayToSort[initialPosition] > arrayToSort[initialPosition+1])
                    SortingAlgorithms.swapElements(arrayToSort,initialPosition,initialPosition+1);
            }
        }
    }
}
