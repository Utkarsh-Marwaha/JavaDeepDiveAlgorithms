package Sorting;

import java.util.Scanner;

public class BubbleSort {


    private static int[] bubbleSort(int[] items){


        /*
         *  As the algorithm does its work, it partitions the given array of elements into a
         *  sorted part and an unsorted part. This is a logical partitioning i.e. we don't create
         *  separate array instances to maintain the sorted and unsorted parts of the array
         */


        // lastUnsortedIndex = This is the last index of the unsorted partition
        int lastUnsortedIndex = items.length - 1;

        while (lastUnsortedIndex > 0) {
            /*
             * In each iteration, we scan elements from the start
             * of the array and compare the adjacent ones to check
             * if they could be swapped.
             */
            int i = 0;
            while (i != lastUnsortedIndex){

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
            lastUnsortedIndex--;
        }


        return items;
    }


    /*
     * To optimize our bubble sort algorithm, we can introduce a flag to monitor whether elements are getting swapped
     * inside the inner for loop.
     *
     * Hence, in the inner for loop, we check whether swapping of elements is taking place or not, every time.
     *
     * If for a particular iteration, no swapping took place, it means the array has been sorted and we can jump out of
     * the for loop, instead of executing all the iterations.
     */
    private static int[] optimisedBubbleSort(int[] items){

        // lastUnsortedIndex = This is the last index of the unsorted partition
        int lastUnsortedIndex = items.length - 1;

        while (lastUnsortedIndex > 0){

            /*
             * In each iteration, we scan elements from the start
             * of the array and compare the adjacent ones to check
             * if they could be swapped.
             */

            boolean flag = false;
            int i = 0;
            while (i != lastUnsortedIndex){

                if (items[i] > items[i+1]){

                    swap(items, i, i+1);
                    flag = true;
                }
                i++;
            }

            if (!flag){
                break;
            }

            /*
             * After each iteration, the largest element will bubble up to the end of the
             * array, therefore the size of the sorted partition will increase and that of
             * the unsorted partition will decrease.
             */
            lastUnsortedIndex--;
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
        for (int num: optimisedBubbleSort(array)){
            System.out.print(num+" ");
        }


    }
}
