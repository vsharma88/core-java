package com.vips.shorties.ds;

import com.vips.datastructure.list.LinkedList;
import com.vips.datastructure.list.Node;
import com.vips.datastructure.list.SinglyLinkedList;

/**
 * @author Vipin Sharma
 * @category <blockquote>interview question</blockquote>
 * @DATE 22/8/17
 *
 *  Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln.
 *  Rearrange the nodes in the list so that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2
 *
 **/
public class AltReorderLinkedList {


    public static void reorderLinkedList(SinglyLinkedList list){
        Node result = new Node(Integer.MAX_VALUE);
        Node curr1 = list.getHead();
        Node slow_ptr = curr1;
        Node fast_ptr = slow_ptr.getNext();

        while(fast_ptr != null && fast_ptr.getNext() != null){
            slow_ptr = slow_ptr.getNext();
            fast_ptr = fast_ptr.getNext().getNext();
        }

        Node curr2 = slow_ptr.getNext();
        slow_ptr.setNext(null);
        curr2 = list.reverseLinkedList(curr2);

        while(curr1 != null || curr2 != null){

            if(curr1 != null){
                result.setNext(curr1);
                result = result.getNext();
                curr1 = curr1.getNext();
            }

            if(curr2 != null){
                result.setNext(curr2);
                result = result.getNext();
                curr2 = curr2.getNext();
            }
        }

        System.out.println("After reordering :");
        list.traverseList(list.getHead());
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        //adding to the list
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.LAST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.LAST, Integer.MIN_VALUE);


        //traversing before deletion
        System.out.println("Before re ordering :");
        list.traverseList(list.getHead());

        reorderLinkedList(list);
    }
}
