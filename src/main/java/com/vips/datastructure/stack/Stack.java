package com.vips.datastructure.stack;

import com.vips.datastructure.list.Node;

/**
 * @author Vipin Sharma
 * @category <blockquote>concepts</blockquote>
 * @DATE 3/9/17
 *
 *   ADT(Abstract Data Type)
 **/
public interface Stack<T extends Comparable<T>>{

     void push(T data);
     T pop();
     T peek();
     Node<T> getHead();
}
