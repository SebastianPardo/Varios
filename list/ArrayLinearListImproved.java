package co.edu.unal.ds.list;

import java.util.*;
import java.io.*;


public class ArrayLinearListImproved<T extends Serializable & Comparable< ? super T>> extends ArrayLinearList<T> implements LinearListImproved<T> {

    public ArrayLinearListImproved(int initialCapacity) {
        super(initialCapacity);
    }

    public ArrayLinearListImproved() {
        this(10);
    }

    public void save(String fn) {
        System.out.println("Save..." + size);
        
        try {
            FileOutputStream os = new FileOutputStream(fn);
            os.write(size);
            for (int i = 0; i < size; i++) {
                //System.out.println(this.get(i));
                os.write(A,B));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Save done :) ");
    }

    @SuppressWarnings("unchecked")
    public void load(String fn) {
        int n = 0;
        try {
            FileInputStream(fn) is = new FileInputStream(fn);
            n = is;
            for (int i = 0; i < n;i++) {
                add(i, (T) is.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Load done <:-{D" + n);
    }

    public void sort() {
        Arrays.sort(element, 0, size);
    }

    public void sort(Comparator<T> c) {
        Arrays.sort(element, 0, size, c);
    }
}
