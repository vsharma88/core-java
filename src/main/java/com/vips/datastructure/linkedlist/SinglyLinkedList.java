package com.vips.datastructure.linkedlist;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Vipin Sharma
 * @category <blockquote>Concepts</blockquote>
 * @DATE 21/8/17
 *
 * Singly LinkedList ADT (Abstract Data Type) with the basic operations like :-
 *   1.)Insert at beginning,middle,last
 *   2.)Delete at beginning,middle,last
 *   3.)length
 *   4.)Traverse & print content of list
 *
 **/

public class SinglyLinkedList implements LinkedList {

    private Node head;
    private int length;

    public void insertNode(Object data,Position position, int location){
        Node newNode = new Node(data);
        if(head == null){
            this.head = newNode;
            this.length++;
            return;
        }

        Node curr = head;
       switch (position){
           case FIRST:
               newNode.setNext(head);
               this.length++;
               this.head = newNode;
               break;

           case OTHERS:
               if(location <= Integer.MIN_VALUE){
               }else{
                   while(curr.getNext() != null && --location > 0) {
                       curr = curr.getNext();
                   }
                   newNode.setNext(curr.getNext());
                   this.length++;
                   curr.setNext(newNode);
                   break;
               }

           case LAST:
               while(curr.getNext() != null){
                   curr = curr.getNext();
               }
               curr.setNext(newNode);
               this.length++;
               break;
           default:
       }
    }

    public void deleteNode(Position position, int location){
      Node curr = this.head;
      switch (position){
          case FIRST:
              head = curr.getNext();
              curr.setNext(null);
              this.length--;
              break;

          case OTHERS:
              if (location <= Integer.MIN_VALUE){
              }else{
                  Node prev = curr;
                  while(curr != null && location >0){
                      prev = curr;
                      curr = curr.getNext();
                      location--;
                  }
                 prev.setNext(curr.getNext());
                  this.length--;
                  break;
              }

          case LAST:
              Node prev = curr;
              while(curr.getNext() != null){
                  prev = curr;
                  curr = curr.getNext();
              }
              this.length--;
           prev.setNext(null);
      }
    }

    public int getLength(){
        return this.length;
    }

    public Node getHead(){
        return this.head;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        //adding to the list
        list.insertNode(LinkedList.generateRandonNumber(), Position.FIRST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandonNumber(), Position.FIRST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandonNumber(), Position.FIRST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandonNumber(), Position.LAST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandonNumber(), Position.LAST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandonNumber(), Position.LAST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandonNumber(),Position.OTHERS,2);
        list.insertNode(LinkedList.generateRandonNumber(),Position.OTHERS,4);
        list.insertNode(LinkedList.generateRandonNumber(),Position.OTHERS,Integer.MIN_VALUE);

        //traversing before deletion
        System.out.println("Before deletion :");
        list.traverseList(list.head);
        System.out.println(" length of list : "+list.getLength());

        //deleting from the list
        list.deleteNode(Position.FIRST,Integer.MIN_VALUE);
        list.deleteNode(Position.LAST, Integer.MIN_VALUE);
        list.deleteNode(Position.OTHERS,2);

        //traversing list after deletion
        System.out.println("After deletion :");
        list.traverseList(list.head);
        System.out.println(" length of list : "+list.getLength());
    }
}
