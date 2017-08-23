package com.vips.shorties.ds;

import com.vips.datastructure.linkedlist.CircularLinkedList;
import com.vips.datastructure.linkedlist.LinkedList;
import com.vips.datastructure.linkedlist.Node;

/**
 * @author Vipin Sharma
 * @category <blockquote>interview question</blockquote>
 * @DATE 22/8/17
 *
 * The task is to choose the place in the initial circle so that you are the last one remaining and so survive.
 * For example, if n = 5 and k = 2, then the safe position is 3. Firstly, the person at position 2 is killed, then person at position 4 is killed,
 * then person at position 1 is killed. Finally, the person at position 5 is killed. So the person at position 3 survives.
 *
 **/
public class JosephusLinkedList {


    public static void getLastPosition(CircularLinkedList list, int k){
       Node curr = list.getHead();
        for(int count = list.getLength() ; count > 1 ; --count){
            for(int i = 0; i < k-1 ; ++i){
                curr = curr.getNext();
            }
           curr.setNext(curr.getNext().getNext());
        }
        System.out.println();
        System.out.println("The last node is : ");
        System.out.println(curr.getData());
    }

    public static void main(String[] args) {
        CircularLinkedList  list = new CircularLinkedList();

        list.insertNode(LinkedList.generateRandonNumber());
        list.insertNode(LinkedList.generateRandonNumber());
        list.insertNode(LinkedList.generateRandonNumber());
        list.insertNode(LinkedList.generateRandonNumber());
        list.insertNode(LinkedList.generateRandonNumber());
        list.insertNode(LinkedList.generateRandonNumber());

        System.out.println("Before operation : ");
        list.traverseList(list.getHead());
        getLastPosition(list,2);
    }
}
