package co.edu.unal.ds.list;

import java.util.*;

@SuppressWarnings("unchecked")
public class ArrayLinearList<T> implements LinearList<T>,Iterable<T> {

    protected T[] element;
    protected int size;

    public ArrayLinearList() {
        this(10);
    }

    public ArrayLinearList(int initialCapacity) {
        element = (T[]) new Object[initialCapacity];
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
            throw new IndexOutOfBoundsException();
        }
    }

    public void add(int index, T elem) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (size == element.length) {
            T[] old = element;
            element = (T[]) new Object[2 * size];
            System.arraycopy(old, 0, element, 0, size);
        }

        for (int i = size - 1; i >= index; i--) {
            element[i + 1] = element[i];
        }

        element[index] = elem;
        size++;
    }

    public T get(int index) {
        checkIndex(index);
        return element[index];
    }

    public int indexOf(T elem) {
        for (int i = 0; i < size; ++i) {
            if (elem.equals(element[i])) {
                return i;
            }
        }
        return -1;
    }

    public T remove(int index) {
        checkIndex(index);
        T removed = element[ index];
        for (int i = index; i < size - 1; i++) {
            element[ i] = element[ i + 1];
        }
        element[ --size] = null;
        return removed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (T elem : this) {
            sb.append(Objects.toString(elem)).
                    append(", ");
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    public Iterator<T> iterator() {
        return new ArrayLinearListIterator<T>(this);
    }

    @SuppressWarnings("hiding")
    class ArrayLinearListIterator<T> implements Iterator<T> {

        protected ArrayLinearList<T> list;
        protected int nextIndex;

        public ArrayLinearListIterator(ArrayLinearList<T> list) {
            this.list = list;
            nextIndex = 0;
        }

        public boolean hasNext() {
            return nextIndex < list.size();
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return list.element[ nextIndex++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public int getNextIndex() {
            return nextIndex;
        }

        protected void setNextIndex(int Index) {
            nextIndex = Index;
        }
    }
}
