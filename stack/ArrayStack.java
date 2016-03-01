/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.ds.stack;

import java.util.*;

/**
 *
 * @author sebastián
 */
public class ArrayStack<T> implements Stack<T> {

    private int top;
    T[] stack;

    public ArrayStack(int initialCapacity) {
        stack = (T[]) new Object[initialCapacity];
        top = -1;
    }

    public ArrayStack() {
        this(10);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(T theElement) {
        if (top == stack.length - 1) {
            T[] oldStack = stack;
            stack = (T[]) new Object[2 * stack.length];
            System.arraycopy(oldStack, 0, stack, 0, oldStack.length);
        }
        top++;
        stack[top] = theElement;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T removeElement = stack[top];
        stack[top] = null;
        --top;
        return removeElement;
    }

   
}
