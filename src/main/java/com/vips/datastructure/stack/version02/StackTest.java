package com.vips.datastructure.stack.version02;

/**
 * Created by vipinsharma on 10/07/18.
 */
public class StackTest<T> {

    public static void main(String[] args) {
         ArrayStack<String> stringArrayStack = new ArrayStack<>(5);
         LinkedListStack<String> stringLinkedListStack = new LinkedListStack<>();

         stringArrayStack.push("bob");
         stringArrayStack.push("eminem");
         stringArrayStack.push("rihana");
         stringArrayStack.push("justin");
         stringArrayStack.push("michael");

        System.out.println(stringArrayStack.peek());
        System.out.println(stringArrayStack.pop());
        System.out.println(stringArrayStack.peek());

         stringLinkedListStack.push("amit");
         stringLinkedListStack.push("neha");
         stringLinkedListStack.push("badshah");
         stringLinkedListStack.push("raftar");
         stringLinkedListStack.push("honey");

        System.out.println(stringLinkedListStack.peek());
        System.out.println(stringLinkedListStack.pop());
        System.out.println(stringLinkedListStack.peek());


    }

}
