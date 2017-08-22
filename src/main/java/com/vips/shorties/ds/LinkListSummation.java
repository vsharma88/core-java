package com.vips.shorties.ds;

import com.vips.datastructure.linkedlist.LinkedList;
import com.vips.datastructure.linkedlist.Node;
import com.vips.datastructure.linkedlist.SinglyLinkedList;

/**
 *	Given two numbers represented by two linked lists, write a function that returns sum list.
 *	The sum list is linked list representation of addition of two input numbers. It is not allowed
 *	to modify the lists. Numbers would be stored in reverse order
 *
 *			Example:
 *				Input : First List: 5->6->3  Second List: 4->2 //
 *				Output : 9->8->3
 *
 *
 */

public class LinkListSummation {


    public static void summation(SinglyLinkedList listA, SinglyLinkedList listB){

        int sum = 0;
        int carry = 0;
        SinglyLinkedList result = new SinglyLinkedList();
        int iteration = Math.min(listA.getLength(),listB.getLength());
        Node currA = listA.getHead();
        Node currB = listB.getHead();

        while(iteration-- > 0){
            sum = carry + (Integer.parseInt(currA != null ? currA.getData() : "0")) + (Integer.parseInt(currB != null ? currB.getData() : "0"));
            carry = 0;
            if(sum >=10){
                sum = sum % 10;
                carry = 1;
            }

            if(result.getHead() == null){
                result.setHead(new Node(sum));
            }else{
                Node temp = result.getHead();
                while(temp.getNext() != null){
                    temp = temp.getNext();
                }
                temp.setNext(new Node(sum));
            }

            currA = currA.getNext();
            currB = currB.getNext();
        }

        if(carry > 0){
            Node temp = result.getHead();
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(new Node(carry));
        }
        System.out.println("Summation result : ");
        listA.traverseList(result.getHead());
        System.out.println();
    }

    public static void main(String[] args) {

        SinglyLinkedList listA = new SinglyLinkedList();
        listA.insertNode(LinkedList.generateRandonNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);
        listA.insertNode(LinkedList.generateRandonNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);
        listA.insertNode(LinkedList.generateRandonNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);

        System.out.println("Number 01 : ");
        listA.traverseList(listA.getHead());
        System.out.println();

        SinglyLinkedList listB = new SinglyLinkedList();
        listB.insertNode(LinkedList.generateRandonNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);
        listB.insertNode(LinkedList.generateRandonNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);
        listB.insertNode(LinkedList.generateRandonNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);

        System.out.println("Number 02 : ");
        listA.traverseList(listB.getHead());
        System.out.println();

        summation(listA,listB);
    }
}