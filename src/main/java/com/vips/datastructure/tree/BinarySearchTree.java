package com.vips.datastructure.tree;

import com.vips.datastructure.list.Node;

/**
 * @author Vipin Sharma
 * @category <blockquote></blockquote>
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

        if (rootNode.getData() >= element){
            rootNode.setPrevious(insert(element,rootNode.getLeft()));
        }else{
            rootNode.setNext(insert(element,rootNode.getRight()));
        }
    }

    @Override
    public void deleteElement(Integer element) {

    }

    private Node insert(Integer element, Node<Integer> node){

        if(node == null){
            node = new Node<>(element);
            return node;
        }

        if(node.getData() > element){
            node.setPrevious(insert(element,node.getLeft()));
        }else{
            node.setNext(insert(element,node.getRight()));
        }
        return null;
    }

    public static void main(String[] args) {

        Tree<Integer> BST = new BinarySearchTree();
        BST.insertElement(10);
        BST.insertElement(12);
        BST.insertElement(8);
        BST.insertElement(6);

    }
}
