package com.vips.algorithm.sort;

import com.vips.algorithm.Algorithms;

/**
 * @author Vipin Sharma
 * @category <blockquote>Concepts</blockquote>
 * @DATE 27/8/17
 *
 * An algorithm that works on the principle of generation all possible permutations
 * of the input until input is sorted.
 *
 * Time Complexity - O(n+1)!
 * Space Complexity - O(1)
 *
 * Note : This is very in-efficient algorithm in classical computing but in-case of quantum computing it
 * performs better.
 *
 **/
public class BogoSort implements Algorithms {

    public void shuffleArray(int[] array){
        for (int i = array.length-1; i >= 0 ; --i) {
            int random = (int)(Math.random() *i);
            swapElement(array,i,random);
        }

    }

    private void swapElement(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public boolean isSorted(int[] array){
        for (int i = 0; i < array.length ; i++) {
            if(array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BogoSort sort = new BogoSort();

       int[] unsortedArray = {12,3,1};
//        int[] unsortedArray = {-1,12,3,-5,8,9,100,65,34};
        System.out.println("Before Sorting array : ");
        sort.printArray(unsortedArray);

        int count = 0;
        while (!sort.isSorted(unsortedArray)){
            sort.shuffleArray(unsortedArray);
            count++;
        }

        System.out.println("Array sorted in counts : "+ count);
        sort.printArray(unsortedArray);
    }
}
