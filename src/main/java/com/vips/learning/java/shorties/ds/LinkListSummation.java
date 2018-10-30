package com.vips.learning.java.shorties.ds;

import com.vips.learning.java.datastructure.list.LinkedList;
import com.vips.learning.java.datastructure.list.Node;
import com.vips.learning.java.datastructure.list.SinglyLinkedList;

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
            sum = carry + (Integer.parseInt(currA != null ? currA.getData().toString() : "0")) + (Integer.parseInt(currB != null ? currB.getData().toString() : "0"));
            carry = 0;
            if(sum >=10){
                sum = sum % 10;
                carry = 1;
            }

            if(result.getHead() == null){
                result.setHead(new Node(sum));
            }else{
                Node temp = result.getHead();
                while(temp.getRight() != null){
                    temp = temp.getRight();
                }
                temp.setNext(new Node(sum));
            }

            currA = currA.getRight();
            currB = currB.getRight();
        }

        if(carry > 0){
            Node temp = result.getHead();
            while(temp.getRight() != null){
                temp = temp.getRight();
            }
            temp.setNext(new Node(carry));
        }
        System.out.println("Summation result : ");
        LinkedList.traverseList(result.getHead());
        System.out.println();
    }

    public static void main(String[] args) {

        SinglyLinkedList listA = new SinglyLinkedList();
        listA.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);
        listA.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);
        listA.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);

        System.out.println("Number 01 : ");
        LinkedList.traverseList(listA.getHead());
        System.out.println();

        SinglyLinkedList listB = new SinglyLinkedList();
        listB.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);
        listB.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);
        listB.insertNode(LinkedList.generateRandomNumber(), LinkedList.Position.FIRST, Integer.MIN_VALUE);

        System.out.println("Number 02 : ");
        LinkedList.traverseList(listB.getHead());
        System.out.println();

//        summation(listA,listB);
        LinkedList.traverseList(summation(listA.getHead(), listB.getHead()));
    }

    public static Node summation(Node<Integer> firstNumber, Node<Integer> secondNumber)
    {
        if(firstNumber == null)
        {
            return secondNumber;
        }
        else if (secondNumber == null)
        {
            return firstNumber;
        }

        Node<Integer> head = new Node(0);
        Node<Integer> nodeA = head;
        int carry = 0;
        while(firstNumber != null && secondNumber != null)
        {
            int sum = (firstNumber.getData() + secondNumber.getData() + carry);
            carry = sum / 10;
            sum = sum % 10;

            nodeA.setNext(new Node(sum));
            firstNumber = firstNumber.getRight();
            secondNumber = secondNumber.getRight();
            nodeA = nodeA.getRight();
        }

        if(firstNumber != null)
        {
            if(carry != 0){
                nodeA.setNext(summation(firstNumber, new Node(carry)));
            }else {
                nodeA.setNext(firstNumber);
            }
        }
        else if(secondNumber != null)
        {
            if(carry != 0){
                nodeA.setNext(summation(secondNumber, new Node(carry)));
            }else {
                nodeA.setNext(secondNumber);
            }
        }
        else if(carry != 0)
        {
           nodeA.setNext(new Node(carry));
        }
        return head.getRight();
    }
}