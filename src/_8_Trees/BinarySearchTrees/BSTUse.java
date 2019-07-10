package _8_Trees.BinarySearchTrees;

import java.util.Scanner;

/* Class BinarySearchTree */
public class BSTUse {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        /* Creating object of BST */
        BST bst = new BST<Integer>();

        System.out.println("Binary Search Tree Test\n");

        char ch;

        /*  Perform binary search tree operations  */
        do {

            System.out.println("\nBinary Search Tree Operations\n");
            System.out.println("1.  add a node ");
            System.out.println("2.  delete a node");
            System.out.println("3.  search a node");
            System.out.println("4.  countNodes nodes");
            System.out.println("5.  check empty");
            System.out.println("6.  find height");
            System.out.println("7.  find diameter");
            System.out.println("8.  max element");
            System.out.println("9.  min element");
            System.out.println("10. find sum");

            int choice = scan.nextInt();

            switch (choice) {
                case 1 :
                    System.out.println("Enter integer element to insert");
                    bst.add( scan.nextInt() );
                    break;

                case 2 :
                    System.out.println("Enter integer element to delete");
                    bst.delete( scan.nextInt() );
                    break;

                case 3 :
                    System.out.println("Enter integer element to search");
                    System.out.println("Search result : "+ bst.searchBST( scan.nextInt() ));
                    break;

                case 4 :
                    System.out.println("Nodes = "+ bst.countNodes());
                    break;

                case 5 :
                    System.out.println("Empty status = "+ bst.isEmpty());
                    break;

                case 6 :
                    System.out.println("height = "+ bst.height());
                    break;

                case 7 :
                    System.out.println("diameter = "+ bst.diameter());
                    break;

                case 8 :
                    System.out.println("max element = "+ bst.largest());
                    break;

                case 9 :
                    System.out.println("min element = "+ bst.smallest());
                    break;

                case 10 :
                    System.out.println("sum of tree = "+ bst.sum());
                    break;

                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }

            /*  Display tree  */
            System.out.print("\nPost order : ");
            bst.postOrder();
            System.out.print("\nPre order  : ");
            bst.preOrder();
            System.out.print("\nIn order   : ");
            bst.inOrder();

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().toUpperCase().charAt(0);

        } while (ch == 'Y');
    }
}
