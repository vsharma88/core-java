package com.vips.learning.java.shorties.ds;

import com.vips.learning.java.datastructure.list.LinkedList;
import com.vips.learning.java.datastructure.list.Node;
import com.vips.learning.java.datastructure.list.SinglyLinkedList;

/**
 * @author Vipin Sharma
 * @category <blockquote></blockquote>
 * @DATE 22/8/17
 *
 *  You are given a singly linked list, rotate the linked list counter-clockwise by k nodes. Where k is a given positive integer.
 *  i.e. if the given linked list is: 1->2->3->4->5 and k is 3,
 *  the list should be modified to: 4->5->1->2->3.
 *  Assume that k is smaller than the number of nodes in linked list
 *
 * Steps:
 *  1) Traverse the list by k nodes.
 *  2) Keep kth node in temp.
 *  3) Travese till end of list and set last node pointer to start.
 *  4) Set kth nodes next to head.
 *  5) Point kth node next to NULL.
 *
 **/
public class LinkedListRotation {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        //adding to the list
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.LAST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.LAST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.LAST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.LAST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.LAST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.LAST, Integer.MIN_VALUE);

        rotateItV2(list.getHead(),4,list.getLength());
    }

    public static void rotateItV2(Node<Integer> headNode, int rotateBy, int length)
    {
        System.out.print("\nRotating linked-list by : "+rotateBy);
        System.out.print("\nBefore rotation :");
        LinkedList.traverseList(headNode);

        Node<Integer> currNode = headNode;
        int escapeRouteLength = length - 1 - rotateBy;
        while (currNode.getRight() != null && escapeRouteLength-- > 0) {
            currNode = currNode.getRight();
        }

        Node tail = currNode;
        Node head2 = currNode.getRight();
        while (currNode.getRight() != null) {
            currNode = currNode.getRight();
        }

        currNode.setNext(headNode);
        tail.setNext(null);
        headNode = head2;

        System.out.print("\nAfter rotation : ");
        LinkedList.traverseList(headNode);
    }
}
