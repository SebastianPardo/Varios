/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.ds.b_tree;

import static co.edu.unal.ds.b_tree.binary_tree.leftMostNode;

/**
 *
 * @author Sebastián
 */
public class main_b_tree {
     public static binary_tree inorderSuc(binary_tree root, int k) {
        if (root == null)
            return null;
        if (root.value == k) {
            if (root.right != null)
                return leftMostNode(root.right);
            else {
                binary_tree parent = root.parent;
                binary_tree tmp = root;
                while (parent != null) {
                    if (parent.left == tmp)
                        break;
                    else { // parent.right == root
                        tmp = parent;
                        parent = parent.parent;

                    }
                }
                return parent;
            }
        } else {
            binary_tree lnode = inorderSuc(root.left, k);
            binary_tree rnode = inorderSuc(root.right, k);
            return (lnode != null) ? lnode : rnode;

        }
    }
    //root, left, right
    public static binary_tree preorderSuc(binary_tree node, int k) {
        if (node == null)
            return null;
        if (node.value == k) {

            if (node.left != null)
                return node.left;
            else if (node.right != null)
                return node.right;
            else {

                binary_tree tmp = node;
                binary_tree parent = node.parent;

                while (parent != null) {
                    if (parent.right == tmp) {
                        tmp = parent;
                        parent = parent.parent;
                    } else {// parent.left == tmp
                        if (parent.right != null)
                            return parent.right;
                        else {
                            tmp = parent;
                            parent = parent.parent;
                        }
                    }

                }
                return parent;

            }
        } else {
            binary_tree lnode = preorderSuc(node.left, k);
            binary_tree rnode = preorderSuc(node.right, k);
            return (lnode != null) ? lnode : rnode;
        }
    }

    // left, right, root
    public static binary_tree postorderSuc(binary_tree root, int k) {
        if (root == null)
            return null;
        if (root.value == k) {

            binary_tree parent = root.parent;

            if (parent != null) {
                if (parent.left == root) {
                    if (parent.right != null)
                        return parent.right;
                    else
                        return parent;
                } else // parent.right == root
                    return parent;

            }
            return null;
        } else {
            binary_tree lnode = postorderSuc(root.left, k);
            binary_tree rnode = postorderSuc(root.right, k);
            return (lnode != null) ? lnode : rnode;
        }
    }

}
