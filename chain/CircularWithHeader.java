package co.edu.unal.ds.chain;

import co.edu.unal.ds.list.LinearList;
import java.util.Objects;

public class CircularWithHeader<T> implements LinearList<T> {

    protected ChainNode<T> headerNode;
    protected int size;

    public CircularWithHeader() {
        headerNode = new ChainNode<T>();
        headerNode.next = headerNode;
        size = 0;
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
        ChainNode<T> currentNode = headerNode.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.element;
    }

    public int indexOf(T elem) {
        headerNode.element = elem;
        ChainNode<T> currentNode = headerNode.next;
        int index = 0;
        while (!currentNode.element.equals(elem)) {
            currentNode = currentNode.next;
            index++;
        }
        if (currentNode == headerNode) {
            return -1;
        }
        return index;
    }
    
    public int indexOfSpecial(T elem) {
        ChainNode<T> currentNode = headerNode.next;
        int index = 0, i=0;
        boolean flag = false;
        while (!(currentNode == headerNode)) {
            if(currentNode.element.equals(elem)){
                    index = i;
                    System.out.printf("%d ",index);
                    flag = true;
            }
            currentNode = currentNode.next;
            i++;
        }
        if (!flag) {
            return -1;
        }
        return index;
    }

    public T remove(int index) {
        checkIndex(index);
        T removedElement;

        ChainNode<T> q = headerNode;
        for (int i = 0; i < index - 1; i++) {
            q = q.next;
        }
        removedElement = q.next.element;
        q.next = q.next.next;
        size--;
        return removedElement;
    }

    public void add(int index, T elem) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(" :c ");
        }
        ChainNode<T> p = headerNode;
        for (int i = 0; i < index - 1; i++) {
            p = p.next;
        }
        p.next = new ChainNode<T>(elem, p.next);
        size++;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        ChainNode<T> p = headerNode.next;
        while (p != headerNode) {
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
