package com.Sorting;

/**
 * This class implements the Bubble Sort algorithm to sort an array of integers in ascending order.
 */
public class BubbleSort {

    /* Short implementation of same code below without explanations */
    public void cleanCode(int arr[]) {
        int size = arr.length;

        for (int i = 0; i < (size-1); i++) {
            Boolean swapped = false;

            for (int j = 0; j < size-i-1; j++) {
                if(arr[i] > arr[i+1])
                    arr[j] = arr[j] ^ arr[j+1] ^ ( arr[j+1] = arr[j]);
                swapped = true;
            }
            if(!swapped)
                break;
        }
        
    }

    /**
     * Sorts the given array using the Bubble Sort algorithm.
     *
     * @param arr The array of integers to be sorted.
     */
    public void bubbleSort(int arr[]) {
        int size = arr.length;

        // Iterate through the array elements
        /* Total no of elements to swap = (size - 1), as one remaining element will get sorted
         automatically when other (size-1) will get sorted. Thus the first loop only cares 
         about no of elements to compare.
         */
        for (int i = 0; i < size - 1; i++) {        
            boolean swapped = false;

            // Compare and swap adjacent elements to move the largest element to the end
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j+1] ^ ( arr[j+1] = arr[j]);

                    swapped = true;
                }
            }

            // If no two elements were swapped in the inner loop, the array is already sorted
            if (!swapped)
                break;
        }
    }

    /**
     * Main method to test the BubbleSort class.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        BubbleSort bubbleSort = new BubbleSort();

        System.out.println("Original Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        bubbleSort.bubbleSort(arr);

        System.out.println("\nSorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

