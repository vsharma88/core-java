package com.vips.datastructure.stack.version01;

/**
 * @author Vipin Sharma
 * @category <blockquote>concepts</blockquote>
 * @DATE 3/9/17
 *
 *   ADT(Abstract Data Type)
 **/
public interface Stack<T>{

     void push(T data);
     T pop();
     T peek();

}
