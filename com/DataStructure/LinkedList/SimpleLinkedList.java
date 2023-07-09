package com.DataStructure.LinkedList;


/**
 * This program implements the simple linked in java.
 * @author Priyanshu Raj
 * @version V1.0 (30June 2023)
 */

public class SimpleLinkedList {
    /* 
     * This is a Node class that represents a node of a linked list.
     */

     Node head;

     public class Node{
        Node next;
        int data;

        Node(int data){
            this.data = data;
            next = null;
        }
     }


    /**
    * This method insert element at the front of the list.
    *
    * @param element  Element to be inserted.
    */
    public void insertFront(int element){
        Node newnode = new Node(element);
        newnode.next = head;
        head = newnode;
    }

    /**
     * This method insert element after a given node.
     * 
     * @param prev  The node after which element needs to be inserted.
     * @param element   The value of the new element inserted.
     */
    public void insertAfter(Node prev, int element){
        if(prev == null){
            System.out.println("Previous node can't be null...");
            return;
        }
        Node newnode = new Node(element);
        newnode.next = prev.next;
        prev.next = newnode;

    }

    /**
     * This method insert element at the end of the list.
     * 
     * @param element This is the element that needs to be inserted.
     */
    public void insertEnd(int element){
        if(head == null){
            head = new Node(element);
            return;
        }
        Node newnode = new Node(element);
        Node last = head;

        while(last.next != null){
            last = last.next;
        }
        last.next = newnode;

    }

    /**
     * This method deletes a element at particular position.
     * 
     * @param position  The position from where element needs to be deleted.
     */
    public void deletion(int position){
        if(head == null){
            System.out.println("The list is empty...");
            return;
        }

        if(position == 0){
            head = head.next;
            return;
        }

        Node temp = head;

        for (int i = 0; temp.next != null && i<position-1; i++) {
            temp = temp.next;
        }

        if(temp == null || temp.next == null){
            return;
        }

        temp.next = temp.next.next;
    }

    /**
     * This method displays the linked list.
     */
    public void display(){
        if(head == null){
            System.out.println("List can't be null...");
            return;
        }

        Node temp = head;
        while(temp != null){
            System.out.print("[" + temp.data + "]" + "->");
            temp = temp.next;
        }
        System.out.print("?");
        System.out.println();
    }

    /**
     * This method is used to sort the list.
     */
    public void sorting(){
        Node current = head;
        Node index = null;

        if(head == null){
            System.out.println("List is empty...");
            return;
        }else{
            while(current != null){
                index = current.next;
                while(index != null){
                    if(current.data > index.data){
                        current.data = current.data ^ index.data ^ (index.data = current.data );
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
        
    }

    /**
     * This method serches for a particular key element and returns true 
     * if found.
     * 
     * @param key  This is the elemnt that is being searched.
     * @return  It returns the boolean value (True/False).
     */
    public boolean searching(int key){
        if(head == null){
            System.out.println("List is empty...No key found");
            return false;
        }
        Node temp = head;
        while(temp != null){
            if(temp.data == key){
                System.out.println("Key found");
                return true;
            }
            temp = temp.next;
        }
        System.out.println("No key found");
        return false;
    }

    
    public static void main(String[] args) {
        SimpleLinkedList tiny = new SimpleLinkedList();
        tiny.insertFront(3);
        tiny.insertFront(9);
        tiny.insertFront(8);
        tiny.insertFront(7);
        tiny.insertFront(2);
        tiny.insertFront(1);
        tiny.insertFront(0);

        tiny.display();
        tiny.sorting();
        tiny.display();
        tiny.searching(3);
        System.out.println(tiny.toString());
    }
}
