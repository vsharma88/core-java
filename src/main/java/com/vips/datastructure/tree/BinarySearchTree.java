package com.vips.datastructure.tree;

import com.vips.datastructure.list.Node;

/**
 * @author Vipin Sharma
 * @category <blockquote>Concepts</blockquote>
 * @DATE 21/09/17
 **/
public class BinarySearchTree<T> implements Tree<Integer>{

    private Node<Integer> rootNode;

    @Override
    public void insertElement(Integer element) {
        if(rootNode == null){
            this.rootNode = new Node<>(element);
            return;
        }
        insert(element,rootNode);
    }

    @Override
    public Integer deleteElement(Integer element) {
        if(this.rootNode == null){
            return null;
        }
         return delete(this.rootNode,element).getData();
    }

    @Override
    public Integer getMaxElement() {
        if(this.rootNode == null){
            return null;
        }
        return getMaximum(this.rootNode);
    }

    @Override
    public Integer getMinElement() {
        if(this.rootNode == null){
            return null;
        }
        return getMinimum(this.rootNode);
    }


    private Node<Integer> delete(Node<Integer> node, Integer data){
        if(node.getData() > data){
            node.setPrevious(delete(node.getLeft(),data));
        }else if (node.getData() < data){
            node.setNext(delete(node.getRight(),data));
        }else{
            if(node.getLeft() == null && node.getRight() == null){
                node = null;
                return node;
            }else if(node.getLeft() == null){
                Node tempNode = node.getRight();
                node = null;
                return tempNode;
            }else if(node.getRight() == null){
                Node tempNode = node.getLeft();
                node = null;
                return tempNode;
            }else{

                Node<Integer> predecessorNode = getPredecessorNode(node.getLeft());
                node.setData(predecessorNode.getData());
                node.setPrevious(delete(node,predecessorNode.getData()));
            }
        }

        return node;
    }

    private Node getPredecessorNode(Node<Integer> node){
        if(node != null && node.getRight() == null){
            return node;
        }
        return getPredecessorNode(node.getRight());
    }


    private Integer getMaximum(Node<Integer> node){
        if(node != null && node.getRight() == null){
            return node.getData();
        }
        return getMinimum(node.getRight());
    }


    private Integer getMinimum(Node<Integer> node){
        if(node != null && node.getLeft() == null){
            return node.getData();
        }
        return getMinimum(node.getLeft());
    }


    private void insert(Integer element, Node<Integer> node){
        if(node.getData() > element){
            if(node.getLeft() != null){
                insert(element,node.getLeft());
            }else{
                Node<Integer> newNode = new Node<>(element);
                node.setPrevious(newNode);
            }
        }else{
            if(node.getRight() != null){
                insert(element,node.getRight());
            }else{
                Node<Integer> newNode = new Node<>(element);
                node.setNext(newNode);
            }
        }
    }



    public static void main(String[] args) {

        Tree<Integer> BST = new BinarySearchTree();
        BST.insertElement(10);
        BST.insertElement(12);
        BST.insertElement(8);
        BST.insertElement(6);


        System.out.println("Minimum Element : ");
        System.out.println(BST.getMinElement());
        System.out.println("Maximum Element : ");
        System.out.println(BST.getMaxElement());

        System.out.println("\n After deletion : ");
        BST.deleteElement(6);
        BST.deleteElement(12);
        System.out.println("Minimum Element : ");
        System.out.println(BST.getMinElement());
        System.out.println("Maximum Element : ");
        System.out.println(BST.getMaxElement());
    }
}
