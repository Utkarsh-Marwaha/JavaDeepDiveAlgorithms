package _2_Sorting;

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

        Scanner in = new Scanner(System.in);
        System.out.println("How many elements are to be sorted?");
        int size = in.nextInt();

        int [] array = new int[size];

        for (int i = 0; i < size; i++){
            System.out.println("Enter element "+(i+1));
            array[i] = in.nextInt();
        }

        System.out.print("The sorted array is: ");
        for (int num: shellSort(array)){
            System.out.print(num+" ");
        }
    }
}
