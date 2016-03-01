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
public interface BinaryTree<T> {

    boolean isEmpty();
    T root();
    void makeTree(T root, BinaryTree<T> left, BinaryTree<T> rigth);
    BinaryTree<T> removeLeftSubtree();
    BinaryTree<T> removeRightSubtree();
    void preOrder(Method visit);
    void inOrder(Method visit);
    void postOrder(Method visit);
    void levelOrder(Method visit);

}
