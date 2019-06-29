package _2_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

    // https://www.youtube.com/watch?v=lCDZ0IprFw4

    /**
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     *
     * Insertion sort is a stable algorithm because its preserves
     * the relative ordering of duplicate items in the resultant array
     *
     * @param input array to be sorted
     * @return the sorted array
     */
    private static int[] insertionSort(int[] input) {

        /*
         * This is the first index of the unsorted partition
         * of the array
         */
        int firstUnsortedIndex = 1;
        // to start-off, the element at index 0 is in the sorted partition

        // traverse the unsorted partition of the array from left to right
        for (int currentUnsorted = firstUnsortedIndex; currentUnsorted < input.length; currentUnsorted++){

            // pick the element to be inserted
            int toBeInserted = input[currentUnsorted];

            // traverse the sorted partition from right to left
            for (int currentSorted = currentUnsorted - 1; currentSorted >=0 ; currentSorted--){

                if (toBeInserted < input[currentSorted]) {

                    // toBeInserted sits at currentSorted + 1
                    swap(input, currentSorted+1, currentSorted);
                }
            }
        }

        return input;
    }

    /*
     * Instead of swapping sorted elements with the key, keep shifting the elements to
     * the right of the key and then finally place the key in the right position on
     * exiting the while loop.
     */
    private static int[] optimisedInsertionSort(int[] items){

        /*
         * This is the first index of the unsorted partition
         * of the array
         */
        int firstUnsortedIndex = 1;
        for (int currentUnsorted = firstUnsortedIndex; currentUnsorted < items.length; currentUnsorted++){


            // pick the element to be inserted
            int toBeInserted = items[currentUnsorted];

            int currentSorted = currentUnsorted-1;

            /* Move elements of arr[0..currentUnsorted-1], that are
            greater than key, to one position ahead
            of their current position */
            while (currentSorted>=0 && toBeInserted < items[currentSorted]){
                items[currentSorted+1] = items[currentSorted];
                currentSorted--;
            }

            items[currentSorted+1] = toBeInserted;
        }

        return items;

    }

    private static void swap(int [] items, int x, int y){
        if (x!=y){
            int temp = items[x];
            items[x] = items[y];
            items[y] = temp;
        }
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
        System.out.println(Arrays.toString(optimisedInsertionSort(array)));
    }
}
