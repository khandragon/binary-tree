package com.kenfogel.binarytree.implementation;

/**
 * Based on the code found at http://cslibrary.stanford.edu/110/BinaryTrees.html
 * 
 * @author Ken Fogel
 */
public class BinaryTreeNode {

    BinaryTreeNode left;
    BinaryTreeNode right;
    int data;

    public BinaryTreeNode(int newData) {
        left = null;
        right = null;
        data = newData;
    }
}
