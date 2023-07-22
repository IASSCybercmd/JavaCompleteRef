package com.DataStructure.Trees;

/**
 * ~ ~ ~ ~ ~ ~ ~ Binary Search Tree ~ ~ ~ ~ ~ ~ ~
 * 
 * BST is a data structure used to maintain a sorted list of numbers
 * effectively.
 * 
 * Maximum -> 2 Children.
 * Key features -> perform search for a number in O(log(n)) time.
 * 
 * Properties of Binary search tree :
 * 
 * 1. Left subtree node < root node < right subtree node
 * 2. Left and right subtree of each node ia a BST in itself.
 * 
 * 
 * 
 * This program show the use of BST and it's operations.
 * 
 * @author Priyanshu Raj
 * @version 1.0
 */
public class BinarySearchTree {
    /**
     * This is the Node class that's used to make the node.
     */
    class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = null;
            right = null;
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    /**
     * This is a wrapper function used for insertion of a key.
     * 
     * @param key Value to be inserted.
     */
    void insert(int key) {
        root = insertKey(root, key);
    }

    /**
     * This method is used to insert value in a BST at correct position
     * while taking care of the required conditons for BST.
     * 
     * @param root This is the address of the root node.
     * @param key  Value to be inserted.
     */
    Node insertKey(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (root.data > key) {
            root.left = insertKey(root.left, key);
        } else if (root.data < key) {
            root.right = insertKey(root.right, key);
        }
        return root;
    }

    /**
     * This is a wrapper function for deletion of a value.
     * 
     * @param key Value to be searched and deleted.
     */
    void delete(int key) {
        root = deleteKey(root, key);
    }

    /**
     * This method deleted the passed key while maintaining the order
     * of the BST.
     * 
     * @param node Initially the root node is passed, but later on during recursion
     *             calls the current node is passed.
     * @param key  The value to be deleted.
     * @return Returns the root node.
     */
    Node deleteKey(Node node, int key) {
        // Checks if the tree is null or we're on the end of the tree.
        if (node == null) {
            return node;
        }

        // Traversing to the correct node , same as we did previously.
        if (key < node.data) {
            /*
             * If the key to delete is less than the current node's key,
             * ~ traverse to the left subtree and recursively delete the key from there.
             * ~ Don't confuse with this assignemnt this will help in manging the order of
             * the
             * ~ tree when recursion call will return backwards after successfull deletion.
             */
            node.left = deleteKey(node.left, key);
        } else if (key > node.data) {
            /*
             * If the key to delete is greater than the current node's key,
             * ~ traverse to the right subtree and recursively delete the key from there.
             */
            node.right = deleteKey(node.right, key);
        } else {
            /*
             * If the above 2 condn don't matches i.e the key to delete matches the
             * ~ current node's key & we have found the node to delete.
             */

            // Case 1: Node with only one child or no child
            // The return statement here will be the new value of the node to be deleted.
            if (node.left == null) {
                // If the node has no left child, return its right child.
                // There is a chance that there is no right child also in this case null will be
                // returned.
                // This effectively removes the node from the tree.
                return node.right;
            } else if (node.right == null) {
                // If the node has no right child, return its left child.
                // This effectively removes the node from the tree.
                return node.left;
            }

            // Case 2: Node with two children
            // If the node has two children, we find the minimum node in the right subtree
            // (the node with the smallest key but greater than the current node's key).
            // This would the inorder successor of the current node & it alwasy reside on
            // right side.
            // Replace the current node's key with the key of the minimum node found.
            node.data = minValue(node.right);

            // Now, we need to delete the minimum node from the right subtree.
            // This node has either no children or a right child (the left child is the
            // minimum).
            node.right = deleteKey(node.right, node.data);
        }
        return node;
    }

    // The inorder successor of a node is always the min val on the right side
    // subtree of the node(i.e node.right).
    // Find the inorder successor
    int minValue(Node node) {
        int minVal = node.data;
        while (node.left != null) {
            minVal = node.left.data;
            node = node.left;
        }
        return minVal;
    }

    /**
     * Search for a key in the Binary Search Tree (BST).
     *
     * @param root The root node of the BST or the current node in the recursive
     *             call.
     * @param key  The value to be searched for in the BST.
     * @return If the key is found in the BST, returns the node containing the key.
     *         If the key is not found, returns null.
     */
    public Node search(Node node, int key) {
        // Base case: If the tree is empty or the key is present at the root
        if (node == null || node.data == key) {
            return node;
        }

        // Key is greater than root's key, so search in the right subtree
        if (node.data < key) {
            return search(node.right, key);
        }

        // Key is smaller than root's key, so search in the left subtree
        return search(node.left, key);
    }

    void inorder() {
        inorderPrint(root);
    }

    public void inorderPrint(Node root) {
        if (root == null) {
            return;
        }
        inorderPrint(root.left);
        System.out.print(root.data + "-> ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(8);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(10);
        tree.insert(14);
        tree.insert(4);

        System.out.print("Inorder traversal: ");
        tree.inorder();

        System.out.println("\n\nAfter deleting 10");
        tree.delete(10);
        System.out.print("Inorder traversal: ");
        tree.inorder();
    }
}

// javac com/DataStructure/Trees/BinarySearchTree.java && java com.DataStructure.Trees.BinarySearchTree
