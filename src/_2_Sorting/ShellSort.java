package _2_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class ShellSort {

    private static int[] shellSort(int[] items){
        return shellSort(items, items.length/2);
    }

//    https://www.youtube.com/watch?v=ddeLSDsYVp8
//    https://www.programering.com/a/MjN4EjMwATY.html
    private static int[] shellSort(int[] items, int step) {

        if (step == 0){
            return items;
        }

        for (int i = step; i <items.length; i++) {
            int key = items[i];
            int j = i - step;

            // use insert sort to sort the part of items;
            while (j >=0 && key < items[j]){
                items[j + step] = items[j];
                j-=step;
            }

            items[j + step] = key;
        }
        //narrow the increment.
        return shellSort(items, step/2);

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
        System.out.println(Arrays.toString(shellSort(array)));
    }
}
