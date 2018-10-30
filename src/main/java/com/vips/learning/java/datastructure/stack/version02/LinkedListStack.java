package com.vips.learning.java.datastructure.stack.version02;

import java.util.LinkedList;

/**
 * Created by vipinsharma on 10/07/18.
 */
public class LinkedListStack<T> implements Stack<T> {

    private LinkedList<T> backingDataStructure;
    private int headOfStack = -1;

    public LinkedListStack() {
        this.backingDataStructure = new LinkedList<T>();
    }

    @Override
    public void push(T t) {
        this.backingDataStructure.add(t);
        this.headOfStack++;
    }

    @Override
    public T peek() {
        if(this.headOfStack == -1){
            System.out.println("Stack is empty !!");
            return null;
        }
        return this.backingDataStructure.get(headOfStack);
    }

    @Override
    public T pop() {
        if(this.headOfStack == -1){
            System.out.println("Stack is empty !!");
            return null;
        }
        T poppedValue = this.backingDataStructure.get(headOfStack--);
//        this.backingDataStructure.set(headOfStack,null);
//        headOfStack--;
        return poppedValue;
    }
}
