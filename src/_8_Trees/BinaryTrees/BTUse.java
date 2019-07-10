package _8_Trees.BinaryTrees;
import java.util.Scanner;

public class BTUse {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        /* Creating object of Binary Tree */
        BinaryTree bt = new BinaryTree<Integer>();

        /*  Perform tree operations  */
        System.out.println("Binary Tree Test\n");
        char ch;

        do {
            System.out.println("\nBinary Tree Operations\n");
            System.out.println("1. insert "); // delete, mirror, sum tree, path, LCA
            System.out.println("2. search");  // proceed to BST
            System.out.println("3. countNodes nodes");
            System.out.println("4. check empty");
            System.out.println("5. find height");
            System.out.println("6. find sum");
            System.out.println("7. largest elem");
            System.out.println("8. smallest elem");
            System.out.println("9. check if BST");

            int choice = scan.nextInt();

            switch (choice) {
                case 1 :
                    System.out.println("Enter data to be added");
                    bt.add( scan.nextInt() );
                    break;

                case 2 :
                    System.out.println("Enter value to be searched");
                    System.out.println("Search result : "+ bt.searchBT( scan.nextInt() ));
                    break;

                case 3 :
                    System.out.println("Nodes = "+ bt.countNodes());
                    break;

                case 4 :
                    System.out.println("Empty status = "+ bt.isEmpty());
                    break;

                case 5 :
                    System.out.println("Height of the tree = " + bt.height());
                    break;

                case 6:
                    System.out.println("Sum of tree elements = " + bt.sum());
                    break;

                case 7:
                    System.out.println("Largest element = "+bt.largest());
                    break;

                case 8:
                    System.out.println("Smallest element = "+bt.smallest());
                    break;

                case 9:
                    System.out.println("check if BST = "+bt.checkIfBST());
                    break;

                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }

            /*  Display tree  */
            System.out.print("\nPost order : ");
            bt.postOrder();
            System.out.print("\nPre  order : ");
            bt.preOrder();
            System.out.print("\nIn   order : ");
            bt.inOrder();

            System.out.println("\n\nDo you want to continue (Type y or n) \n");
            ch = scan.next().toUpperCase().charAt(0);
        } while (ch == 'Y');
    }
}