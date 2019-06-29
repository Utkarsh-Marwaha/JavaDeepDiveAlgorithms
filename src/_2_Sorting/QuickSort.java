package _2_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

    /**
     * Avg Case Time Complexity: O(N log N)
     * Worst Case Time Complexity: O(N^2)
     * Space Complexity: O(log N) due to the recursive call stack
     *
     * Quick sort is an unstable algorithm because its does not preserve
     * the relative ordering of duplicate items in the resultant array
     *
     * @param input array to be sorted
     */
    private static void quickSort(int[] input) {
        quickSort(input, 0, input.length - 1);
    }


    private static void quickSort(int[] input, int left, int right) {

        if (left>=right){
            return;
        }

        // pick the middle element as the pivot
        int middle = (left+right)/2;
        int pivot  = input[middle];

        // partition the array based on the pivot element
        int pivotIndex = partition(input, left, right, pivot);

        // quick sort the left sub array
        quickSort(input, left, pivotIndex - 1);

        // quick sort the right sub array
        quickSort(input, pivotIndex, right);
    }

    /**
     *
     * @param input array to be sorted
     * @param left start of the sub array
     * @param right end of the sub array
     * @param pivot value of pivot element
     * @return index where the pivot element is placed
     *
     * Space Complexity: O(1)
     */
    private static int partition(int[] input, int left, int right, int pivot) {

        while (left<=right){

            // increment left until you find an element which is greater than the pivot
            while (input[left] < pivot){
                left++;
            }

            // decrement right until you find an element which is lesser than the pivot
            while (input[right] > pivot){
                right--;
            }

            /*
             * After exiting the inner loops we must have found the elements
             * to be swapped or else left and right might have crossed each other
             */
            if (left <= right){

                swap(input, left, right);

                // increment left and decrement right after swapping the elements at those positions
                left++; right--;
            }
        }

        /* After breaking the outer while loop, we would have all elements less than the
          pivot onto its left and all elements greater than the pivot onto its right
          so we can return the point where the partition takes place a.k.a the pivot index */

        return left;
    }

    /**
     *
     * @param input array whose elements have to be swapped
     * @param i index from where element is to be swapped
     * @param j index from where element is to be swapped
     */
    private static void swap(int[] input, int i, int j){
        if (i==j){
            return;
        }
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }



    public static void main(String[] args) {

        // Creating an object of class Scanner
        Scanner in = new Scanner(System.in);

        // Asking the user to enter the size of the array
        System.out.println("Enter the size of the array: ");
        int size = in.nextInt();

        // declaring the array
        int array[] = new int[size];

        // Asking the user to enter the elements of the array
        for (int i = 0; i<array.length; i++){
            System.out.println("Enter element" + (i+1));
            array[i] = in.nextInt();
        }

        // Displaying the result
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }


}

    /*
    Quick sort is an example of a divide and conquer algorithm.
    It uses a pivot element to partition the array into two parts: -
    The elements < pivot to its left and the elements > pivot to its right
    Pivot will then be in its correct sorted position

    We pick a pivot element and then traverse the array from the left as well
    as the right, swapping elements if they are out of order i.e. if the
    elements on the left of the pivot are greater than it and if the elements
    on the right are less than it.

    Quick sort is an in-place algorithm unlike merge which uses temporary arrays
     */
