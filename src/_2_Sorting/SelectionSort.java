package _2_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {

    private static int[] selectionSort(int[] items){

        int lastUnsortedIndex = items.length - 1;

        while (lastUnsortedIndex != 0 ){

            int largest = items[0], indexOfLargest = 0, i = 0;

            while (i != lastUnsortedIndex){

                if (items[i+1] > largest){
                    largest = items[i+1];
                    indexOfLargest = i+1;
                }
                i++;
            }
            swap(items, lastUnsortedIndex, indexOfLargest);
            lastUnsortedIndex--;
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
        System.out.println(Arrays.toString(selectionSort(array)));
    }
}
