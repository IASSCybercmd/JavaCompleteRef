package com.DataStructure.Trees;

/**
 * This program checks if a binary tree is a full binary tree in Java or not.
 * 
 * @author Priyanshu Raj
 * @version 7 July 2023
 * @see https://www.programiz.com/dsa/full-binary-tree
 * 
 * Run -> javac com/DataStructure/Trees/FullBinaryTree.java && java com.DataStructure.Trees.FullBinaryTree
 */

 // Making the node class.
 class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        left = right = null;
    }
 }

 public class FullBinaryTree{
    
    Node root;

    boolean isFullBinaryTree(Node node){
        /* Check if tree is empty or not , as according to defn an empty tree is also a FBT . */
        if(node == null){
            return true;
        }

        /* This condition is checking whether the current node is a leaf node, meaning it has no child nodes. */
        if(node.left == null && node.right == null){
            return true;
        }

        /**
         * This condition checks whether the current node has both a non-null leftChild and a non-null rightChild,
         * as FBT ony has 2 or 0 child nodes and if a node has only one node then it's not a FBT.
         * This check every node that whether it has both left and right nodes or not.
         */

        if(node.left != null && node.right != null){
            return (isFullBinaryTree(node.left) && isFullBinaryTree(node.right));
        }

        /* If no above condn match then the tree is not a FBT. */
        return false;



    }
    public static void main(String[] args) {
        FullBinaryTree tree = new FullBinaryTree();
        tree.root = new Node(3);
        tree.root.left = new Node(8);
        tree.root.right = new Node(9);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(7);

        if (tree.isFullBinaryTree(tree.root))
            System.out.print("The tree is a full binary tree");
        else
            System.out.print("The tree is not a full binary tree");
    }
 }
 