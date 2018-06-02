package com.vips.algorithm.sort;

import java.util.Arrays;

/**
 * Created by vipinsharma on 31/05/18.
 *
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
public class SelectionSortAlgorithm implements SortingAlgorithms{

    public static void main(String[] args) {
        int [] arrayToSort = SortingAlgorithms.getArrayOfRandomIntegers(20);
        System.out.println("\nUnsorted array : "+ Arrays.toString(arrayToSort));
        sortArrayAscendingOrder(arrayToSort);
        System.out.println("Array sorted in ascending order using Selection sort : "+Arrays.toString(arrayToSort));
        sortArrayDescendingOrder(arrayToSort);
        System.out.println("Array sorted in descending order using Selection sort : "+Arrays.toString(arrayToSort));
    }

    private static void sortArrayAscendingOrder(int[] arrayToSort) {
        for(int pivotPoint = arrayToSort.length-1 ; pivotPoint > 0; pivotPoint--){
            int largestElementAt = 0;
            for(int traversalPoint = 1 ; traversalPoint <= pivotPoint; traversalPoint++){
                if(arrayToSort[largestElementAt] < arrayToSort[traversalPoint]){
                    largestElementAt = traversalPoint;
                }
            }
            SortingAlgorithms.swapElements(arrayToSort,largestElementAt,pivotPoint);
        }
    }

    private static  void sortArrayDescendingOrder(int[] arrayToSort){
        for(int pivotPoint = arrayToSort.length-1 ; pivotPoint > 0; pivotPoint --){
            int smallestElementAt = 0;
            for(int traversalPoint = 1; traversalPoint <= pivotPoint ; traversalPoint++){
                if(arrayToSort[smallestElementAt] > arrayToSort[traversalPoint]){
                    smallestElementAt = traversalPoint;
                }
            }
            SortingAlgorithms.swapElements(arrayToSort,smallestElementAt,pivotPoint);
        }
    }
}
