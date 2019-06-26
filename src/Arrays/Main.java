package Arrays;

public class Main {

    public static void main(String[] args) {

        // Create an array of integers (size 7)
        int [] array = new int[7];

        // Here we assign values to all the indices of the array
        array[0] = 20;

        array[1] = 35;

        array[2] = -15;

        array[3] = 7;

        array[4] = 55;

        array[5] = 1;

        array[6] = -22;

        // Printing the contents of the array using a for loop
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
    }

}
