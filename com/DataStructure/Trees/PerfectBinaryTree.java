package com.DataStructure.Trees;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface programDetails{
    String Author();
    String Date();
}
/**
 * This program check whether a tree is a perfect binary tree or not.
 */

@programDetails(Author = "Priyanshu Raj", Date = "8 July 2023")
public class PerfectBinaryTree {

    //Node class
    static class Node{
        int data;
        Node left,right;
    }

    //Node initializer
    static Node newNode(int key){
        Node node = new Node();
        node.data = key;
        node.left = null;
        node.right = null;
        
        return node;
    }

    //Check the depth
    static int depth(Node node){
        int d = 0;
        while(node != null){
            d++;
            node = node.left;
        }
        return d;
    }

    //Check if the tree is perect
    static boolean is_perfect(Node node, int d, int level){
        
        //if the tree is empty or node is the next of last node.
        if(node == null){
            return true;
        }

        //if current node is the leaf node and all nodes are on same level.
        if(node.left == null && node.right == null){
            return (d == level+1);
        }

        /**
         * if current node have only left or right node , i.e it is not perfect binary tree.
         * You might think whatif both node are null as inthe case of last node but that case is
         * already covered my friend in above case.
         * So if a case has reached this case it has failed that one & it is combination of two test case
         * i.e only left node is null or only right node is left but writing two cases sepearetely will take lot
         * of space so we've written it combined form.
         */
        if(node.left == null || node.right == null){
            return false;
        }

        return (is_perfect(node.left, d, level+1) && is_perfect(node.right, d, level+1));
    }

    //Wrapper function
    static boolean is_Perfect(Node node){
        int d = depth(node);
        return is_perfect(node, d, 0);
    }
    public static void main(String[] args) {
        Node root = null;
        root = newNode(3);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);

        if (is_Perfect(root) == true)
            System.out.println("The tree is a perfect binary tree");
        else
            System.out.println("The tree is not a perfect binary tree");


    }
}
