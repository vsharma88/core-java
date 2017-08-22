package com.vips.shorties.ds;

import com.vips.datastructure.linkedlist.LinkedList;
import com.vips.datastructure.linkedlist.Node;
import com.vips.datastructure.linkedlist.SinglyLinkedList;

/**
 * @author Vipin Sharma
 * @category <blockquote>interview questions</blockquote>
 * @DATE 22/8/17
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come first, then all nodes with value equal to x
 * and finally nodes with value greater
 * than or equal to x. The original relative order of the
 * nodes in each of the three partitions should be preserved. The partition must work in-place.
 *  Ex: Input : 1->4->3->2->5->2->3,
 *              x = 3
 *      Output: 1->2->2->3->3->4->5
 *
 *
 **/
public class LinkedListPartition {


    public static void partitionList(int pivot, SinglyLinkedList list){
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node curr = list.getHead();

        while(curr != null){
            Node nextPtr = curr.getNext();
            curr.setNext(null);
            if(Integer.parseInt(curr.getData()) < pivot){
                if(beforeStart == null){
                    beforeStart = curr;
                    beforeEnd = beforeStart;
                }else{
                    beforeEnd.setNext(curr);
                    beforeEnd = curr;
                }
            }else{
                if(afterStart == null) {
                    afterStart = curr;
                    afterEnd = afterStart;
                }else{
                    if(Integer.parseInt(curr.getData()) == pivot){
                        curr.setNext(afterStart);
                        afterStart = curr;
                    }else{
                        afterEnd.setNext(curr);
                        afterEnd = curr;
                    }
                }
            }
            curr = nextPtr;
        }

        if(beforeStart == null){
            list.setHead(afterStart);
        }else{
            Node tempPtr = beforeStart;
            while(tempPtr.getNext() != null){
                tempPtr = tempPtr.getNext();
            }
            tempPtr.setNext(afterStart);
            list.setHead(beforeStart);
        }
        System.out.println("After partition with partition value as : "+pivot);
        list.traverseList(list.getHead());
        System.out.println(" length of list : "+list.getLength());
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertNode(LinkedList.generateRandonNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandonNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandonNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandonNumber(), LinkedList.Position.LAST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandonNumber(), LinkedList.Position.LAST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandonNumber(), LinkedList.Position.LAST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandonNumber(), LinkedList.Position.OTHERS,2);
        list.insertNode(LinkedList.generateRandonNumber(), LinkedList.Position.OTHERS,4);
        list.insertNode(LinkedList.generateRandonNumber(), LinkedList.Position.OTHERS,Integer.MIN_VALUE);

        System.out.println("Before partition :");
        list.traverseList(list.getHead());
        System.out.println(" length of list : "+list.getLength());

        partitionList(Integer.parseInt(list.getHead().getNext().getNext().getNext().getData()),list);

    }
}
