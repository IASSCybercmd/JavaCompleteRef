package com.DataStructure.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem statement: Given an unsorted array Arr of N positive and negative numbers.
 * Your task is to create an array of alternate positive and negative numbers
 * without changing the relative order of positive and negative numbers.
 * Note: Array should start with a positive number and 0 (zero) should be
 * considered a positive element.
 * 
 * @author Priyanshu Raj
 */
public class RearrangePosNegNum {
    /**
     * This method rearranges the array elements in Positive and Negative elements maintaining the sequence.
     * @param arr   The array to be rearranged.
     * @param N     Arrays element value is between 1(min) to N(max).
     */
    public static void rearrange(int arr[],int N){
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int val : arr) {
            if(val < 0)
                neg.add(val);
            else
                pos.add(val);

        }

        int posSize = pos.size();
        int negSize = neg.size();
        int minSize = Math.min(posSize, negSize);

        for (int i = 0; i < minSize ; i++) {
            arr[2*i] = pos.get(i);
            arr[2*i+1] = neg.get(i);
        }

        if(posSize < negSize){
            int index = posSize*2;
            for (int i = posSize; i < negSize; i++) {
                arr[index] = neg.get(i);
                index++;
            }
        } else {
            int index = negSize * 2;
            for (int i = negSize; i < posSize; i++) {
                arr[index] = pos.get(i);
                index++;
            }
        }
            
    }

    public static void main(String[] args) {
        int arr[] = {9, 4, -2, -1, 5, 0, -5, -3, 2};
        System.out.println("Array before rearrangement : " + Arrays.toString(arr));
        rearrange(arr, arr.length+1);
        System.out.println("Array after rearrangement : " + Arrays.toString(arr));
    }
}