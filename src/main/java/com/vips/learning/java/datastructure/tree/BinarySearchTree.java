package com.vips.learning.java.datastructure.tree;

import com.vips.learning.java.datastructure.list.Node;

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

    @Override
    public void traverse(Strategy strategy) {
        switch (strategy){
            case IN_ORDER:
                System.out.println("\nIn Order Traversal");
                inOrder(this.rootNode);
                break;
            case PRE_ORDER:
                System.out.println("\nPre-Order Traversal ");
                preOrder(this.rootNode);
                break;
            case POST_ORDER:
                System.out.println("\nPost Order Traversal ");
                postOrder(this.rootNode);
                break;
            case LEVEL_ORDER:
                break;
        }
    }

    private void preOrder(Node<Integer> node){
        if(node == null) return;
        System.out.print(" "+node.getData()+" ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    private void postOrder(Node<Integer> node){
        if(node==null) return;
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(" "+node.getData()+" ");
    }

    private void inOrder(Node<Integer> node){
        if(node==null) return;
        inOrder(node.getLeft());
        System.out.print(" "+node.getData()+" ");
        inOrder(node.getRight());
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

        BST.traverse(Strategy.IN_ORDER);
        BST.traverse(Strategy.PRE_ORDER);
        BST.traverse(Strategy.POST_ORDER);


        System.out.print("\n\nMinimum Element : ");
        System.out.print(BST.getMinElement());
        System.out.print("\nMaximum Element : ");
        System.out.print(BST.getMaxElement());

        System.out.print(" \n\n After deletion : \n\n");

        BST.deleteElement(6);
        BST.deleteElement(12);

        System.out.print("Minimum Element : ");
        System.out.print(BST.getMinElement());
        System.out.print("\nMaximum Element : ");
        System.out.print(BST.getMaxElement());

    }
}
