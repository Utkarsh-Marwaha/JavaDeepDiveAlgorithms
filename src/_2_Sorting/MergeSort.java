package _2_Sorting;

import java.util.Scanner;

public class MergeSort {

    // Merges two sub arrays of items[].
    // First subarray is items[left..middle]
    // Second subarray is items[middle+1..right]

    private static void merge(int [] items, int left, int middle, int right) {

        // Find sizes of two sub arrays to be merged
        int sizeLeft = middle - left + 1;
        int sizeRight = right - middle;

        /* Create temp arrays */
        int [] leftArray = new int [sizeLeft];
        int [] rightArray = new int [sizeRight];

        /*Copy data to temp arrays*/
        System.arraycopy(items,left, leftArray, 0, sizeLeft);
        System.arraycopy(items,middle+1, rightArray, 0, sizeRight);


        /* Merge the temp arrays */

        // Initial indexes of first and second sub arrays
        int i = 0, j = 0;

        // Initial index of merged sub array array
        int k = left;

        while (i < sizeLeft && j < sizeRight) {

            if (leftArray[i] <= rightArray[j]) {
                items[k] = leftArray[i];
                i++;
            }
            else {
                items[k] = rightArray[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of leftArray[] if any */
        while (i < sizeLeft) {
            items[k] = leftArray[i];
            i++;
            k++;
        }

        /* Copy remaining elements of rightArray[] if any */
        while (j < sizeRight) {
            items[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Main function that sorts items[left..right] using
    // merge()
    private static void sort(int [] items, int left, int right) {

        if (left < right) {
            // Find the middle point
            int middle = (left+right)/2;

            // Sort first and second halves
            sort(items, left, middle);
            sort(items , middle+1, right);

            // Merge the sorted halves
            merge(items, left, middle, right);
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("How many elements are to be sorted?");
        int size = in.nextInt();

        int [] array = new int[size];

        for (int i = 0; i < size; i++){
            System.out.println("Enter element "+(i+1));
            array[i] = in.nextInt();
        }

        sort(array, 0, array.length-1);
        System.out.print("The sorted array is: ");
        for (int num: array){
            System.out.print(num+" ");
        }
    }
}
