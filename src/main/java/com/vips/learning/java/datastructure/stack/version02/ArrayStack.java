package com.vips.learning.java.datastructure.stack.version02;

import java.util.Arrays;

/**
 * Created by vipinsharma on 10/07/18.
 */
public class ArrayStack<T> implements Stack<T>{

    private T[] backingDataStructure;
    private int sizeOfStack;
    private int headOfStack =-1;

    public ArrayStack(int sizeOfStack) {
        this.sizeOfStack =  sizeOfStack;
        this.backingDataStructure = (T[])new Object[sizeOfStack];
    }

    @Override
    public void push(T t) {
        if(headOfStack == sizeOfStack){
            this.backingDataStructure = resizeStack(2*sizeOfStack);
        }
        backingDataStructure[++headOfStack] = t;
    }

    @Override
    public T peek() {
        if(headOfStack == -1){
            return null;
        }
        return backingDataStructure[headOfStack];
    }

    @Override
    public T pop() {
        if(headOfStack == -1){
            return null;
        }
        T poppedValue = backingDataStructure[headOfStack];
        backingDataStructure[headOfStack] = null;
        headOfStack--;
        return poppedValue;
    }

    private T[] resizeStack(int newSize){
         return Arrays.copyOf(this.backingDataStructure,newSize);
    }
}
