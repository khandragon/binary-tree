package com.kenfogel.binarytree;

import com.kenfogel.binarytree.implementation.BinaryTree;

/**
 * Based on the code found at http://cslibrary.stanford.edu/110/BinaryTrees.html
 *
 * @author Ken Fogel
 */
public class BinaryTreeApp {

    private BinaryTree tree;

    /**
     * Run the various methods in a tree to test it.
     */
    public void perform() {
        tree = new BinaryTree();
        int[] data = {4, 2, 8, 9, 1, 3, 7, 5, 6, 0};
        buildATree(data);
        System.out.println("Look up 7 = " + tree.lookup(7));
        System.out.println("Look up 10 = " + tree.lookup(10));
        System.out.println("Size of tree = " + tree.size());
        System.out.println("Max depth = " + tree.maxDepth());
        System.out.println("Min value = " + tree.minValue());
        System.out.print("Inorder = ");
        tree.printInorderTree();
        System.out.print("Postorder = ");
        tree.printPostorder();
        System.out.println("The Paths");
        tree.printPaths();
        System.out.println("The Tree");
        tree.printLineByLine();
    }

    /**
     * Build a tree by inserting the members of the array into the tree.
     *
     * @param data
     */
    public void buildATree(int data[]) {
        for (int number : data) {
            tree.insert(number);
        }
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        BinaryTreeApp bta = new BinaryTreeApp();
        bta.perform();
        System.exit(0);
    }
}
