package _2_Sorting;

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

        Scanner in = new Scanner(System.in);
        System.out.println("How many elements are to be sorted?");
        int size = in.nextInt();

        int [] array = new int[size];

        for (int i = 0; i < size; i++){
            System.out.println("Enter element "+(i+1));
            array[i] = in.nextInt();
        }

        System.out.print("The sorted array is: ");
        for (int num: selectionSort(array)){
            System.out.print(num+" ");
        }


    }
}
