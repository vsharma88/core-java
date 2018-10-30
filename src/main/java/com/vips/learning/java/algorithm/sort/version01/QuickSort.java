package com.vips.learning.java.algorithm.sort.version01;

/**
 * @author Vipin Sharma
 * @category <blockquote>concepts</blockquote>
 * @DATE 7/9/17
 **/
public class QuickSort implements Algorithms {


    public void sort(int[] array, int low, int high){
        if(low >= high) return;
        int pivot = pivot(array,low,high);
        sort(array,low,pivot-1);
        sort(array,pivot+1,high);
    }

    private int pivot(int[] arr, int low, int high){
        int pivotIndex = (high + low)/2;
        swap(arr,high,pivotIndex);

        int i = low;
        for(int j = low; j < high ; j++){
            if(arr[j] <= arr[high]){
                swap(arr,i,j);
                i++;
            }
        }
        swap(arr,i,high);
        return i;
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();

        int arr [] = {1,21,3,32,42,3,12};
        System.out.print("\n Before sorting : ");
        sort.printArray(arr);
        sort.sort(arr,0,arr.length-1);
        System.out.print("\n After sorting :  ");
        sort.printArray(arr);
    }
}