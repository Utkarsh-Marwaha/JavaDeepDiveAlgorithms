package _2_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {

    private static int[] radixSort(int[] input, int radix, int width){

        for (int position = 0; position < width; position++){
            radixSingleSort(input, position, radix);
        }

        return input;
    }

    private static void radixSingleSort(int[] input, int position, int radix) {

        int[] countArray = new int[radix];

        for (int value : input){
            countArray[getDigit(position, value, radix)]++;
        }

        /*Next, we’ll cumulatively add up the values in the populated countNodes array,
          building it up as we go along.
         */
        for (int j = 1; j < countArray.length; j++){
            countArray[j] += countArray[j-1];
        }

        /*Then, we’ll shift over all the elements in the array by incrementing
          the index of each value by one.*/
        System.arraycopy(countArray, 0, countArray, 1, countArray.length-1);
        countArray[0] = 0;

        // create the resultant array which will hold the sorted integers
        int[] result = new int[input.length];

        /*Finally, we’ll create a new sorted array, which will be the same length as our original array.
          We’ll iterate over our original array, and translate the values over to our new array by using
          our countNodes array, incrementing our countNodes array value as we continue to sort. In this step, we’re
          effectively using a version of a hashing function, and using our countNodes array as a way to translate
          values from the unsorted array into the new, sorted one.*/
        for (int num: input){

            int frequency =  countArray[getDigit(position, num, radix)];
            result[frequency] = num;
            countArray[getDigit(position, num, radix)]++;
        }

        System.arraycopy(result, 0, input, 0, result.length);
    }

    private static int getDigit(int position, int num, int radix) {
        return (num / (int) Math.pow(10, position)) % radix;
    }


    public static void main(String[] args) {

        // Creating an object of class Scanner
        Scanner in = new Scanner(System.in);

        // Asking the user to enter the size of the array
        System.out.println("Enter the size of the array: ");
        int size = in.nextInt();

        // declaring the array
        int [] array = new int[size];

        // Asking the user to enter the elements of the array
        for (int i = 0; i<array.length; i++){
            System.out.println("Enter element" + (i+1));
            array[i] = in.nextInt();
        }

        // Displaying the result
        System.out.println(Arrays.toString(radixSort(array, 10,
                (int) Math.pow(10,Math.floor(Math.log10(Math.abs(array[0])))))));
    }
}

/*
 * If sorting algorithms are allowed to make certain assumptions about the input array, then they might be able to
 * sort the data in fewer resources like linear time complexity and constant amount of auxiliary space.
 * Radix sort is one such algorithm: -
 *
 * 1. Unlike bubble, selection or insertion sort, it does not use any comparisons.
 *
 * 2. It assumes that all the elements must have the same radix (base) and width because of which the data
 *    can either be integers or strings.
 *
 * 3. In radix sort, we sort based on each individual digit or letter position.
 *
 * 4. We start at the rightmost position and use a stable sort technique at each stage while moving towards left.
 */
