package com.vips.learning.java.algorithm.sort.version02;

import java.util.Arrays;

/**
 * Created by vipinsharma on 07/06/18.
 */
public class MergeSortImplementation implements SortingAlgorithms {


    public static void main(String[] args) {
       SortingAlgorithms algorithms = new MergeSortImplementation();
       int[] arrayToSort = SortingAlgorithms.getArrayOfRandomIntegers(6);
       algorithms.sortArrayAscendingOrder(arrayToSort);
        System.out.println(Arrays.toString(arrayToSort));
    }

    @Override
    public void sortArrayAscendingOrder(int[] arrayToSort) {
        splitPhase(arrayToSort,0,arrayToSort.length);
    }

    @Override
    public void sortArrayDescendingOrder(int[] arrayToSort) {

    }

    private static void splitPhase(int[] arrayToSort, int start, int end){
        if(end - start < 2)
            return;
        int mid = (end + start)/2;
        splitPhase(arrayToSort,start,mid);
        splitPhase(arrayToSort,mid,end);
        mergePhase(arrayToSort,start,mid,end);
    }

    private static void mergePhase(int[] arrayToSort, int start, int mid, int end){

        if(arrayToSort[mid-1] <= arrayToSort[mid])
            return;

        int[] tempArray = new int[end -start];
        int i = start;
        int j = mid;
        int tempIndex = 0;

        while(i < mid && j < end) {
            tempArray[tempIndex++] = arrayToSort[i] <= arrayToSort[j] ? arrayToSort[i++] : arrayToSort[j++];
        }
        System.arraycopy(arrayToSort,i,arrayToSort,i+tempIndex,mid-i);
        System.arraycopy(tempArray,0,arrayToSort,start,tempIndex);
    }

}
