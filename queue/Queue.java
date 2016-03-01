/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.ds.queue;

/**
 *
 * @author sebastián
 */
public interface Queue<T> {

    public boolean isEmpty();

    public void put(T theElement);

    public T remove();

    public T getRearElement();

    public T getFrontElement();
}
