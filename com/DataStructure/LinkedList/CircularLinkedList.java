package com.DataStructure.LinkedList;

/**
 * This program is used to show the working of the CircularLinked List
 * using the simple linked list.
 * @author Priyanshu Raj
 * @version V1.0 (1st July 2023)
 * 
 */
public class CircularLinkedList {

    /**
     * Here we don't use constructor for Node class , we do value initialization
     * in the insert method itself.
     */
    static class Node{
        Node next;
        int data;

    }

    /**
     * This is a special method that is used to add node to linked list if 
     * it don't have any element.
     * 
     * @param last  Address of the lastNode 
     * @param data  The data that needs to be inserted.
     * @return      Returns the object lastnode.
     */
    static Node addToEmpty(Node last, int data) {
        if (last != null) {
            return last;
        }
        
        //Creating newnode & initializing it's values...
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = newNode;     //pointing to itself because it's a circular list so if there is only 
                                    //element it is pointing to itself and making a loop.

        last = newNode;
        
        return last;
    }

    /**
     * This method is used to add values at the front of the linked list.
     * 
     * @param last  This is the obj ref of the last node.
     * @param data  This is the data that need to be inserted at front.
     * @return      Returns the object of the lastNode.
     */
    static Node addFront(Node last,int data){
        if(last == null){
            return addToEmpty(last, data);
        }

        //Creating newnode & initializing it's values...
        Node newnode = new Node();
        newnode.data = data;
        newnode.next = last.next;

        last.next = newnode;
        return last;
    }

    /**
     * This method is used to add value at the end of the linked list.
     * 
     * @param last  The object of the last node.
     * @param data  The data that needs to be inserted.
     * @return      Returns the object of the last node.
     */
    static Node addEnd(Node last, int data){
        if(last == null){
            return addToEmpty(last, data);
        }

        //Creating newnode & initializing it's values...
        Node newnode = new Node();
        newnode.data = data;
        newnode.next = last.next;

        last.next = newnode;
        last = newnode;

        return last;

    }

    /**
     * This methods adds value after a key node in the linked list.
     * 
     * @param last  The object reference of the last node.
     * @param key   The value after which new value is to be inserted.
     * @param data  The value to be inserted in the linked list.
     * @return      Returns the object reference to the last node.
     */
     static Node addAfter(Node last,int key, int data){
        if(last == null){
            return addToEmpty(last, data);
        }

        //Creating newnode & initializing it's values...
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        //Node we're gonna use to traverse to the node which contains the key
        Node prevNode = last.next;

        do{
            //This condition checks for the key value unitl it found...
            if(prevNode.data == key){
                //key found...updating the values of newnode and prevnode
                newNode.next = prevNode.next;
                prevNode.next = newNode;


                /* If the prevnode that contained the key value was the last node 
                   If so then we've to update the reference of the last node to newnode.
                */
                if (prevNode == last){
                    last = newNode;
                }

                return last;
            }
            //Updation statement...
            prevNode = prevNode.next;

        //checking whether the prevnode isn't the head as it would stop a loop...    
        }while(prevNode != last.next);

        System.out.println(key + " is not present... ");
        return last;

     }


     /**
      * This methods deletes the node of a circular linked list.

      * @param last This is the object ref of the last node of the linked list.
      * @param key  This is the key that needs to be searched & removed.
      * @return     Returns the object ref of the last node.
      */
     static Node deleteNode(Node last, int key){

        //If list is empty
        if(last == null){
            System.out.println("List is empty...");
            return null;
        }

        //If list has only ONE element
        if(last.data == key && last.next == last){
            last = null;
            return last;
        }

        //If last node is to be deleted.

        /* As this is a circular simply linked list, so even if we've to 
         * delete the last node we can't just link to second last and head node 
         * together as there's no previous pointer (as in doubly Ll) so we've to travel to the
         * second last node .
         */
        Node temp = last;


        if(last.data == key){
            //traversing to the second last node (i.e node whose next node contains the address of last node) 
            while(temp.next != last){
                temp = temp.next;
            }

            //now temp points to -> second last node
            //and we've to point ,temp node to the next of last i.e. first node
            temp.next = last.next;
            last = temp.next;
        }

        
        //Code for deleting other elements...

        /*Traversing to the node before the node to be deleted
        * while taking care of that we won't reach to the end
        * as the last element deletion case is already done.
        */
        while(temp.next != last  && temp.next.data != key){
            temp = temp.next;
        }

        /* temp.next.data != key 
         * The above case we're checking that the node next 
         * to our node, contains the key value or not , if it 
         * doesn't contains then we move to next node and check the same thing
         * once we get a node which contain the data to be deleted we stop.
         */

         // if node to be deleted is found
         if(temp.next.data == key){
            temp.next = temp.next.next;
         }

         return last;
     }
    
    /**
     * This method is used to display the list elements.
     * 
     * @param last  This is the referene to the last node of the list.
     */
    static void display(Node last) {
    
        if (last == null) {
            System.out.println("List is empty.");
            return;
        }
    
        Node temp = last.next;
    
        do {
            System.out.print("[" + temp.data + "]" + "->");
            temp = temp.next;
    
        }while (temp != last.next);
        System.out.print("[End]");
        System.out.println();
      }

    public static void main(String[] args) {

        Node last = null;

        last = addToEmpty(last, 6);
        last = addEnd(last, 8);
        last = addFront(last, 2);

        

        display(last);

        deleteNode(last, 8);
        display(last);
    }
}
