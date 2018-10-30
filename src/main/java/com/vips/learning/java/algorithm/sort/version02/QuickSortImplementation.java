package com.vips.learning.java.algorithm.sort.version02;

import java.util.Arrays;

/**
 * Created by vipinsharma on 08/06/18.
 */
public class QuickSortImplementation implements SortingAlgorithms {

    public static void main(String[] args) {
        SortingAlgorithms algorithms = new QuickSortImplementation();
        int[] arrayToSort = SortingAlgorithms.getArrayOfRandomIntegers(6);
        System.out.println(Arrays.toString(arrayToSort));
        algorithms.sortArrayAscendingOrder(arrayToSort);
        System.out.println(Arrays.toString(arrayToSort));
    }

    @Override
    public void sortArrayAscendingOrder(int[] arrayToSort) {
        quickSort(arrayToSort,0,arrayToSort.length);
    }

    public static void quickSort(int[] arrayToSort, int start, int end){
        if(end-start < 2)
            return;

        int pivotIndex = partition(arrayToSort,start,end);
        quickSort(arrayToSort,start,pivotIndex);
        quickSort(arrayToSort,pivotIndex+1,end);
    }

    public static int partition(int[] arrayToSort, int start , int end){
        int pivotElement = arrayToSort[start];
        int i = start;
        int j = end;
        while (i < j){

            while (i < j && arrayToSort[--j] > pivotElement);
            if(i < j){
                arrayToSort[i] = arrayToSort[j];
            }

            while (i < j && arrayToSort[++i] < pivotElement);
            if(i < j){
                arrayToSort[j] = arrayToSort[i];
            }
        }
        arrayToSort[j] = pivotElement;
        return i;
    }

    @Override
    public void sortArrayDescendingOrder(int[] arrayToSort) {

    }
}
