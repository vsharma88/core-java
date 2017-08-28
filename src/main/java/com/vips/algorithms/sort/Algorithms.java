package com.vips.algorithms.sort;

/**
 * @author Vipin Sharma
 * @category <blockquote></blockquote>
 * @DATE 27/8/17
 **/
public interface Algorithms {


    default void printArray(Object[] array){
        for (int i = 0; i < array.length ; i++)
            System.out.print(String.valueOf(array[i])+ "  ");
    }

}
