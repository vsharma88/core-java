package com.vips.shorties.ds;

import com.vips.datastructure.list.LinkedList;
import com.vips.datastructure.list.Node;
import com.vips.datastructure.list.SinglyLinkedList;

/**
 * @author Vipin Sharma
 * @category <blockquote>interview question</blockquote>
 * @DATE 23/8/17
 *
 *   Given a linked list, write a function to reverse every k nodes (where k is an input to the function).
 *
 *   i\p : 1->2->3->4->5->6->7->8->NULL and k = 3
 *   o\p : 3->2->1->6->5->4->8->7->NULL
 **/

public class BlockReversalLinkedList {


    public static Node reversal(Node head, int k){
        Node prev = null;
        Node curr = head;
        Node next = null;

        int i = 0;
        while( i < k && curr != null){
            next = curr.getRight();
            curr.setNext(prev);
            prev = curr;
            curr = next;
            i++;
        }

       if(next != null){
             head.setNext(reversal(next,k));
       }

       return prev;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.LAST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.LAST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.LAST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.OTHERS,2);
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.OTHERS,4);
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.OTHERS,Integer.MIN_VALUE);

        System.out.println("Before reversal :");
        LinkedList.traverseList(list.getHead());
        System.out.println(" length of list : "+list.getLength());

        list.setHead(reversal(list.getHead(),4));

        System.out.println("Before reversal :");
        LinkedList.traverseList(list.getHead());

    }
}
