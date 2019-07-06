package _5_Queues;

import java.util.Scanner;

public class QueueAppArray {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        /* Creating object of class Queue */
        QueueUsingArray<Integer> queueArray = new QueueUsingArray<>(Integer.class);

        /* Perform Queue Operations */
        System.out.println("Queue Test\n");
        char ch;

        do {
            System.out.println("\n Queue Operations");
            System.out.println("1. enqueue");
            System.out.println("2. dequeue");
            System.out.println("3. peek");
            System.out.println("4. check empty");
            System.out.println("5. size");

            int choice = scan.nextInt();

            switch (choice) {
                case 1 :
                    System.out.println("Enter element to be enqueued");
                    queueArray.enqueue(scan.nextInt());
                    break;

                case 2 :
                    try {
                        System.out.println("dequeued Element = "+ queueArray.dequeue());
                    }
                    catch (Exception e) {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;

                case 3 :
                    try {
                        System.out.println("Peek Element = "+ queueArray.front());
                    }
                    catch (Exception e) {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;

                case 4 :
                    System.out.println("Empty status = "+ queueArray.isEmpty());
                    break;

                case 5 :
                    System.out.println("Size = "+ queueArray.size());
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