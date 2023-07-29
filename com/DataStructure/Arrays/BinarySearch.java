package com.DataStructure.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BinarySearch {

    public static int countOccurence(int[] arr, int n, int k) 
    {
        int morethan = n/k;
        HashMap<Integer,Integer> count = new HashMap<>();

        for (int key : arr) {
            if(count.containsKey(key)){
                int val = count.get(key);
                count.replace(key, val+1);
            }else{
                count.put(key, 1);
            }
        }
        
    

        int total = 0;
        for (Entry<Integer, Integer> entry : count.entrySet()) {
            if(entry.getValue() > morethan){
                total++;
            }
        } 
        return total;
        
    }
    public static void main(String[] args) {
        int arr[] = {12,31,2,3,2,2,7,7,7,8,9};
        System.out.println(countOccurence(arr, arr.length, 5));
    }
}
