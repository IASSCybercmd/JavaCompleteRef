package com.Recursion;

import java.util.ArrayList;

/***
 * This code file contains different question related to java Arrays- Recursion topic.
 * ref: https://youtu.be/sTdiMLom00U
 * @author Priyanshu Raj
 * @category Core Java
 * @version V1.0(13July 2023)
 * 
 * Runner -> javac com/Recursion/RecursionLvl2.java && java com.Recursion.RecursionLvl2
 */
public class RecursionLvl2 {

    /**
     * This program checks whether an Array is sorted or not.
     * @param arr   The array which needs to be checked.
     * @param idx   The reference index which is used to iterate and check the elements.
     * @return      Boolean result whether an Array is sorted or not.
     */
    public static boolean sortArray(int arr[],int idx){
        if(idx == arr.length-1){
            return true;
        }else if(arr[idx] <= arr[idx+1]){
            return sortArray(arr, idx+1);
        }
        return false;
    }

   /**
    * This method checks whether an key is present in the array or not.
    * @param arr    Array in which we're doing the search.
    * @param key    Element to search for.
    * @param idx    Current index position that's being checked.
    * @return       Boolean value if the element is present or not.
    */
    public static boolean linearRecurSearch(int arr[], int key, int idx) {
    if (idx == arr.length) {
        return false;
    } else if (arr[idx] == key) {
        return true;
    }

    return linearRecurSearch(arr, key, idx + 1);
    }


    /**
     * This method return all the index at which the key was spotted.
     * @param arr    Array in which we're doing the search.
     * @param key    Element to search for.
     * @param idx    Current index position that's being checked.
     * @return       Return the Arraylist containing all the index.
     */
   public static ArrayList<Integer> findAllIndex(int arr[], int key, int idx) {
    ArrayList<Integer> allIndex = new ArrayList<>(); // Declare the ArrayList here

    if (idx == arr.length) {
        return allIndex; // Return the ArrayList when the traversal is complete
    }

    if (arr[idx] == key) {
        allIndex.add(idx);
    }

    // Recursively call the method and combine the results
    allIndex.addAll(findAllIndex(arr, key, idx + 1));
    
    return allIndex; // Return the updated ArrayList
}


    public static void main(String[] args) {
        int arr[] = {1,2,9,4,8,2,3,5};
        if(sortArray(arr, 0))
            System.out.println("Yes, Array is sorted...");
        else
            System.out.println("No, Arrays isn't sorted...");

        
        System.out.println(linearRecurSearch(arr, 2, 0));
        
        
            
    }
}
