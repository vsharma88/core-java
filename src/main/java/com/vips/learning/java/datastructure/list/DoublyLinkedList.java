package com.vips.learning.java.datastructure.list;

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
public class DoublyLinkedList<T extends Comparable<T>> implements LinkedList{

    private Node head;
    private int length;


    public void insertNode(T data,Position position, int location){
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
                      curr = curr.getRight();
                  }
                  newNode.setNext(curr.getRight());
                  newNode.setPrevious(curr);
                  curr.setNext(newNode);
                  this.length++;
                  break;
                }

            case LAST:
                while(curr.getRight() != null){
                    curr = curr.getRight();
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
                curr.getRight().setPrevious(null);
                this.head = curr.getRight();
                curr.setNext(null);
                this.length--;
                break;
            case OTHERS:
                if(location <= Integer.MIN_VALUE){
                }else{
                    while(curr!= null && --location > 0){
                        curr = curr.getRight();
                    }
                    curr.getLeft().setNext(curr.getRight());
                    curr.getRight().setPrevious(curr.getLeft());
                    curr.setPrevious(null);
                    this.length--;
                    break;
                }
            case LAST:
                while(curr.getRight() != null){
                    curr = curr.getRight();
                }
                curr.getLeft().setNext(null);
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
    }

}
