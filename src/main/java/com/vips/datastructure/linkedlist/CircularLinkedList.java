package com.vips.datastructure.linkedlist;

/**
 * @author Vipin Sharma
 * @category <blockquote>Concepts</blockquote>
 * @DATE 21/8/17
 *
 * Circular LinkedList ADT (Abstract Data Type) with the basic operations like :-
 *   1.)Insert
 *   2.)Delete
 *   3.)length
 *   4.)Traverse & print content of list
 *
 **/
public class CircularLinkedList implements LinkedList {

    private Node head;
    private int length;

    public void insertNode(Object data){
        Node newNode = new Node(data);
        if(this.head == null){
          this.head = newNode;
          this.length++;
          return;
         }

      Node curr = this.head;
      while (curr.getNext() != null && curr.getNext() != this.head){
          curr = curr.getNext();
      }

      curr.setNext(newNode);
      newNode.setNext(this.head);
      this.length++;
    }

    public void deleteNode(){
        if(this.head == null)
            return;

        Node curr = this.head;
        Node prev = curr;
        while (curr.getNext() != this.head){
            prev = curr;
            curr = curr.getNext();
        }

        prev.setNext(this.head);
        curr.setNext(null);
        this.length--;
    }

    public int getLength(){
        return this.length;
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        //add node to the list
        list.insertNode(LinkedList.generateRandonNumber());
        list.insertNode(LinkedList.generateRandonNumber());
        list.insertNode(LinkedList.generateRandonNumber());
        list.insertNode(LinkedList.generateRandonNumber());
        list.insertNode(LinkedList.generateRandonNumber());
        list.insertNode(LinkedList.generateRandonNumber());

        //traversing before deletion
        System.out.println("Before deletion :");
        list.traverseList(list.head);
        System.out.println(" length of list : "+list.getLength());

        list.deleteNode();
        list.deleteNode();
        list.deleteNode();

        //traversing list after deletion
        System.out.println("After deletion :");
        list.traverseList(list.head);
        System.out.println(" length of list : "+list.getLength());

    }
}
