package com.vips.shorties.ds;

import com.vips.datastructure.linkedlist.LinkedList;
import com.vips.datastructure.linkedlist.Node;
import com.vips.datastructure.linkedlist.SinglyLinkedList;

/**
 * @author Vipin Sharma
 * @category <blockquote>interview question</blockquote>
 * @DATE 23/8/17
 *
 *  Given a singly linked list of characters, write a function that returns
 *  true if the given list is palindrome, else false
 *
 **/

public class PalindromeLinkedList {


    public static boolean isPalindrome(Node head){
        Node slow_ptr = head;
        Node fast_ptr = slow_ptr;
        Node node_1 = head;
        Node node_2 = null;


        while(fast_ptr != null && fast_ptr.getNext() != null){
            slow_ptr = slow_ptr.getNext();
            fast_ptr = fast_ptr.getNext().getNext();
        }

        node_2 = SinglyLinkedList.reverseLinkedList(slow_ptr.getNext());

        while(node_2 != null){
            if(!node_1.getData().equalsIgnoreCase(node_2.getData()))
                return false;

          node_1 = node_1.getNext();
          node_2 = node_2.getNext();
        }


        return true;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertNode('M', LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list.insertNode('A', LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list.insertNode('L', LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list.insertNode('A', LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list.insertNode('Y', LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list.insertNode('A', LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list.insertNode('L', LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list.insertNode('A', LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list.insertNode('M', LinkedList.Position.FIRST, Integer.MIN_VALUE);


        System.out.println("linked list is :");
        list.traverseList(list.getHead());
        System.out.println(" length of list : "+list.getLength());
        System.out.println("List is palindrome ? : "+isPalindrome(list.getHead()));



        SinglyLinkedList list1 = new SinglyLinkedList();

        list1.insertNode('M', LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list1.insertNode('A', LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list1.insertNode('A', LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list1.insertNode('M', LinkedList.Position.FIRST, Integer.MIN_VALUE);


        System.out.println("linked list is :");
        list1.traverseList(list1.getHead());
        System.out.println(" length of list : "+list1.getLength());
        System.out.println("List is palindrome ? : "+isPalindrome(list1.getHead()));

    }
}
