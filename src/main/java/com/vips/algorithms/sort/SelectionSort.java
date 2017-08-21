package com.vips.algorithms.sort;

import java.util.Arrays;

/**
 * @author Vipin Sharma
 * The selection sort algorithm sorts an array
 *  by repeatedly finding the minimum element (considering ascending order) from
 *  unsorted part and putting it at the beginning
 *
 * Time Complexity -  O(n2)
 * Space Complexity - O(1)
 *
 */
public class SelectionSort {

    public static void sort(int[] array){
        System.out.println("Before sorting - "+Arrays.toString(array));
        int temp;
        for(int i = 0; i < array.length; i++){
            for (int j = i+1 ; j < array.length; j++){
                if(array[i]>array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j]=temp;
                }
            }
        }
        System.out.println("After sorting - "+Arrays.toString(array));
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int arr [] = {1,21,3,32,42,3,12};
        sort(arr);
    }

}