package com.Sorting;

/* Take intution of cards in your hand which you've to sort according to the strength.  */
public class InsertionSort {

    public void quickRev(int arr[]) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while ( j >= 0 && key < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = key;
        }
    }

    public void insertionSort(int arr[]) {  
        int n = arr.length;
    
        // Considering first element to be already sorted
        for (int i = 1; i < n; i++) {
            // Select the current element as the "key" to be inserted in the sorted part
            int key = arr[i];
            int j = i - 1;
    
            // Compare the "key" with elements in the sorted part of the array and move larger elements one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
    
            // Because of the "j--" the j shifted one index down, so lets first bring it back to desired position and put
            // the key value in it. => so essentially we put the key element at correct position.
            arr[j + 1] = key;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {5,9,4,2,7,3,2,1};
    
        // Create an instance of the class to call the insertionSort method
        InsertionSort sorter = new InsertionSort();
        sorter.quickRev(arr);
    
        // Print the sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    
}
