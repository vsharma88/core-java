package com.vips.algorithm.sort.version01;

/**
 * @author Vipin Sharma
 * @category <blockquote></blockquote>
 * @DATE 27/8/17
 **/
public interface Algorithms {


    default void printArray(int[] array){
        for (int i = 0; i < array.length ; i++)
            System.out.print(String.valueOf(array[i])+ "  ");
    }

    default void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
