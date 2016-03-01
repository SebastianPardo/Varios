/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.ds.binarytree;

import java.lang.reflect.*;

/**
 *
 * @author sebastián
 */
public class LinkedBinaryTree<T> implements BinaryTree<T> {

    public BinaryTreeNode<T> root;
    public static Method visit;
    public static Method theAdd1;
    public static Method theOutput;
    public static int count;

    static {
        try {
            Class<LinkedBinaryTree> lbt = LinkedBinaryTree.class;
            theAdd1 = lbt.getMethod("add1", BinaryTreeNode.class);
            theOutput = lbt.getMethod("output", BinaryTreeNode.class);
        } catch (Exception e) {

        }
    }

    public LinkedBinaryTree() {
        root = null;
    }

    public static <T> void output(BinaryTreeNode<T> t) {
        System.out.print(t.element + "");
    }

    public static <T> void add1(BinaryTreeNode<T> t) {
        count++;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public T root() {
        if (root == null) {
            return null;
        }
        return root.element;
    }
    public void makeTree(T root, BinaryTree<T> left, BinaryTree<T> rigth){
        this.root = new BinaryTreeNode(root, ((LinkedBinaryTree<T>)left).root, ((LinkedBinaryTree<T>)rigth).root);
    }

    @Override
    public BinaryTree<T> removeLeftSubtree() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BinaryTree<T> removeRightSubtree() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void preOrder(Method visit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inOrder(Method visit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postOrder(Method visit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void levelOrder(Method visit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
