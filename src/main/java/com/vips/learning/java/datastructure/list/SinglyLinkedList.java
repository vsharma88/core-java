package com.vips.learning.java.datastructure.list;

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

public class SinglyLinkedList<T extends Comparable<T>> implements LinkedList {

    private Node head;
    private int length;

    public void insertNode(T data,Position position, int location){
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
                   while(curr.getRight() != null && --location > 0) {
                       curr = curr.getRight();
                   }
                   newNode.setNext(curr.getRight());
                   this.length++;
                   curr.setNext(newNode);
                   break;
               }

           case LAST:
               while(curr.getRight() != null){
                   curr = curr.getRight();
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
              head = curr.getRight();
              curr.setNext(null);
              this.length--;
              break;

          case OTHERS:
              if (location <= Integer.MIN_VALUE){
              }else{
                  Node prev = curr;
                  while(curr != null && location >0){
                      prev = curr;
                      curr = curr.getRight();
                      location--;
                  }
                 prev.setNext(curr.getRight());
                  this.length--;
                  break;
              }

          case LAST:
              Node prev = curr;
              while(curr.getRight() != null){
                  prev = curr;
                  curr = curr.getRight();
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

    public void setHead(Node head){ this.head = head;}


    public static Node reverseLinkedList(Node node){
        Node curr = node;
        Node prev = null;
        while(curr != null){
           Node next  = curr.getRight();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
       return prev;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        //adding to the list
        list.insertNode(LinkedList.generateRandomNumber(), Position.FIRST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), Position.FIRST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), Position.FIRST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), Position.LAST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), Position.LAST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(), Position.LAST, Integer.MIN_VALUE);
        list.insertNode(LinkedList.generateRandomNumber(),Position.OTHERS,2);
        list.insertNode(LinkedList.generateRandomNumber(),Position.OTHERS,4);
        list.insertNode(LinkedList.generateRandomNumber(),Position.OTHERS,Integer.MIN_VALUE);

        //traversing before deletion
        System.out.println("Before deletion :");
        LinkedList.traverseList(list.head);
        System.out.println(" length of list : "+list.getLength());

        //deleting from the list
        list.deleteNode(Position.FIRST,Integer.MIN_VALUE);
        list.deleteNode(Position.LAST, Integer.MIN_VALUE);
        list.deleteNode(Position.OTHERS,2);

        //traversing list after deletion
        System.out.println("After deletion :");
        LinkedList.traverseList(list.head);
        System.out.println(" length of list : "+list.getLength());


        System.out.println("After reversing list :");
        list.setHead(list.reverseLinkedList(list.head));
        LinkedList.traverseList(list.head);

    }
}
