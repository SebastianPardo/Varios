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
public class DerivedChainLinkedStack<T> extends Chain<T> implements Stack<T> {

    public DerivedChainLinkedStack() {
        super();

    }

    public boolean isEmpty() {
        return super.isEmpty();
    }
    
    public void push (T theElement){
        add(0,theElement);
    }
    
    public T pop(){
        return remove(0);
    }
    
    public T peek (){
        return get(0);
    }

}
