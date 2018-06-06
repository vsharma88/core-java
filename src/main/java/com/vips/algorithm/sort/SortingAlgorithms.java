package com.vips.algorithm.sort;

import java.util.Random;

/**
 * Created by vipinsharma on 31/05/18.
 */
public interface SortingAlgorithms {

    static void swapElements(int[] array, int from, int to) {
        if (from == to)
            return;
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }

    static int[] getArrayOfRandomIntegers(int limit) {
        return new Random().ints(100,10000).limit(limit).toArray();
    }

     void sortArrayAscendingOrder(int[] arrayToSort);

     void sortArrayDescendingOrder(int[] arrayToSort);
}
