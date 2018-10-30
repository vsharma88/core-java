package com.vips.learning.java.datastructure.queue;

import com.vips.learning.java.datastructure.list.LinkedList;
import com.vips.learning.java.datastructure.list.Node;

/**
 * @author Vipin Sharma
 * @category <blockquote></blockquote>
 * @DATE 5/9/17
 **/
public class QueueLinkedListImpl<T extends Comparable<T>> implements Queue<T>, LinkedList {

    private Node<T> head;
    private Node<T> tail;
    private int size;


    public boolean isEmpty(){
        return this.size == 0;
    }

    @Override
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);

        if(!isEmpty()){
            this.tail.setNext(newNode);
        }else{

        }
        newNode.setNext(null);
        this.tail = newNode;

        this.size++;
        if(this.head == null){
            this.head = this.tail;
        }

    }

    @Override
    public T dequeue() {

        if(isEmpty()){
            System.out.println("Queue empty !!");
            return null;
        }

        Node<T> result = this.head;
        if(result.getRight() == null){
            //do nothing
            this.head = this.tail;
        }else{
            this.head = this.head.getRight();
            result.setNext(null);
        }

        this.size--;
        return result.getData();
    }

    @Override
    public T peek() {
        return this.head.getData();
    }

    @Override
    public Node<T> getHead() {
        return head;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new QueueLinkedListImpl<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);

        System.out.println("\nQueue elements after push operation : ");
        LinkedList.traverseList(queue.getHead());


        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println("\n\nQueue elements after pop operation : ");
        LinkedList.traverseList(queue.getHead());

        System.out.println("\n\nPeeked element from queue is : "+queue.peek());
    }
}
