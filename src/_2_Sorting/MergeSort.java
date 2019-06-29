package _2_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    /**
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     *
     * Merge sort is a stable algorithm because its preserves
     * the relative ordering of duplicate items in the resultant array
     *
     * @param input array to be sorted
     */
    private static void mergeSort(int[] input){
        mergeSort(input, 0, input.length);
    }

    private static void mergeSort(int[] input, int start, int end){

        // if we have received a 1-element array
        if (end - start == 1){
            return;
        }

        // calculate the mid point
        int mid = (start + end) / 2;

        // sort the left partition
        mergeSort(input, 0, mid);
        // sort the right partition
        mergeSort(input, mid, end);

        // merge the left and right partitions
        merge(input, start, mid, end);

    }

    /**
     *
     * @param input array whose partitions are to be merged
     * @param start start of the left array
     * @param mid start of the right array
     * @param end end of the right array
     */
    private static void merge(int[] input, int start, int mid, int end) {

        /*
         * input[mid-1] is the biggest (last) element of the left array and
         * input[mid] is the smallest (first) element of the right array
         *
         * Since we are merging two sorted arrays therefore all the elements
         * in the left array are smaller than all the elements of the
         * right array. We can simply put them together
         */
        if (input[mid-1] <= input[mid]){
            return;
        }

        // index representing the start of the left array
        int i = start;

        // index representing the start of the right array
        int j = mid;

        // this keeps track of the current index in the temporary array
        int tempIndex = 0;

        // create a temporary array of the combined size of left and right arrays
        int[] temp = new int[end-start];

        // mid indicates the end of left array
        // end indicates the end of the right array
        while (i < mid && j < end){
            // temp gets the smaller of the two elements
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        // check which array has been exhausted
        int remS = i < mid ? i : j;
        int remE = i < mid ? mid: end;

        // copy over the remaining elements into the temporary array
        for (int p = remS; p < remE; p++){
            temp[tempIndex++] = input[p];
        }

        // copy over the temp array to the original array
        System.arraycopy(temp, 0, input, start, tempIndex);
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
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}



/*
Merge sort is an example of a divide and conquer algorithm. It is usually implemented recursively.
Merge sort consists of two phases:-
1. Splitting Phase
    The concept of splitting is logical i.e. we do not create new arrays during this process
    In the splitting phase,
    a. We start with the an unsorted array.
    b. Divide the array into 2 arrays, which are unsorted. The first array is the left array, and the
       second array is the right array.
    c. Split the left and the right arrays into two arrays each.
    d. Keep splitting until all arrays have only one element each -- these arrays are sorted.
2. Merging Phase
   In the merging phase,
   a. Merge every left/right pair of sibling arrays into a sorted array.
   b. After the first merge, we'll have a bunch of 2-element sorted arrays.
   c. Then merge those sorted arrays (left/right siblings) to end up with a bunch
      of 4-element sorted arrays.
   d. Repeat until you have a single sorted array.
   e. Not-in place. Uses temporary arrays.
 */