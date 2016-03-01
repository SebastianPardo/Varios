/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.ds.binarytree;

/**
 *
 * @author sebastián
 */
public class BinaryTreeNode<T> {

    T element;
    BinaryTreeNode<T> rigthChild;
    BinaryTreeNode<T> leftChild;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(T theElement) {
        element = theElement;
    }

    public BinaryTreeNode(T theElement, BinaryTreeNode<T> theRigthChild, BinaryTreeNode<T> theLeftChild) {
        element = theElement;
        rigthChild = theRigthChild;
        leftChild = theLeftChild;
    }
    
    public T getElement (){
        return element;
    }
    
    public void setElement(T theElement){
        element=theElement;
    }
    
    public BinaryTreeNode <T> getRigthChild(){
        return rigthChild;
    }
    
    public void setRigthChild(BinaryTreeNode <T> theRigthChild){
        rigthChild = theRigthChild;
    }
    
    public BinaryTreeNode <T> getLeftChild(){
        return leftChild;
    }
    
    public void setLeftChild(BinaryTreeNode <T> theLeftChild){
        leftChild = theLeftChild;
    }   

    @Override
    public String toString(){
        return element.toString();
    }
}
