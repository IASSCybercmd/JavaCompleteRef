package com.DataStructure.Trees;

/**
 * This program is used for checking whether a tree is BalancedBinary tree or
 * not.
 * 
 * @author Priyanshu Raj
 * CREATED ON : 11 July 2023
 *  RUN -> javac com/DataStructure/Trees/BalancedBinaryTree.java && java com.DataStructure.Trees.BalancedBinaryTree
 */

/* The Node class represents a node in the binary tree. */
class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

/*
 * The Height class is a simple wrapper class to hold the height of a tree.
 * 
 * 💡 A wrapper class is a class that encapsulates the primitive data types(such
 * as int, boolean, char, etc.)
 * and provides an object representation of those data types
 */
class Height {
    int height = 0;
}

public class BalancedBinaryTree {

    Node root;

    /**
     * This method checks whether a tree is balanced binary tree or not using
     * heights.
     * 
     * @param root          The current node is refered to as root.
     * @param currentHeight It is the height of currnet node.
     * @return It returns boolean value whether a tree is balanced or not.
     */
    boolean checkHeightBalance(Node root, Height currentHeight) {

        /* CODE SECTION 1 */
        /* THIS CODE AREA CHECKS FOR THE BASE CASES */

        // If tree is empty.
        if (root == null) {
            currentHeight.height = 0;
            return true;
        }

        /*
         * If you'll add this extra check then the height will be accurate but if
         * you'll remove this then all nodes height will be increased by 1, but answer
         * will still come accurate.
         */
        // Check for leaf node
        if (root.left == null && root.right == null) {
            currentHeight.height = 0;
            return true;
        }

        /* CODE SECTION 2 */
        /* THIS CODE AREA FOCUS ON EXTRACTING ESSENTIAL VALUES REQUIRED IN SECTION 3 */

        // Created two new Height obj to store height of left and right subtree
        // respectively.
        Height leftSubTreeHeight = new Height();
        Height rightSubTreeHeight = new Height();

        // Now we check is the left and right subtree is balanced or not.
        boolean isLeftSubtreeBalanced = checkHeightBalance(root.left, leftSubTreeHeight);
        boolean isRightSubtreeBalanced = checkHeightBalance(root.right, rightSubTreeHeight);

        // Store the height value related left and right subtree Height objects, Inorder
        // to ease the calculations.
        int leftHeight = leftSubTreeHeight.height;
        int rightHeight = rightSubTreeHeight.height;

        // Calculate the height of current Node.
        currentHeight.height = Math.max(leftHeight, rightHeight) + 1;

        /* CODE SECTION 3 */
        /*
         * This code area focus on checking the main conditon of proving a tree as
         * Balanced Binary tree.
         */
        if (Math.abs(rightHeight - leftHeight) >= 2)
            return false;
        else
            return isLeftSubtreeBalanced && isRightSubtreeBalanced;

    }

    public static void main(String[] args) {
        Height height = new Height();

        BalancedBinaryTree tree = new BalancedBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        if (tree.checkHeightBalance(tree.root, height))
            System.out.println("The tree is balanced");
        else
            System.out.println("The tree is not balanced");
    }
}