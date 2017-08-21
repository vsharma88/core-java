package com.vips.datastructure.linkedlist;

import java.util.Objects;

/**
 * @author Vipin Sharma
 * @category <blockquote>concepts</blockquote>
 *
 *  Basic Unit of any list dat structure
 *
 */

public class Node {
    private String data;
    private Node leftPtr;
    private Node rightPtr;

    public Node(Object data){
        this.data = String.valueOf(data);
        this.leftPtr = null;
        this.rightPtr = null;
    }

    public String getData() {
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
        return "Node{" +
                "data='" + data + '\'' +
                ", leftPtr=" + leftPtr +
                ", rightPtr=" + rightPtr +
                '}';
    }
}
