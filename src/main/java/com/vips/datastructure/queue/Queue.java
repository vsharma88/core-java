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
}
