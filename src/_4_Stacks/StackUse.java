package _4_Stacks;

import java.util.Scanner;

public class StackUse {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedStack */

        StackUsingLL<Integer> ls = new StackUsingLL<>();
        /* Perform Stack Operations */

        System.out.println("Linked Stack Test\n");
        char ch;

        do {
            System.out.println("\nLinked Stack Operations");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. peek");
            System.out.println("4. check empty");
            System.out.println("5. size");

            int choice = scan.nextInt();

            switch (choice) {
                case 1 :
                    System.out.println("Enter element to be pushed");
                    ls.push(scan.nextInt());
                    break;

                case 2 :
                    try {
                        System.out.println("Popped Element = "+ ls.pop());
                    }
                    catch (Exception e) {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;

                case 3 :
                    try {
                        System.out.println("Peek Element = "+ ls.top());
                    }
                    catch (Exception e) {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;

                case 4 :
                    System.out.println("Empty status = "+ ls.isEmpty());
                    break;

                case 5 :
                    System.out.println("Size = "+ ls.size());
                    break;

                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);

        } while (ch == 'Y'|| ch == 'y');
    }
}