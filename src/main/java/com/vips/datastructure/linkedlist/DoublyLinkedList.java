package com.vips.datastructure.linkedlist;

/**
 * @author Vipin Sharma
 * @category <blockquote>Concepts</blockquote>
 * @DATE 21/8/17
 *
 * Doubly LinkedList ADT (Abstract Data Type) with the basic operations like :-
 *   1.)Insert at beginning,middle,last
 *   2.)Delete at beginning,middle,last
 *   3.)length
 *   4.)Traverse & print content of list
 *
 **/
public class DoublyLinkedList implements LinkedList{

    private Node head;
    private int length;


    public void insertNode(Object data,Position position, int location){
        Node newNode = new Node(data);
        if(this.head == null){
            this.head = newNode;
            this.length++;
            return;
        }

        Node curr = this.head;
        switch (position){
            case FIRST:
                newNode.setNext(this.head);
                head.setPrevious(newNode);
                head = newNode;
                this.length++;
                break;

            case OTHERS:
                if(location <= Integer.MIN_VALUE){
                    //do nothing
                }else{

                  while(curr!= null && --location > 0){
                      curr = curr.getNext();
                  }
                  newNode.setNext(curr.getNext());
                  newNode.setPrevious(curr);
                  curr.setNext(newNode);
                  this.length++;
                  break;
                }

            case LAST:
                while(curr.getNext() != null){
                    curr = curr.getNext();
                }
                curr.setNext(newNode);
                newNode.setPrevious(curr);
                this.length++;
                break;
            default:
                break;
        }

    }

    public void deleteNode(Position position, int location){
        if(this.head == null)
            return;

        Node curr = this.head;
        switch (position){
            case FIRST:
                curr.getNext().setPrevious(null);
                this.head = curr.getNext();
                curr.setNext(null);
                this.length--;
                break;
            case OTHERS:
                if(location <= Integer.MIN_VALUE){
                }else{
                    while(curr!= null && --location > 0){
                        curr = curr.getNext();
                    }
                    curr.getPrevious().setNext(curr.getNext());
                    curr.getNext().setPrevious(curr.getPrevious());
                    curr.setPrevious(null);
                    this.length--;
                    break;
                }
            case LAST:
                while(curr.getNext() != null){
                    curr = curr.getNext();
                }
                curr.getPrevious().setNext(null);
                curr.setPrevious(null);
                this.length--;
                break;
            default:
                break;
        }
    }

    public int getLength(){
        return this.length;
    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

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
