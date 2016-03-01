package co.edu.unal.ds.list;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SkipEvenArrayLinearList<T extends Serializable & Comparable< ? super T>> extends ArrayLinearListImproved<T> {

    public SkipEvenArrayLinearList(int initialCapacity) {
        super(initialCapacity);
    }

    public SkipEvenArrayLinearList() {
        this(10);
    }

    @Override
    public Iterator<T> iterator() {
        return new SkipEvenArrayLinearListIterator<T>(this);
    }

    @SuppressWarnings("hiding")
    class SkipEvenArrayLinearListIterator<T> extends ArrayLinearList<T>.ArrayLinearListIterator<T> {

        public SkipEvenArrayLinearListIterator(ArrayLinearList<T> list) {
            super(list);
            setNextIndex(1);
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T elem = list.element[nextIndex];
            nextIndex += 2;
            return elem;
        }

    }

}
