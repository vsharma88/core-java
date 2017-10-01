package com.vips.datastructure.queue;

import com.vips.datastructure.list.Node;

/**
 * @author Vipin Sharma
 * @category <blockquote>concepts</blockquote>
 * @DATE 28/09/17
 **/
public class CircularQueueImpl implements Queue<Integer> {

    private Node<Integer> head;
    private Node<Integer> tail;

    @Override
    public void enqueue(Integer data) {
        if(this.tail == null){
            this.tail = new Node<>(data);
            if(this.head == null)
                this.head = this.tail;
            return;
        }

        Node tempNode = new Node(data);
        this.tail.setNext(tempNode);
        this.tail = tempNode;
    }

    @Override
    public Integer dequeue() {
        if(this.head == null){
            System.out.println("Queue is empty !! ");
            return null;
        }

        this.head.setNext(this.head.getRight());
        Integer result = this.head.getData();
        return result;
    }

    @Override
    public Integer peek() {
        return null;
    }

    @Override
    public Node<Integer> getHead() {
        return null;
    }

    public static void main(String[] args) {
        Queue circularQueue = new CircularQueueImpl();
        circularQueue.enqueue(10);
        circularQueue.enqueue(30);
        circularQueue.enqueue(20);
        circularQueue.enqueue(80);
        circularQueue.enqueue(50);


    }
}
