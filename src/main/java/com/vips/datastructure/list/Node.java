package com.vips.datastructure.list;

import java.util.Objects;

/**
 * @author Vipin Sharma
 * @category <blockquote>concepts</blockquote>
 *
 *  Basic unit of any linkedlist data structure
 *
 */

public class Node<T extends Comparable<T>>{
    private T data;
    private Node<T> leftPtr;
    private Node<T> rightPtr;

    public Node(T data){
        this.data = data;
        this.leftPtr = null;
        this.rightPtr = null;
    }

    public T getData() {
        return data;
    }

    public Node getNext(){
        return this.rightPtr;
    }

    public Node getPrevious(){
        return this.leftPtr;
    }

    public void setNext(Node next){
        this.rightPtr = next;
    }

    public void setPrevious(Node previous){
        this.leftPtr = previous;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(data, node.data) &&
                Objects.equals(leftPtr, node.leftPtr) &&
                Objects.equals(rightPtr, node.rightPtr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, leftPtr, rightPtr);
    }

    @Override
    public String toString() {
        return String.valueOf(this.getData());
    }
}
