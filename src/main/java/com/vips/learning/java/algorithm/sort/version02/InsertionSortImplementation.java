package com.vips.learning.java.algorithm.sort.version02;

import java.util.Arrays;

/**
 * Created by vipinsharma on 06/06/18.
 *
 * Insertion sort is a simple sorting algorithm that works the way we sort playing cards in our hands.
 *
 *  - In place
 *   - Online Algorithm (streaming data problems are solved with it)
 *   - Write intensive
 *   - Adaptive algorithm
 *
 * Time Complexity - O(n2)
 * Space Complexity - O(1)
 *
 */
public class InsertionSortImplementation implements SortingAlgorithms {

    public static void main(String[] args) {
        SortingAlgorithms implementation = new InsertionSortImplementation();
        int[] arrayToSort = SortingAlgorithms.getArrayOfRandomIntegers(20);
        System.out.println("\nUnsorted array : "+ Arrays.toString(arrayToSort));
        implementation.sortArrayAscendingOrder(arrayToSort);
        System.out.println("Array sorted in ascending order using Insertion sort : "+Arrays.toString(arrayToSort));
        implementation.sortArrayDescendingOrder(arrayToSort);
        System.out.println("Array sorted in descending order using Insertion sort : "+Arrays.toString(arrayToSort));
    }

    @Override
    public  void sortArrayAscendingOrder(int[] arrayToSort){
        for(int indexOfFirstUnsortedElement = 1 ; indexOfFirstUnsortedElement < arrayToSort.length ; indexOfFirstUnsortedElement++){
            int elementToSwap = arrayToSort[indexOfFirstUnsortedElement];
            int swapIndex;
            for(swapIndex = indexOfFirstUnsortedElement; swapIndex > 0 && arrayToSort[swapIndex-1] > elementToSwap ; swapIndex --){
                arrayToSort[swapIndex] = arrayToSort[swapIndex-1];
            }
            arrayToSort[swapIndex] = elementToSwap;
        }
    }

    @Override
    public  void sortArrayDescendingOrder(int[] arrayToSort){
        for(int indexOfFirstUnsortedElement = 1 ; indexOfFirstUnsortedElement < arrayToSort.length ; indexOfFirstUnsortedElement++){
            int elementToSwap = arrayToSort[indexOfFirstUnsortedElement];
            int swapIndex;
            for(swapIndex = indexOfFirstUnsortedElement ; swapIndex > 0 && arrayToSort[swapIndex-1] < elementToSwap; swapIndex--){
                arrayToSort[swapIndex] = arrayToSort[swapIndex-1];
            }
            arrayToSort[swapIndex] = elementToSwap;
        }
    }
}
