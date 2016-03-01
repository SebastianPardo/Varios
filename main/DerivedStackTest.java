/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.ds.main;

import co.edu.unal.ds.stack.*;
import java.util.*;

/**
 *
 * @author sebastián
 */
public class DerivedStackTest {

    public static void main(String[] args) {

        int x;
        ChainLinkedStack<Integer> s = new ChainLinkedStack<>();
// add a few elements
        s.push(new Integer(1));
        s.push(new Integer(2));
        s.push(new Integer(3));
        s.push(new Integer(4));
        // delete all elements

        while (!s.isEmpty()) {
            System.out.println("Top element is " + s.peek());
            System.out.println("Removed the element " + s.pop());
        }
    }
}
