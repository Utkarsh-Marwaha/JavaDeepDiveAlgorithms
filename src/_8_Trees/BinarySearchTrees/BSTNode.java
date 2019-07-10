package _8_Trees.BinarySearchTrees;

public class BSTNode<T> {

    // Node -> Key (data)
    //      -> 2 children (left child, right child)

    private T data;
    private BSTNode<T> left, right;

    /* default constructor */
    public BSTNode(){
        data = null;
        left = right = null;
    }

    /**
     * parametrised constructor
     * @param data value of the binary tree node
     */
    public BSTNode(T data) {
        this.data = data;
        this.left = this.right = null;
    }

    /**
     * method to get(access) the data of the current binary tree node
     * @return data value of the current binary tree node
     */
    public T getData() {
        return data;
    }

    /**
     * method to set(modify) the data of the current binary tree node
     * @param data value we want to set as the data of the current binary tree node
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * method to get(access) the left subtree of current binary tree node
     * @return left child node of the current binary tree node
     */
    public BSTNode<T> getLeft() {
        return left;
    }

    /**
     *  method to set(modify) the left subtree of current binary tree node
     * @param left node we want to set as the left child of the current binary tree node
     */
    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }

    /**
     * method to get(access) the right subtree of current binary tree node
     * @return right child node of the current binary tree node
     */
    public BSTNode<T> getRight() {
        return right;
    }

    /**
     *  method to set(modify) the right subtree of current binary tree node
     * @param right node we want to set as the right child of the current binary tree node
     */
    public void setRight(BSTNode<T> right) {
        this.right = right;
    }

}
