package com.DataStructure.LinkedList;

/**
 * This program show the working of doubly linked list in java.
 * @author (Name="Priyanshu Raj" , Date="30th June 2023")
 * @version V1.0 (1st July 2023)
 */
public class DoublyLinkedList {

    Node head;

    public class Node{
        Node prev;
        int data;
        Node next;

        Node(int data){
            this.data = data;
            prev = next = null;
        }
    }

    /**
     * This method insert element in a doubly linked list.
     * 
     * @param element  to be inserted.
     */
    public void insertFront(int element){
        Node newnode = new Node(element);
        newnode.next = head;
        if(head != null){
            head.prev = newnode;
        }
        head = newnode;
    }

    /**
     * This method insert element after a node in a linked list.
     * 
     * @param prevNode  This is the node after which value is going to be inserted.
     * @param element   This is the value that is going to be inserted.
     */
    public void insertAfter(Node prevNode, int element){
        if(prevNode == null){
            System.out.println("Prev can't be null...");
            return;
        }
        Node newnode = new Node(element);
        newnode.next = prevNode.next;
        newnode.prev = prevNode;

        prevNode.next = newnode;

        if(newnode.next != null){
            newnode.next.prev = newnode;
        }
    }

    /**
     * This method insert element at the end of the list.
     * 
     * @param element   element that is going to get inserted.
     */
    public void insertEnd(int element){
        if(head == null){
            head = new Node(element);
            return;
        }
        Node newnode = new Node(element);
        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }
        newnode.prev = temp;
        temp.next = newnode;
    }

    /**
     * This method is used to delete the node from the list.
     * 
     * @param delNode   Node that needs to be deleted.
     */
    public void deleteNode(Node delNode){
        //If list is empty
        if(delNode == null || head == null){
            return;
        }

        //If node to delete is the first node.
        if(delNode == head){
            head = head.next;   
        }

        if(delNode.next != null){
            delNode.next.prev = delNode.prev;
        }

        if(delNode.prev != null){
            delNode.prev.next = delNode.next;
        }
    }


    /**
     * This method is used to print the linked list.
     */
    public void display(){
        if(head == null){
            System.out.println("Error 404");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print("[" + temp.data + "]" + "->");
            temp = temp.next;
        }
        System.out.print("[End]");
        System.out.println();
    }




    public static void main(String[] args) {
        DoublyLinkedList dlo = new DoublyLinkedList();
        dlo.insertFront(2);
        dlo.insertFront(1);
        dlo.insertFront(3);
        dlo.insertFront(4);
        dlo.insertFront(5);
        dlo.insertFront(6);
        dlo.insertFront(7);
        dlo.insertFront(8);
        dlo.insertFront(9);

        
        dlo.display();

        dlo.insertAfter(dlo.head.next.next.next.next.next,  69);
        dlo.display();
        dlo.insertEnd(99);
        dlo.display();

    }
}
