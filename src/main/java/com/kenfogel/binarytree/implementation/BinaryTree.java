package com.kenfogel.binarytree.implementation;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Based on the code found at http://cslibrary.stanford.edu/110/BinaryTrees.html
 *
 * @author Ken Fogel
 */
public class BinaryTree {

    // Root node reference. Will be null for an empty tree.
    private BinaryTreeNode root;

    /**
     * Creates an empty binary tree -- a null root reference.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Inserts the given data into the binary tree.Uses a recursive helper.
     *
     * @param data
     */
    public void insert(int data) {
        root = insert(root, data);
    }

    private BinaryTreeNode insert(BinaryTreeNode node, int data) {
        if (node == null) {
            node = new BinaryTreeNode(data);
        } else {
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }

        return (node); // in any case, return the new reference to the caller
    }

    /**
     * Returns true if the given target is in the binary tree.Uses a recursive
     * helper.
     *
     * @param data
     * @return true of false depending on whether the data is found
     */
    public boolean lookup(int data) {
        return (lookup(root, data));
    }

    /**
     * Recursive lookup -- given a node, recur down searching for the given
     * data.
     */
    private boolean lookup(BinaryTreeNode node, int data) {
        if (node == null) {
            return (false);
        }

        if (data == node.data) {
            return (true);
        } else if (data < node.data) {
            return (lookup(node.left, data));
        } else {
            return (lookup(node.right, data));
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    /**
     * Returns the number of nodes in the tree. Uses a recursive helper that
     * recurses down the tree and counts the nodes.
     *
     * @return the number of elements in the tree
     */
    public int size() {
        return (size(root));
    }

    private int size(BinaryTreeNode node) {
        if (node == null) {
            return (0);
        } else {
            return (size(node.left) + 1 + size(node.right));
        }
    }

    /**
     * Returns the max root-to-leaf depth of the tree. Uses a recursive helper
     * that recurses down to find the max depth.
     *
     * @return The depth of the tree from the root to the lowest node
     */
    public int maxDepth() {
        return (maxDepth(root));
    }

    private int maxDepth(BinaryTreeNode node) {
        if (node == null) {
            return (0);
        } else {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            // use the larger + 1 
            return (Math.max(lDepth, rDepth) + 1);
        }
    }

    /**
     * Returns the min value in a non-empty binary search tree. Uses a helper
     * method that iterates to the left to find the min value.
     *
     * @return The smallest value in the tree
     */
    public int minValue() {
        return (minValue(root));
    }

    /**
     * Finds the min value in a non-empty binary search tree.
     */
    private int minValue(BinaryTreeNode node) {
        BinaryTreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }

        return (current.data);
    }

    /**
     * Prints the node values in the "inorder" order. Uses a recursive helper to
     * do the traversal.
     */
    public void printInorderTree() {
        printInorderTree(root);
        System.out.println();
    }

    private void printInorderTree(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        // left, node itself, right 
        printInorderTree(node.left);
        System.out.print(node.data + "  ");
        printInorderTree(node.right);
    }

    /**
     * Prints the node values in the "postorder" order. Uses a recursive helper
     * to do the traversal.
     */
    public void printPostorder() {
        printPostorder(root);
        System.out.println();
    }

    private void printPostorder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        // first recur on both subtrees 
        printPostorder(node.left);
        printPostorder(node.right);

        // then deal with the node 
        System.out.print(node.data + "  ");
    }

    /**
     * Given a binary tree, prints out all of its root-to-leaf paths, one per
     * line. Uses a recursive helper to do the work.
     */
    public void printPaths() {
        int[] path = new int[1000];
        printPaths(root, path, 0);
    }

    /**
     * Recursive printPaths helper -- given a node, and an array containing the
     * path from the root node up to but not including this node, prints out all
     * the root-leaf paths.
     */
    private void printPaths(BinaryTreeNode node, int[] path, int pathLen) {
        if (node == null) {
            return;
        }

        // append this node to the path array 
        path[pathLen] = node.data;
        pathLen++;

        // it's a leaf, so print the path that led to here 
        if (node.left == null && node.right == null) {
            printArray(path, pathLen);
        } else {
            // otherwise try both subtrees 
            printPaths(node.left, path, pathLen);
            printPaths(node.right, path, pathLen);
        }
    }

    /**
     * Utility that prints ints from an array on one line.
     */
    private void printArray(int[] ints, int len) {
        int i;
        for (i = 0; i < len; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }

    /**
     * Prints out each level in the tree from left to right. Uses a recursive
     * helper to do the work.
     */
    public void printLineByLine() {
        printLineByLine(root);
    }

    private void printLineByLine(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        final Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode x = queue.remove();
                System.out.print(x.data + " ");
                if (x.left != null) {
                    queue.add(x.left);
                }
                if (x.right != null) {
                    queue.add(x.right);
                }
            }
            // new level
            System.out.println();
        }
    }
}
