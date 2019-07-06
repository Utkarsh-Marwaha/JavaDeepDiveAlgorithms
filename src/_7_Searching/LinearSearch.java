package _7_Searching;

import java.util.Scanner;

public class LinearSearch {

    private static boolean linearSearchIterative(int[] array, int element) {

        for (int num : array){
            if (num==element){
                return true;
            }
        }
        return false;
    }

    private static boolean linearSearchRecursive(int[] array, int element) {

        return linearSearchRecursive(array, 0, element);
    }

    private static boolean linearSearchRecursive(int[] array, int index, int element) {

        if (index == array.length){
            return false;
        }

        if (array[index] == element){
            return true;
        }

        return linearSearchRecursive(array, index+1, element);

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
        System.out.println(linearSearchIterative(array,element));
        System.out.println(linearSearchRecursive(array,element));
    }


}
