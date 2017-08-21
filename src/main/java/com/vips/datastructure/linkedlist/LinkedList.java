package com.vips.datastructure.linkedlist;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Vipin Sharma
 * @category <blockquote></blockquote>
 * @DATE 21/8/17
 **/
public interface LinkedList {


    default void traverseList(Node head){
        Node curr = head;
        System.out.print('[');
        while(curr != null){
            System.out.print(","+curr.getData());
            if (curr.getNext() == head){
                break;
            }
            curr = curr.getNext();

        }
        System.out.print(']');
    }

    enum Position{
        FIRST,LAST,OTHERS
    };


    static int generateRandonNumber(){
        return ThreadLocalRandom.current().nextInt(0, 5 + 1);
    }
}
