package co.edu.unal.ds.chain;

import co.edu.unal.ds.list.LinearList;
import java.util.Objects;

public class Chain<T> implements LinearList<T> {

    protected int size;
    protected ChainNode<T> firstNode;

    public Chain() {
        size = 0;
        firstNode = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(" :C ");
        }
    }

    public T get(int index) {
        checkIndex(index);
        ChainNode<T> p = firstNode;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.element;
    }

    public int indexOf(T elem) {
        ChainNode<T> p = firstNode;
        int index = 0;
        while (p != null && !p.element.equals(elem)) {
            p = p.next;
            index++;
        }
        if (p == null) {
            return -1;
        }
        return index;
    }

    public T remove(int index) {
        checkIndex(index);
        T removedElement;
        if (index == 0) {
            removedElement = firstNode.element;
            firstNode = firstNode.next;
        } else {
            ChainNode<T> q = firstNode;
            for (int i = 0; i < index - 1; i++) {
                q = q.next;
            }
            removedElement = q.next.element;
            q.next = q.next.next;
        }
        --size;
        return removedElement;
    }

    public void add(int index, T elem) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(" :c ");
        }
        if (index == 0) {
            firstNode = new ChainNode<T>(elem, firstNode);
        } else {
            ChainNode<T> p = firstNode;
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            p.next = new ChainNode<T>(elem, p.next);
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        ChainNode<T> p = firstNode;
        while (p != null) {
            sb.append(Objects.toString(p.element)).append(", ");
            p = p.next;
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }
}
