package com.Sorting;

/**
 * This class implements the Selection Sort algorithm to sort an array of integers in ascending order.
 */
public class SelectionSort {

    /**
     * Sorts the given array using the Selection Sort algorithm.
     *
     * @param arr The array of integers to be sorted.
     */
    public void selectionSort(int arr[]) {
        int size = arr.length;

        // Iterate through the array elements (except the last one)
        for (int i = 0; i < size - 1; i++) {

            // Phase 1: Find the index of the smallest element in the unsorted part of the array
            int minIdx = i; // Assume the current element is the smallest
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[minIdx]) {         // To do desc sorting, change < to >
                    minIdx = j; 
                }
            }

            // Phase 2: Swap the element at index i with the smallest element
            if (minIdx != i) {
                // Swap elements using XOR without using a temporary variable
                arr[i] = arr[i] ^ arr[minIdx];
                arr[minIdx] = arr[i] ^ arr[minIdx];
                arr[i] = arr[i] ^ arr[minIdx];
            }
        }
    }

    /**
     * Main method to test the SelectionSort class.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        SelectionSort selectionSort = new SelectionSort();

        System.out.println("Original Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        selectionSort.selectionSort(arr);

        System.out.println("\nSorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

