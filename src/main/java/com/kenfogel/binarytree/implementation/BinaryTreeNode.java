package com.kenfogel.binarytree.implementation;

/**
 * Based on the code found at http://cslibrary.stanford.edu/110/BinaryTrees.html
 * 
 * @author Ken Fogel
 */
public class BinaryTreeNode {

    // package access to support reading and writing directly
    // from the BinaryTree class without the need for setters & getters
    BinaryTreeNode left;
    BinaryTreeNode right;
    int data;

    /**
     * Constructor that creates nodes
     * @param newData 
     */
    public BinaryTreeNode(int newData) {
        left = null;
        right = null;
        data = newData;
    }
}
