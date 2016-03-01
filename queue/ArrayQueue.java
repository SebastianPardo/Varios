/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.ds.queue;

import java.util.*;

/**
 *
 * @author sebastián
 */
public class ArrayQueue<T> implements Queue<T> {

    protected int front;
    protected int rear;
    T[] queue;

    public ArrayQueue(int initialCapacity) {
        queue = (T[]) new Object[initialCapacity + 1];
        front = 0;
        rear = 0;

    }

    public ArrayQueue() {
        this(10);
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public T getFrontElement() {
        return queue[(front + 1) % queue.length];
    }

    public T getRearElement() {
        return queue[rear];
    }

    public void put(T theElement) {
        if (front == (rear + 1) % queue.length) {
            T[] newQueue = (T[]) new Object[queue.length * 2 + 1];
            int start = (front + 1) % queue.length;
            if (start < 2) {
                System.arraycopy(queue, start, newQueue, 0, queue.length - 1);
            } else {
                System.arraycopy(queue, start, newQueue, 0, queue.length - start);
                System.arraycopy(queue, 0, newQueue, queue.length - start, rear + 1);
            }
            front = newQueue.length - 1;
            rear = queue.length - 2;
            queue = newQueue;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = theElement;
    }

    public T remove() {
        front = (front + 1) % queue.length;
        T elementRemove = queue[front];
        queue[front] = null;
        return elementRemove;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        int start = (front + 1) % queue.length;
        for (int i = start; i != rear; i = (i + 1) % queue.length) {
            sb.append(Objects.toString(queue[i])).append(", ");
        }
        sb.append(Objects.toString(queue[rear]));
        sb.append("]");
        return sb.toString();
    }
}
