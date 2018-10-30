package com.vips.learning.java.shorties.ds;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Vipin Sharma
 * @category <blockquote>interview question</blockquote>
 * @DATE 21/09/17
 **/
public class ReverseStack {

    public static void reverseStack(Stack<Integer> input){
        if(input.isEmpty()) return;
        Integer tempElement = input.pop();
        reverseStack(input);
        pushItem(tempElement,input);
    }

    private static void pushItem(Integer tempElem, Stack<Integer> integerStack){
        if(integerStack.isEmpty()){
            integerStack.push( tempElem);
            return;
        }

        Integer popItem = integerStack.pop();
        pushItem(tempElem,integerStack);
        integerStack.push(popItem);
    }

    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(10);
        integerStack.push(30);
        integerStack.push(40);
        integerStack.push(20);
        integerStack.push(50);
        integerStack.push(90);

        System.out.print("\nBefore operation : ");
        System.out.print(Arrays.toString(integerStack.toArray()));

        ReverseStack.reverseStack(integerStack);

        System.out.print("\nAfter operation  : ");
        System.out.print(Arrays.toString(integerStack.toArray()));

    }
}
