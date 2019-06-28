package _2_Sorting;

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

        Scanner in = new Scanner(System.in);
        System.out.println("How many elements are to be sorted?");
        int size = in.nextInt();

        int [] array = new int[size];

        for (int i = 0; i < size; i++){
            System.out.println("Enter element "+(i+1));
            array[i] = in.nextInt();
        }

        System.out.print("The sorted array is: ");
        for (int num: optimisedInsertionSort(array)){
            System.out.print(num+" ");
        }


    }
}
