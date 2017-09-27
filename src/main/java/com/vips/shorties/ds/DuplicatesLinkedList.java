package com.vips.shorties.ds;

import com.vips.datastructure.list.LinkedList;
import com.vips.datastructure.list.Node;
import com.vips.datastructure.list.SinglyLinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vipin Sharma
 * @category <blockquote>interview question</blockquote>
 * @DATE 21/8/17
 *
 * Singly linkedlist consists of duplicate elements, write an algorithm to
 * remove duplicates from the list in case any.
 *  Ex:   i\p : 2->3->1->5->2->8->1
 *        o\p : 2->3->1->5->8
 *
 **/

public class DuplicatesLinkedList {

    public static void removeDuplicates(SinglyLinkedList list){
        Map<String,Node> nodeMap =  new HashMap<>();
        int counter = 0;
        Node curr = list.getHead();

        while(curr != null){
            if(nodeMap.containsKey(curr.getData())){
                list.deleteNode(LinkedList.Position.OTHERS,counter);
            }else{
                //nodeMap.put(curr.getData(),curr);
                counter++;
            }
            curr = curr.getRight();
        }

        System.out.println("After removal :");
        LinkedList.traverseList(list.getHead());
        System.out.println(" length of list : "+list.getLength());
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

        System.out.println("Before removal :");
        LinkedList.traverseList(list.getHead());
        System.out.println(" length of list : "+list.getLength());

        DuplicatesLinkedList.removeDuplicates(list);
    }
}
