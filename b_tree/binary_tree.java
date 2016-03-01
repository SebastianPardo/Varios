/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.ds.b_tree;
/**
 *
 * @author Sebastián
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class binary_tree {

    private int value;
    private binary_tree left;
    private binary_tree right;
    private binary_tree parent;

    public binary_tree() {
    }

    public binary_tree(int v) {
        this.value = v;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public static void insertNode(binary_tree node, int v) {
        if (node != null) {
            if (v <= node.value) {
                if (node.left == null) {
                    node.left = new binary_tree(v);
                    node.left.parent = node;
                } else {
                    insertNode(node.left, v);
                }
            } else {
                if (node.right == null) {
                    node.right = new binary_tree(v);
                    node.right.parent = node;
                } else {
                    insertNode(node.right, v);
                }
            }
        }
    }

    public static void toString(binary_tree root) {
        if (root == null) {
            System.out.println("a null tree");
            return;
        }
        Queue<binary_tree> current = new LinkedList<binary_tree>();
        Queue<binary_tree> next = new LinkedList<binary_tree>();
        current.add(root);
        System.out.println(root.value);

        while (!current.isEmpty()) {
            binary_tree node = current.poll();
            if (node.left != null) {
                next.add(node.left);
                System.out.print(node.left.value + "\t");
            }
            if (node.right != null) {
                next.add(node.right);
                System.out.print(node.right.value + "\t");
            }
            if (current.isEmpty()) {
                current.addAll(next);
                next.clear();
                System.out.println();
            }
        }
    }

    public static int ancho(binary_tree root) {
        if (root == null) {
            return 0;
        }

        Queue<binary_tree> current = new LinkedList<binary_tree>();
        Queue<binary_tree> next = new LinkedList<binary_tree>();
        current.add(root);
        int width = 1;

        while (!current.isEmpty()) {
            binary_tree node = current.poll();
            if (node.left != null) {
                next.add(node.left);

            }
            if (node.right != null) {
                next.add(node.right);

            }
            if (current.isEmpty()) {
                if (next.size() > width) {
                    width = next.size();
                }
                current.addAll(next);
                next.clear();
            }

        }
        return width;

    }

    public static int alto(binary_tree node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(alto(node.left), alto(node.right)) + 1;
        }

    }

    public static int Arbol(binary_tree root) {
        if (root == null) {
            return 0;
        } else {
            return Arbol(root.left) + Arbol(root.right) + 1;
        }
    }

    public static void main(String[] args) {
        int InicialTamaño = 20;
        binary_tree tree = new binary_tree(InicialTamaño);
        boolean flag = false;
        Scanner lectura = new Scanner(System.in);
        int i;
        int aux = 0;
        while (!flag) {
            if (aux == InicialTamaño - 1) {
                binary_tree nextTree = new binary_tree(InicialTamaño * 2);
                nextTree = tree;
                System.out.println("inserte valor");
                i = lectura.nextInt();
                insertNode(nextTree, i);
                toString(nextTree);
            }else{
            System.out.println("inserte valor");
            i = lectura.nextInt();
            insertNode(tree, i);
            toString(tree);
            }
            System.out.println("¿desea ingresar un nuevo valor?");
            
            System.out.println("1. si");
            System.out.println("2. no");
            i = lectura.nextInt();
            if (i == 2) {
                flag = true;
            }
            if (i == 1) {
                aux++;
            }
        }

    }

}
