package _7_Searching;

import java.util.Scanner;

public class BinarySearch {

    /*The Binary Search algorithm works only when the list of items we are
     * searching through is sorted. The algorithm requires us to divide
     * the list of items into 2 halves (generally by the midpoint) and them compare
     * our given element (which is to be searched) with the midpoint to decide
     * which half of the list of items would possibly contain that element
     * We continue this process of dividing, comparing and refining our search
     * until we are able to exactly locate the element or decide if it is not
     * present in the list at all. This approach is called divide and conquer*/

    /*Time complexity: If we are given a search space of n elements. In just one
     * comparison we can reduce the our search space down to n/2 elements. Subsequently
     * in the following comparisons we would be able to reduce our search space
     * to n/4, n/8, n/16, n/32.. and so on until our search space becomes 1.
     *
     *
     * Total No. of comparisons in worst case
     * = Number of times we can divide the given elements by 2 until we reach 1 element
     * Therefore Time complexity = O(log n) <- base 2 is used
     * */

    public static boolean binarySearchIterative(int array[], int element){

        //initialize the start and end cursors
        int start = 0, end = array.length - 1;

        while (start <= end){

            // divide the list of items into two halves
            int mid = (start+end)/2;

            // Now compare the middle element with the element which is to be searched
            if (element == array[mid]){
                return true; // return true if the element has been found
            } else if (element < array[mid]){
                end = mid - 1; // look for the element in the start half
            } else {
                start = mid+1; // look for the element in the end half
            }
        }
        /* if we reach at the end of the loop and haven't hit any return statement then
           it means we haven't found the element we were searching for, so return false */
        return false;
    }


    public static boolean binarySearchRecursive(int array[], int element){
        return binarySearchRecursive(array,element,0,array.length-1);
    }

    private static boolean binarySearchRecursive(int[] array, int element, int start, int end) {

        if (start > end){
            return false;
        }

        // divide the list of elements into two halves
        int mid = (start+end)/2; // to avoid overflow, we use start + ((end - start)/2);

        // Now compare the element to be searched with the element in the middle of the list
        if (element == array[mid]){
            return true; // return true if the element has been found
        } else if (element < array[mid]){

            // search for the element in the left half of the array
            return binarySearchRecursive(array, element, start, mid-1);
        } else {
            // search for the element in the right half of the array
            return binarySearchRecursive(array, element, mid+1, end);
        }
    }


    public static void main(String[] args) {
        // declaring a new Scanner object
        Scanner in = new Scanner(System.in);

        // Asking the user to enter a new string
        System.out.println("Enter size of array: ");
        int n = in.nextInt();

        //declaring the array
        int[] array = new int[n];

        // Asking the user to enter the array elements
        for (int i = 0; i<n; i++){
            System.out.println("Enter element "+i);
            array[i] = in.nextInt();
        }

        // Asking the user to enter the element to be searched
        System.out.println("Enter the element to be searched: ");
        int element = in.nextInt();

        // Displaying the result using both the methods
        System.out.println(binarySearchRecursive(array,element));
        System.out.println(binarySearchIterative(array,element));
    }
}
