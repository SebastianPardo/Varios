/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.ds.stack;
import co.edu.unal.ds.list.*;
import java.util.*;
/**
 *
 * @author sebastián
 */
public class DerivedArrayStack <T> extends ArrayLinearList <T> implements Stack <T> {
     
    public DerivedArrayStack(int initialCapacity){
         super(initialCapacity);
     }
    
    public DerivedArrayStack(){
         this(10);
     }
    
    public boolean isEmpty(){
        return super.isEmpty();
    }
    
    public void push(T theElement){
        add(0, theElement);
    }
    
    public T pop(){
       return remove(0);
    }
    
    public T peek (){
        T topElement = get(0);
        return topElement;
    }
    
}



















