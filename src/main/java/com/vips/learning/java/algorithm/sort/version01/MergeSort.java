package com.vips.learning.java.algorithm.sort.version01;

/**
 * @author Vipin Sharma
 * @category <blockquote>concepts</blockquote>
 * @DATE 7/9/17
 **/

public class MergeSort implements Algorithms {


    public int[] inputArray ;
    private int[] tempArray;

    public void sort( int[] array, int low, int high){

        if(low >= high) return;
        int middleIndex = (high+low)/2;
        sort(array,low,middleIndex);
        sort(array,middleIndex+1,high);
        merge(low,high,middleIndex,array);
    }

    private void merge(int low, int high, int middle, int[] array){

        for(int m = low; m <= high; m++){
            tempArray[m] = array[m];
        }

        int i = low;
        int k = low;
        int j = middle+1;

        while(i<= middle && j <= high){
            if(tempArray[i] <= tempArray[j]){
                array[k] = tempArray[i];
                i++;
            }else{
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }

        while (i <= middle){
            array[k] = tempArray[i];
            k++;i++;
        }

        while (j <= high){
            array[k] = tempArray[j];
            k++;j++;
        }
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int arr [] = {1,21,3,32,42,3,12};
        System.out.print("\n Before sorting : ");
        sort.printArray(arr);
        sort.inputArray = arr;
        sort.tempArray = new int[arr.length];
        sort.sort(sort.inputArray,0,arr.length-1);
        System.out.print("\n After sorting :  ");
        sort.printArray(sort.inputArray);

    }

}
