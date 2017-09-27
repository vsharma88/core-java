package com.vips.shorties.ds;

import com.vips.datastructure.list.LinkedList;
import com.vips.datastructure.list.Node;
import com.vips.datastructure.list.SinglyLinkedList;

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

    public static void rotateList(SinglyLinkedList list, int rotateBy){
        Node head = list.getHead();
        Node curr = list.getHead();

        while(--rotateBy > 0 && curr != null){
            curr = curr.getRight();
        }

        Node  lastNode = curr;
        while(lastNode.getRight() != null){
            lastNode = lastNode.getRight();
        }

        lastNode.setNext(head);

        list.setHead(curr.getRight());
        curr.setNext(null);

        System.out.println("After rotation :");
        LinkedList.traverseList(list.getHead());
        System.out.println(" length of list : "+list.getLength());
    }

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

        //traversing before deletion
        System.out.println("Before rotation :");
        LinkedList.traverseList(list.getHead());
        System.out.println(" length of list : "+list.getLength());

        rotateList(list,4);
    }
}
