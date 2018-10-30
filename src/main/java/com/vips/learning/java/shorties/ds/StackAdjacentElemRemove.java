package com.vips.learning.java.shorties.ds;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Vipin Sharma
 * @category <blockquote>interview question</blockquote>
 * @DATE 20/09/17
 **/
public class StackAdjacentElemRemove {


    public static void  removeDuplicates(Stack<Integer> inputStack){
        Stack<Integer> tempStack = new Stack<>();
        while(!inputStack.isEmpty()){
            Integer tempElement = inputStack.pop();
            if(!inputStack.isEmpty() && tempElement == inputStack.peek()){
                inputStack.pop();
                continue;
            }
            tempStack.push(tempElement);
        }
        System.out.print("After operation  : ");
        System.out.print(Arrays.toString(tempStack.toArray()));
    }

    public static void main(String[] args) {

        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(10);
        integerStack.push(30);
        integerStack.push(30);
        integerStack.push(40);
        integerStack.push(20);
        integerStack.push(20);
        integerStack.push(50);
        integerStack.push(50);
        integerStack.push(90);
        integerStack.push(90);

        System.out.print("Before operation : ");
        System.out.println(Arrays.toString(integerStack.toArray()));

        StackAdjacentElemRemove.removeDuplicates(integerStack);
    }
}
