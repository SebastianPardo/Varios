package co.edu.unal.ds.main;

import co.edu.unal.ds.list.*;

public class ListTest {

    public static void main(String args[]) {
        ShuffleList<Integer> list1 = new ShuffleList<Integer>();
        SkipOddArrayLinearList<Integer> list2 = new SkipOddArrayLinearList<Integer>();
        SkipEvenArrayLinearList<Integer> list3 = new SkipEvenArrayLinearList<Integer>();
        for (int i = 0; i < 15; i++) {
            list1.add(0, 15 - i);
            list2.add(0, 15 - i);
            list3.add(0, 15 - i);
        }
        System.out.println("Shufflelist " + list1);
        list1.save("lista1.txt");

        list1.load("lista1.txt");
        System.out.println("shuffle " + list1);
    }
}
