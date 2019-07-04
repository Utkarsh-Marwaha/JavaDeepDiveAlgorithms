package _3_LinkedList;

import java.util.Scanner;

public class App {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        singlyLinkedList list = new singlyLinkedList<Integer>();
        System.out.println("Singly Linked List Test\n");
        char ch;
        /*  Perform list operations  */
        do
        {
            System.out.println("\nSingly Linked List Operations\n");
            System.out.println("1. insert at beginning");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. check empty");
            System.out.println("6. get size");
            System.out.println("7. search for element");

            int choice = scan.nextInt();
            switch (choice)
            {
                case 1 :
                    System.out.println("Enter integer element to insert");
                    list.prepend( scan.nextInt() );
                    break;
                case 2 :
                    System.out.println("Enter integer element to insert");
                    list.append( scan.nextInt() );
                    break;
                case 3 :
                    System.out.println("Enter integer element to insert");
                    int num = scan.nextInt() ;
                    System.out.println("Enter position");
                    int pos = scan.nextInt() ;
                    if (pos < 1 || pos > list.getSize() + 1)
                        System.out.println("Invalid position\n");
                    else
                        list.insertAtPos(num, pos);
                    break;
                case 4 :
                    System.out.println("Enter position");
                    int p = scan.nextInt() ;
                    if (p < 1 || p > list.getSize() )
                        System.out.println("Invalid position\n");
                    else
                        list.deleteNode(p);
                    break;
                case 5 :
                    System.out.println("Empty status = "+ list.isEmpty());
                    break;
                case 6 :
                    System.out.println("Size = "+ list.getSize() +" \n");
                    break;
                case 7 :
                    System.out.println("Enter element to be searched: ");
                    Node<Integer> node = list.search(scan.nextInt());
                    if (node!=null){
                        System.out.println("Element found");
                    } else System.out.println("Element not found");
                    break;
                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /*  Display List  */
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
}
