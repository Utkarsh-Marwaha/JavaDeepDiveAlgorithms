package _2_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

    // https://www.youtube.com/watch?v=lCDZ0IprFw4
    private static int[] insertionSort(int[] items){

        for (int i = 1; i < items.length; i++){
            int key = items[i];
            for (int j = i - 1; j>=0; j--){

                if (key < items[j]){
                    swap(items, j, j+1);
                }
            }
        }
        return items;
    }

    /*
     * Instead of swapping sorted elements with the key, keep shifting the elements to
     * the right of the key and then finally place the key in the right position on
     * exiting the while loop.
     */
    private static int[] optimisedInsertionSort(int[] items){

        for (int i = 1; i < items.length; i++){

            int key = items[i];
            int j = i-1;

            /* Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position */
            while (j>=0 && key < items[j]){
                items[j+1] = items[j];
                j--;
            }

            items[j+1] = key;
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
