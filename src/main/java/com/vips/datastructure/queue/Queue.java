package com.vips.datastructure.queue;

import com.vips.datastructure.list.Node;

/**
 * @author Vipin Sharma
 * @category <blockquote></blockquote>
 * @DATE 5/9/17
 **/
public interface Queue<T extends Comparable<T>> {

    void enqueue(T data);

    T dequeue();

    T peek();

    Node<T> getHead();

    default void  traverseQueue(Node<T> node){
        while(node != null){
            System.out.print(" "+node.getData()+ " ");
            node = node.getLeft();
        }
    }
}
