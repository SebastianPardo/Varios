/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.ds.Aplicaciones;

import java.util.*;

/**
 *
 * @author sebastián
 */
public class XorTree {

    public static class Node<T> {

        public T element;
        public Queue<Integer> sons = new LinkedList<Integer>();
        public boolean iBinary;
        public boolean fBinary;

        public Node(T element, boolean iBinary, boolean fBinary) {
            this.element = element;
            this.iBinary = iBinary;
            this.fBinary = fBinary;
        }

        @Override
        public String toString() {
            return "element : " + element + "\n"
                    + "ibinary : " + iBinary + "\n"
                    + "fbinary : " + fBinary + "\n"
                    + "sons : " + sons.toString() + "\n";
        }
    }

    public static class Xor_Tree {

        public static Queue<Integer> queue = new LinkedList<Integer>();
        public static Node[] arrayNodes;
        public static int flipPares = 0;
        public static int flipImpares = 0;
        public static int size;

        public static void imput() {
            Scanner sc = new Scanner(System.in);
            size = sc.nextInt();
            for (int i = 0; i < ((size * 2) - 2); i++) {
                queue.add(sc.nextInt());
            }

            Queue<Boolean> qI = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                if (sc.nextInt() == 1) {
                    qI.add(true);
                } else {
                    qI.add(false);
                }
            }
            Queue<Boolean> qF = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                if (sc.nextInt() == 1) {
                    qF.add(true);
                } else {
                    qF.add(false);
                }
            }
            arrayNodes = new Node[size];

            for (int i = 0; !qI.isEmpty() && !qF.isEmpty(); i++) {
                arrayNodes[i] = new Node<>(i + 1, qI.poll(), qF.poll());
            }

        }

        public static void tree() {

            Queue<Integer> moveNode = new LinkedList<Integer>();
            for (int i = 0; !queue.isEmpty(); i++) {
                int x = queue.poll();
                int y = queue.poll();
                if (x > y) {
                    arrayNodes[y - 1].sons.add(x);
                } else {
                    arrayNodes[x - 1].sons.add(y);
                }
            }

            int level = 1;
            if (arrayNodes[0].iBinary != arrayNodes[0].fBinary) {
                arrayNodes[0].iBinary = arrayNodes[0].fBinary;
                moveNode.add(0);
                flipImpares++;
            }
            int aux = 0;
            while (!arrayNodes[0].sons.isEmpty()) {
                aux++;
                queue.add((Integer) arrayNodes[0].sons.poll());
            }

            int son = 0;

            while (!queue.isEmpty()) {

                level++;
                int count = 0;
                int flipPar = 0;
                int flipImpar = 0;
                while (aux != 0) {

                    son = queue.poll();
                    son = son - 1;
                    aux--;

                    if (level % 2 == 0) {
                        while (!arrayNodes[son].sons.isEmpty()) {
                            count++;
                            queue.add((Integer) arrayNodes[son].sons.poll());
                        }
                        if (flipPares % 2 == 0) {
                            if (arrayNodes[son].iBinary != arrayNodes[son].fBinary) {
                                arrayNodes[son].iBinary = arrayNodes[son].fBinary;
                                moveNode.add(son + 1);
                                flipPar++;
                            }
                        } else {
                            arrayNodes[son].iBinary = arrayNodes[son].fBinary;
                            if (arrayNodes[son].iBinary != arrayNodes[son].fBinary) {
                                arrayNodes[son].iBinary = arrayNodes[son].fBinary;
                                moveNode.add(son + 1);
                                flipPar++;
                            }
                        }

                    } else {
                        while (!arrayNodes[son].sons.isEmpty()) {
                            count++;
                            queue.add((Integer) arrayNodes[son].sons.poll());
                        }
                        if (flipImpares % 2 == 0) {
                            if (arrayNodes[son].iBinary != arrayNodes[son].fBinary) {
                                arrayNodes[son].iBinary = arrayNodes[son].fBinary;
                                moveNode.add(son + 1);
                                flipImpar++;
                            }
                        } else {
                            arrayNodes[son].iBinary = arrayNodes[son].fBinary;
                            if (arrayNodes[son].iBinary != arrayNodes[son].fBinary) {
                                arrayNodes[son].iBinary = arrayNodes[son].fBinary;
                                moveNode.add(son + 1);
                                flipImpar++;
                            }
                        }
                    }

                }
                flipPares = flipPares + flipPar;
                flipImpares = flipImpares + flipImpar;
                aux = count;
            }
            System.out.println((flipPares + flipImpares));
            while (!moveNode.isEmpty()) {
                System.out.println(moveNode.poll());
            }
        }

        public static void main(String arg[]) {
            imput();
            tree();

        }
    }
}
