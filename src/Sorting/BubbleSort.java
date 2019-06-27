package Sorting;

import java.util.Scanner;

public class BubbleSort {

    private static int[] bubbleSort(int[] items){


        /*
         *  As the algorithm does its work, it partitions the given array of elements into a
         *  sorted part and an unsorted part. This is a logical partitioning i.e. we don't create
         *  separate array instances to maintain the sorted and unsorted parts of the array
         */


        // unsortedPartitionIndex = This is the last index of the unsorted partition
        int unsortedPartitionIndex = items.length - 1;


        for (int j = 0; j < items.length -1; j++){

            /*
             * In each iteration, we scan elements from the start
             * of the array and compare the adjacent ones to check
             * if they could be swapped.
             */
            int i = 0;
            while (i != unsortedPartitionIndex){
                if (items[i] > items[i+1]){
                    swap(items, i, i+1);
                }
                i++;
            }

            /*
             * After each iteration, the largest element will bubble up to the end of the
             * array, therefore the size of the sorted partition will increase and that of
             * the unsorted partition will decrease.
             */
            unsortedPartitionIndex--;
        }


        return items;
    }

    private static void swap(int[] items, int x, int y) {
        int temp = items[x];
        items[x] = items[y];
        items[y] = temp;
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
        for (int num: bubbleSort(array)){
            System.out.print(num+" ");
        }
    }
}
