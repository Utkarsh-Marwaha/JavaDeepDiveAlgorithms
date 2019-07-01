package _2_Sorting;

import java.util.Arrays;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSort {

    /*Firstly we make a frequency table of the given array elements
     * The size of the this table should be as large as the
     * number of distinct elements in the given data.*/

    /*Next up we traverse through the distinct members in
     * ascending order and overwrite them onto the original
     * array as per their corresponding frequencies read
     * from the Navigable Map*/

    private static int[] countingSort(int [] array){

        // important to use NavigableMap instead of HashMap
        // because in a navigable map the key set is generated in ascending order
        NavigableMap<Integer,Integer> freq_table = new TreeMap<>();

        // iterate through the given array and generate a frequency table
        // the mapping in the tree map would be that of element to frequency
        for (int num:array){
            if (freq_table.containsKey(num)){
                freq_table.put(num,freq_table.get(num)+1);
            } else {
                freq_table.put(num,1);
            }
        }

        int index = 0;

        // go through all the keys of the map
        for (Integer key : freq_table.keySet()){
            // add the key as many times as its frequency suggests
            for (int i = 1; i<= freq_table.get(key); i++){
                array[index++] = key;
            }
        }

        /*
        outer loop will run for (number of distinct members in the input array)
        inner loop will run for (number of times a distinct member appears in the input array)
        let k =  (number of distinct members in the input array)
        let m = (number of times a distinct member 'k' appears in the input array)
        then k * m = N = total number of elements in the input array
        So overall Time complexity O(k*m) = O(N)
        */



        return array;
    }


    /**
     * Time Complexity: O(N)
     * Space Complexity: O(range) where range = max - min + 1
     * @param input the array to be sorted
     */
    private static int[] countSort(int[] input){

        // find the minimum and maximum elements of the input array
        int [] min_max  = getMinMax(input);
        int min = min_max[0], max = min_max[1];

        // create the array for maintaining the counts / frequencies of the elements
        int[] countArray = new int[(max-min)+1];

        // cycle through the input array and count the number of occurences
        for (int num : input){
            countArray[num - min] +=  1;
        }

        // index used to write to the original array
        int index = 0;

        // traverse the range of values
        for (int num : input){
            // pick the frequency of the value from count array
            // till the frequency becomes 0
            while (countArray[num - min] != 0){
                // update element in original array
                input[index++] = num;
                // decrement the frequency by 1
                countArray[num - min]--;
            }
        }

        return input;
    }

    private static int[] getMinMax(int[] array) {

        int min,max;
        min = max = array[0];

        for (int num : array){
            if (num < min){
                min = num;
            }
            if (num > max){
                max = num;
            }
        }

        return new int[]{min, max};
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
        System.out.println(Arrays.toString(countingSort(array)));

        // Displaying the result
        System.out.println(Arrays.toString(countSort(array)));;
    }
}

/*
If sorting algorithms are allowed to make certain assumptions about the input array, then they might be able to
sort the data in fewer resources like linear time complexity and constant amount of auxiliary space.
Counting sort is one such algorithm
1. Unlike bubble, selection or insertion sort, it does not use any comparisons.
2. Instead, it counts the number of occurrences of each value
3. It works only with non-negative discrete values (i.e. positive integers)
4. Values must be within a specific range. The range should be of reasonable size, it can't be huge
The algorithm works in the following manner: -
1. Assume that the values of the array belong to the interval [x, y]
2. Total number of values in the range is y-x+1 so we create a counting array of that length
3. Traverse the input array from left to right. Use the counting array to keep track of how many
    values are in the input array.
4. Using the counts in the sorted array, write the values in sorted order to the input array
Count sort is not an in-place algorithm because we have to create a temporary array to keep track of
the frequencies of each element found in the input array.
If we want the algorithm then we have to do some extra steps.
 */