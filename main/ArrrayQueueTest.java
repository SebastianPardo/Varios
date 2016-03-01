/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.ds.main;

import co.edu.unal.ds.queue.ArrayQueue;

/**
 *
 * @author sebastián
 */
public class ArrrayQueueTest {

    public static void main(String[] arg) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 1; i <= 25; i++) {
            queue.put(i);
        }
            System.out.println("element remove 1 : "+queue.remove());
            System.out.println("element remove 2 : "+queue.remove());
        
        //queue.put(9);
        //System.out.println(queue.toString());
        System.out.println("front element :" + queue.getFrontElement());
        System.out.println("rear element :" + queue.getRearElement());

        System.out.println("aqui va el string" + queue);
    }

}
