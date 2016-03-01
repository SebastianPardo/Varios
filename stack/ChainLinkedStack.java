/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.ds.stack;

import co.edu.unal.ds.chain.*;

/**
 *
 * @author sebastián
 */
public class ChainLinkedStack<T> implements Stack<T> {

    protected ChainNode<T> topNode;

    public ChainLinkedStack() {
        topNode = null;
    }

    public boolean isEmpty() {
        return topNode == null;
    }
    
    public void push(T theElement){
        topNode = new ChainNode <T> (theElement,topNode);
    }
    
    public T pop(){
        
        T removeElement = topNode.element;
        
        topNode = topNode.next;
        
        return removeElement; 
    }
    
    public T peek (){
        
        return topNode.element;
    }

}
