package com.vips.datastructure.stack;

import com.vips.datastructure.list.LinkedList;
import com.vips.datastructure.list.Node;

/**
 * @author Vipin Sharma
 * @category <blockquote></blockquote>
 * @DATE 3/9/17
 **/
public class StackLinkedListImpl<T extends Comparable<T>> implements Stack<T>,LinkedList {

   private final static int MAX_LIMIT = 100;
   private Node<T> head;
   private int length;

    @Override
    public void push(T data) {
       if(this.length == MAX_LIMIT)
           System.out.println("Stack full");
       else {
           if(head == null){
               this.head = new Node<>(data);
           }else{
               Node newNode = new Node(data);
               newNode.setNext(this.head);
               this.head = newNode;
           }
           this.length++;
       }
    }

    @Override
    public T pop() {
        if(head == null){
            System.out.println("Stack is empty");
            return null;
        }else{
          this.length--;
          Node<T> result = this.head;
          this.head = result.getRight();
          result.setNext(null);
          return result.getData();
        }
    }

    @Override
    public T peek() {
        if(head == null){
            System.out.println("Stack is empty");
            return null;
        }else{
            return this.head.getData();
        }
    }

    public Node<T> getHead() {
        return head;
    }


    public static void main(String[] args) {
        StackLinkedListImpl<Integer> stack = new StackLinkedListImpl<>();

        stack.push(10);
        stack.push(30);
        stack.push(40);
        stack.push(320);
        stack.push(50);
        stack.push(60);

        System.out.println("\nStack content after push : ");
        LinkedList.traverseList(stack.getHead());


        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println("\n\nStack content after pop : ");
        LinkedList.traverseList(stack.getHead());

        System.out.println("\n\nPeeked item from stack is : "+stack.peek());
    }
}
