package com.vips.datastructure.stack.version01;

/**
 * @author Vipin Sharma
 * @category <blockquote></blockquote>
 * @DATE 5/9/17
 **/
public class StackArrayImpl<T> implements Stack<T> {

    private T[] stack;
    private int noOfItems;

    public StackArrayImpl(){
        this.stack = (T[])new Object[1];
    }

    @Override
    public void push(T data) {
        if(this.noOfItems == this.stack.length){
            resizeArray(2*this.stack.length);
        }
        this.stack[noOfItems++] = data;
    }

    @Override
    public T pop() {
        if(this.noOfItems == 0){
            System.out.println("Stack empty !!");
            return null;
        }

        T result = this.stack[--this.noOfItems];
        if(noOfItems > 0 && this.noOfItems == this.stack.length/4){
            resizeArray(this.stack.length/2);
        }

        return result;
    }

    @Override
    public T peek() {
        if(this.noOfItems == 0){
            System.out.println("Stack empty !!");
            return null;
        }

        return this.stack[noOfItems-1];
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public void print(){

        for(int i =0; i < this.noOfItems; i++){
            System.out.print(" "+this.stack[i]+" ");
        }
    }

    private void resizeArray(int size){

        T[] newArray = (T[])new Object[size];

        for(int i =0; i<this.stack.length; i++){
            newArray[i] = this.stack[i];
        }

        this.stack = newArray;
    }

    public static void main(String[] args) {
        StackArrayImpl<Integer> stackArray = new StackArrayImpl();

        stackArray.push(10);
        stackArray.push(20);
        stackArray.push(30);
        stackArray.push(50);
        stackArray.push(40);
        stackArray.push(60);

        System.out.println("\nStack content after push : ");
        stackArray.print();

        stackArray.pop();
        stackArray.pop();
        stackArray.pop();

        System.out.println("\n\nStack content after pop  : ");
        stackArray.print();

        System.out.println("\n\nPeeked item from stack is : "+stackArray.peek());
    }
}
