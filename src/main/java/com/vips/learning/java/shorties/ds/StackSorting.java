package com.vips.learning.java.shorties.ds;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Vipin Sharma
 * @category <blockquote>interview question</blockquote>
 * @DATE 20/09/17
 **/

public class StackSorting {


    public static void sort(Stack<Integer> inputStack){
        Stack<Integer> tempStack = new Stack<>();

        while(!inputStack.isEmpty()){
            Integer tempElement = inputStack.pop();
            while(!tempStack.isEmpty() && tempStack.peek() < tempElement){
                inputStack.push(tempStack.pop());
            }
            tempStack.push(tempElement);
        }

        System.out.print("\nAfter Sorting : ");
        System.out.print(Arrays.toString(tempStack.toArray()));

    }

    public static void main(String[] args) {

        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(10);
        integerStack.push(30);
        integerStack.push(40);
        integerStack.push(20);
        integerStack.push(50);
        integerStack.push(90);
        integerStack.push(780);

        System.out.print("\nBefore sorting :");
        System.out.print(Arrays.toString(integerStack.toArray()));

        StackSorting.sort(integerStack);
    }
}
