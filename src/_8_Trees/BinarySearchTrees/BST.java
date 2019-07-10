package _8_Trees.BinarySearchTrees;


public class BST<T> {

    // Node -> Key (data)
    //      -> 2 children (left child, right child)

    private BSTNode<Integer> root;

    /* default constructor */
    public BST(){
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
     * helper method to add the given data to the binary search tree recursively
     *
     * @param node root of the tree to which we want to add the node
     * @param data value of the node which is to be added to the tree
     * @return root node of the binary search tree after adding the new node
     */
    private BSTNode<Integer> add(BSTNode<Integer> node, int data) {

        // if the tree is empty then create a new node and set it as root
        if (node == null){
            node = new BSTNode(data);
        } else {
            /*If the value to be added is less than root value then it has to inserted in the left subtree*/
            if (data <= node.getData())
                node.setLeft(add(node.getLeft(),data));
            else
                /*if the value to be added is greater than the root value then it has to be inserted in the right subtree*/
                node.setRight(add(node.getRight(),data));
        }
        /*if the value == root.data then it is already present in the tree so we simply return the tree*/
        return node;
    }

    /*method to countNodes the number of nodes in a tree*/
    public int countNodes(){
        return countNodes(root);
    }

    /**
     * method to countNodes the number of nodes in binary search tree recursively
     *
     * @param node root of the tree whose nodes have to be counted
     * @return number of nodes present in the tree with the given root
     */
    private int countNodes(BSTNode<Integer> node) {

        // if the tree is empty then there are no nodes to countNodes
        if (node == null){
            return 0;
        }

        // countNodes nodes from left subtree + 1 + countNodes nodes from right subtree
        return countNodes(node.getLeft()) + 1 + countNodes(node.getRight());
    }

    /*method to search for a particular element in a binary tree*/
    public boolean searchBST(int value){
        return searchBST(root,value);
    }

    /**
     * method to recursively search a particular element in a binary search tree
     * @param node root node of the tree in which we want to search the element
     * @param value data value which we want to search for in the tree
     * @return true if the node with given value is found in the tree
     */
    private boolean searchBST(BSTNode<Integer> node, int value){

        if (node == null) {
            /*Element can't be looked up in an empty tree*/
            return false;
        }
        /*if the value we are searching for is less than a node's data then we search the left subtree*/
        if (value < node.getData()) {
            return searchBST(node.getLeft(), value);
        }
        /*if the value we are searching for is greater than a node's data then we search the right subtree*/
        else if (value > node.getData()) {
            return searchBST(node.getRight(), value);
        }
        /*return true is the value is equal to the node's data*/
        return true;
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
    private int height(BSTNode<Integer> node) {

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
     * method to find the sum of a binary search tree
     * @param node root node of the tree whose sum we want to find
     * @return sum of the nodes of the tree with the given root node
     */
    private int sum(BSTNode<Integer> node) {

        // if the tree is empty then sum = 0
        if (node == null) {
            return 0;
        }

        // sum_tree = root_data + sum_left_tree + sum_right_tree
        return node.getData() + sum(node.getLeft()) + sum(node.getRight());
    }

    /*method to find the largest element of a binary search tree*/
    public int largest(){
        return largest(root);
    }

    /*
     * method to recursively compute the largest element of a binary search tree
     *
     * @param node root node of the tree whose largest element we wish to find
     * @return largest element of the tree with the given root node
     */
    private int largest(BSTNode<Integer> node) {

        if (node == null){
            return Integer.MIN_VALUE;
        }

        // the largest element in a binary search tree is the right most element
        return Math.max(node.getData(),largest(node.getRight()));
    }

    /*method to find the largest element of a binary search tree*/
    public int smallest(){
        return smallest(root);
    }

    /*
     * method to recursively compute the smallest element of a binary search tree
     *
     * @param node root node of the tree whose smallest element we wish to find
     * @return smallest element of the tree with the given root node
     */
    private int smallest(BSTNode<Integer> node) {

        if (node == null){
            return Integer.MAX_VALUE;
        }

        // the smallest element in a binary search tree is the left most element
        return Math.min(node.getData(),largest(node.getLeft()));
    }


    /*The diameter of a tree (sometimes called the width) is the number of
     nodes on the longest path between two leaves in the tree.*/
    public int diameter(){
        return diameter(root);
    }

    /*method to recursively compute the diameter/width of a binary search tree*/
    private int diameter(BSTNode<Integer> node) {

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

    /*method for inOrder traversal of the binary search tree*/
    public void inOrder(){
        inOrder(root);
    }

    /*inOrder traversal -> left tree ++ data ++ right tree */
    private void inOrder(BSTNode<Integer> node) {

        if (node!=null){

            inOrder(node.getLeft());
            System.out.print(node.getData()+" ");
            inOrder(node.getRight());
        }
    }

    /*method for pre-order traversal of the binary search tree*/
    public void preOrder(){
        preOrder(root);
    }

    /*preOrder traversal -> data ++ left tree ++ right tree */
    private void preOrder(BSTNode<Integer> node) {

        if (node!=null){

            System.out.print(node.getData()+" ");;
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    /*method for post-order traversal of binary search tree*/
    public void postOrder(){
        postOrder(root);
    }

    /*post order traversal -> left tree + right tree + data*/
    private void postOrder(BSTNode<Integer> node) {

        if (node!=null){

            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData()+" ");
        }
    }
    /*method to delete a particular value from the binary search tree*/
    public void delete(int value){

        root = delete(root,value);
    }

    private BSTNode<Integer> delete(BSTNode<Integer> node, int value) {

        if (node==null){
            /*cannot delete from empty tree*/
            return null;
        }

        if (!searchBST(value)){
            /*if the element is not present in the binary search tree then it can't be deleted*/
            return node;
        } else { // the element to be deleted is definitely present in the given non-empty tree

            /*Given that the element to be deleted is present in the tree we first need to traverse the tree and reach that element*/

            /*if the value to be deleted is less than the node's data then we will try to delete it from the left subtree*/
            if (value<node.getData()){
                node.setLeft(delete(node.getLeft(),value));
            }
            /*If the value to be deleted is greater than the node's data then we will try to delete it from the right subtree*/
            else if (value>node.getData()){
                node.setRight(delete(node.getRight(),value));
            } else {

                /*We reach here when we have found the element to be deleted*/
                /*Having found the element to be deleted, we now have to tackle three possibilities
                 *
                 * 1. The element has no child
                 * 2. The element has only one child
                 * 3. The element has two children
                 * */

                /*1. The element has no child*/
                if (node.getLeft()==null && node.getRight()==null){
                    return null;
                }
                /*2. The element has only one child*/
                else if (node.getLeft()==null){
                    return node.getRight();
                } else if (node.getRight()==null){
                    return node.getLeft();
                }
                /*3. The element has two children*/
                else{
                    /*firstly, we need to find the in order successor of the element to be deleted*/
                    BSTNode<Integer> inOrderSuccessor = getInOrderSuccessor(node);
                    node.setData(inOrderSuccessor.getData()); // setting the node's data equal to its inorder successor's data

                    /*Having copied the value of the in order successor on to the node to be deleted, we now have
                     * to get rid of the in order successor from the actual tree because BST can't have duplicates*/
                    node.setRight(delete(node.getRight(),inOrderSuccessor.getData()));
                    /*Since the in order successor lies in the right subtree of the node to be deleted therefore we
                     * have to modify this right subtree*/
                    return node;
                }
            }
        }
        return node;
    }


    /*method to find the in order successor of a particular node in a binary search tree*/

    private BSTNode<Integer> getInOrderSuccessor(BSTNode<Integer> node) {

        /*in order successor is the smallest element is the right subtree of a node*/
        if (node==null){
            return null;
        }
        BSTNode<Integer> successor = node.getRight();
        while (successor.getLeft()!=null){
            successor = successor.getLeft();
        }
        return successor;
    }
}


