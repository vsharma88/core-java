package com.vips.datastructure.list;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Vipin Sharma
 * @category <blockquote></blockquote>
 * @DATE 21/8/17
 **/
public interface LinkedList {

    static  void traverseList(Node head){
        Node curr = head;
        System.out.print('[');
        while(curr != null){
            System.out.print(","+curr);
            if (curr.getNext() == head){
                break;
            }
            curr = curr.getNext();

        }
        System.out.print(']');
    }

    enum Position{FIRST,LAST,OTHERS}

    static int generateRandomNumber(){
        return ThreadLocalRandom.current().nextInt(1, 9 + 1);
    }
}
