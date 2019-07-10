package _8_Trees.BinaryTrees;

public class BinaryTree<T> {

    // Node -> Key (data)
    //      -> 2 children (left child, right child)

    private BTNode<Integer> root;

    /* default constructor */
    public BinaryTree(){
        root = null;
    }

    /**
     * method to check if the tree is empty
     * @return true if the tree is empty
     * false otherwise
     */
    public boolean isEmpty(){
        return root == null;
    }

    /*method to add data in tree*/
    public void add(int data){
        root = add(root,data);
    }

    /**
     * helper method to add the given data to the binary tree recursively
     *
     * @param node root of the tree to which we want to add the node
     * @param data value of the node which is to be added to the tree
     * @return root node of the binary tree after adding the new node
     */
    private BTNode<Integer> add(BTNode<Integer> node, int data) {

        if (node == null){
            node = new BTNode(data);
        } else {
            if (node.getRight() == null){
                node.setRight(add(node.getRight(), data));
            } else {
                node.setLeft(add(node.getLeft(), data));
            }
        }
        return node;
    }

    /*method to countNodes the number of nodes in a tree*/
    public int countNodes(){
        return countNodes(root);
    }

    /**
     * method to countNodes the number of nodes in binary tree recursively
     *
     * @param node root of the tree whose nodes have to be counted
     * @return number of nodes present in the tree with the given root
     */
    private int countNodes(BTNode<Integer> node) {

        // if the tree is empty then there are no nodes to countNodes
        if (node == null){
            return 0;
        }

        // countNodes nodes from left subtree + 1 + countNodes nodes from right subtree
        return countNodes(node.getLeft()) + 1 + countNodes(node.getRight());
    }

    /*method to search for a particular element in a binary tree*/
    public boolean searchBT(int value){
        return searchBT(root,value);
    }

    /**
     * method to recursively search a particular element in a binary tree
     * @param node root node of the tree in which we want to search the element
     * @param value data value which we want to search for in the tree
     * @return true if the node with given value is found in the tree
     */
    private boolean searchBT(BTNode<Integer> node, int value){

        /*if the tree is empty then the element cannot be present in it*/
        if (node == null){
            return false;
        } else if (node.getData().equals(value)){
            return true;
        }

        /*return true if given value if found in either the left or right subtree*/
        return searchBT(node.getLeft(), value) || searchBT(node.getRight(), value);
    }

    /*method to find the height of a binary tree*/
    public int height(){
        return height(root);
    }

    /**
     *
     * @param node root node of tree whose height we want to find
     * @return height of the tree with the given root node
     */
    private int height(BTNode<Integer> node) {

        // if the tree is empty then height = 0
        if (node == null){
            return 0;
        }

        // tree_height = 1 + max(left_height, right_height)
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    /*method to find the sum of a binary tree*/
    public int sum(){
        return sum(root);
    }

    /**
     * method to find the sum of a binary tree
     * @param node root node of the tree whose sum we want to find
     * @return sum of the nodes of the tree with the given root node
     */
    private int sum(BTNode<Integer> node) {

        // if the tree is empty then sum = 0
        if (node == null){
            return 0;
        }

        // sum_tree = root_data + sum_left_tree + sum_right_tree
        return node.getData() + sum(node.getLeft()) + sum(node.getRight());
    }

    /*method to find the largest element of the binary tree*/
    public int largest(){
        return largest(root);
    }


    /**
     * method to recursively compute the largest element of a binary tree
     *
     * @param node root node of the tree whose largest element we wish to find
     * @return largest element of the tree with the given root node
     */
    private int largest(BTNode<Integer> node) {

        if (node==null){
            return Integer.MIN_VALUE;
        }

        return Math.max(node.getData(),Math.max(largest(node.getLeft()),largest(node.getRight())));
    }

    /*method to find the smallest element of the binary tree*/
    public int smallest(){
        return smallest(root);
    }


    /**
     * method to recursively compute the smallest element of a binary tree
     *
     * @param node root node of the tree whose smallest element we wish to find
     * @return smallest element of the tree with the given root node
     */
    private int smallest(BTNode<Integer> node) {

        if (node==null){
            return Integer.MAX_VALUE;
        }

        return Math.min(node.getData(),Math.min(smallest(node.getLeft()),smallest(node.getRight())));
    }


    /*method to check if the given binary tree is a binary search tree*/
    public boolean checkIfBST(){
        return checkIfBST(root);
    }

    /*method to recursively check if the given binary tree is a binary search tree*/

    /**
     *
     * @param node root node of the tree which we want to check for being a binary search tree
     * @return true if the tree with the given root node is a binary search tree; false otherwise
     */
    private boolean checkIfBST(BTNode<Integer> node) {

        if (node==null){
            return true;
        }

        int largestLeft = largest(node.getLeft());
        int smallestRight = smallest(node.getRight());

        if (largestLeft>node.getData() || smallestRight<node.getData()){
            return false;
        }
        return checkIfBST(node.getLeft()) && checkIfBST(node.getRight());
    }

    /*The diameter of a tree (sometimes called the width) is the number of
     nodes on the longest path between two leaves in the tree.*/
    public int diameter(){
        return diameter(root);
    }

    /*method to recursively compute the diameter/width of a binary tree*/
    private int diameter(BTNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        /* get the height of left and right sub trees */
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());

        /* get the diameter of left and right subtrees */
        int leftDiameter = diameter(node.getLeft());
        int rightDiameter = diameter(node.getRight());

        /* Return max of following three
          1) Diameter of left subtree
          2) Diameter of right subtree
          3) Height of left subtree + height of right subtree + 1 */
        return Math.max(1 + leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
    }

    /*method for inOrder traversal of the tree*/
    public void inOrder(){
        inOrder(root);
    }

    /*inOrder traversal -> left tree ++ data ++ right tree */
    private void inOrder(BTNode<Integer> node) {

        if (node!=null){

            inOrder(node.getLeft());
            System.out.print(node.getData()+" ");
            inOrder(node.getRight());
        }
    }

    /*method for pre-order traversal of the binary tree*/
    public void preOrder(){
        preOrder(root);
    }

    /*preOrder traversal -> data ++ left tree ++ right tree */
    private void preOrder(BTNode<Integer> node) {

        if (node!=null){

            System.out.print(node.getData()+" ");;
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    /*method for post-order traversal of binary tree*/
    public void postOrder(){
        postOrder(root);
    }

    /*post order traversal -> left tree + right tree + data*/
    private void postOrder(BTNode<Integer> node) {

        if (node!=null){

            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData()+" ");
        }
    }
}
