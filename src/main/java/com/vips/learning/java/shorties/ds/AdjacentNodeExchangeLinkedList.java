package com.vips.learning.java.shorties.ds;

import com.vips.learning.java.datastructure.list.LinkedList;
import com.vips.learning.java.datastructure.list.Node;
import com.vips.learning.java.datastructure.list.SinglyLinkedList;

/**
 * @author Vipin Sharma
 * @category <blockquote>interview question</blockquote>
 * @DATE 23/8/17
 *
 *   Given a singly linked list, write a function to swap elements pairwise. For example, if the linked list is 1->2->3->4->5->6->7 then
 *   the function should change it to 2->1->4->3->6->5->7, and if the linked list is 1->2->3->4->5->6 then
 *   the function should change it to 2->1->4->3->6->5
 *
 **/

public class AdjacentNodeExchangeLinkedList {

    public static Node swapNodes(Node head){
      if(head == null || head.getRight() == null)
          return head;
      else{
          Node next = head.getRight();
          head.setNext(next.getRight());
          next.setNext(head);
          head = next;

          head.getRight().setNext(swapNodes(head.getRight().getRight()));
          return head;
      }

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

        System.out.println("Before swap :");
        LinkedList.traverseList(list.getHead());
        System.out.println(" length of list : "+list.getLength());

        list.setHead(swapNodes(list.getHead()));
        System.out.println("After swap :");
        LinkedList.traverseList(list.getHead());

    }
}
