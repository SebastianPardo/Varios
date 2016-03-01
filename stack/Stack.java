/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.ds.stack;

/**
 *
 * @author sebastián
 */
public interface Stack <T> {
    public boolean isEmpty();
    public void push(T theElemnt);
    public T pop();
    public T peek();
    
}
