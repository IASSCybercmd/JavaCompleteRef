package com.DataStructure.Trees;

/**
 * This program show how we can traverse the Trees.
 * 1. Inorder
 * 2. Preorder
 * 3. Postorder
 * 
 * 
 * @author Priyanshu Raj
 * @version 5 July 2023
 * @see Reference1
 */

 //This is the Node of the Tree.
 class Node{
    int data;
    Node left;
    Node right;

    public Node(int key){
        data = key;
        left = right = null;
    }
 }

 public class TreeTraversal{
    //Defining the root node.
    Node root;
    //Please read : Ref1
    TreeTraversal(){
        root = null;
    }

    /**
     * This method is used to traverse the tree using inorder traversal.
     * @param node
     */
    void inorder(Node node){
        if(node == null){
            return;
        }

        //Traverse left
        inorder(node.left);
        //Traverse root
        System.out.print(node.data + "->");
        //Traverse right
        inorder(node.right);
    }

    /**
     * This method is used to traverse the tree using preorder traversal.
     * @param node
     */
    void preorder(Node node){
        if(node == null){
            return;
        }

        //Traverse root
        System.out.print(node.data + "->");
        //Traverse left
        preorder(node.left);
        //Traverse right
        preorder(node.right);
    }

    /**
     * This method is used to traverse the tree using postorder traversal.
     * @param node
     */
    void postorder(Node node){
        if(node == null){
            return;
        }

        //Traverse left
        postorder(node.left);
        //Traverse right
        postorder(node.right);
        //Traverse root
        System.out.print(node.data + "->");
    }

    public static void main(String[] args) {
        TreeTraversal tree = new TreeTraversal();
        tree.root = new Node(3);
        tree.root.left = new Node(8);
        tree.root.right = new Node(9);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(7);

        System.out.println("Inorder traversal");
        tree.inorder(tree.root);
        System.out.println("Preorder traversal");
        tree.preorder(tree.root);
        System.out.println("Postorder traversal");
        tree.postorder(tree.root);
    }
 }
