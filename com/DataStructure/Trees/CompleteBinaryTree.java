package com.DataStructure.Trees;

//Creating of Node...
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

/**
 * This method is used to check whether a tree is Complete binary tree or not.
 * 
 * @author Priyanshu Raj
 * Date created: 10 July 2023
 */
public class CompleteBinaryTree {

    Node root;

    /**
     * This calculate the total number of nodes in the tree.
     * 
     * @param root This is the ref to the root node.
     * @return Total number of nodes in the tree.
     */
    int calcTNodes(Node root) {

        if (root == null) {
            return 0;
        }

        return (1 + calcTNodes(root.left) + calcTNodes(root.right));
    }

    boolean checkComplete(Node root, int index, int tNode) {

        // Checks if the current nodes is not at the end of subtree or tree is not
        // empty.
        if (root == null) {
            return true;
        }

        // Indicates that there are missing nodes from the left side of a level.
        if (index >= tNode) {
            return false;
        }

        /**
         * If the above conditions are not met, we recursively call checkComplete for
         * the left and
         * right child nodes, using the formulas 2 * index + 1 and 2 * index + 2
         * respectively.
         */

        return (checkComplete(root.left, 2 * index + 1, tNode) && checkComplete(root.right, 2 * index + 2, tNode));
    }

    public static void main(String[] args) {
        CompleteBinaryTree tree = new CompleteBinaryTree();
        tree.root = new Node(3);
        tree.root.left = new Node(8);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.left.left = new Node(4);
        tree.root.right.left = new Node(6);

        int node_count = tree.calcTNodes(tree.root);
        //index of root nodes is 0
        int index = 0;

        if (tree.checkComplete(tree.root, index, node_count))
            System.out.println("The tree is a complete binary tree");
        else
            System.out.println("The tree is not a complete binary tree");
    }

}
