package _3_LinkedList;

public class Node<T> {

    private T data;
    private Node<T> next;

    /**
     * parametrised constructor
     * @param data data value held by the node
     * @param next reference to the next node
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /* default constructor */
    public Node(){
        data = null;
        next = null;
    }

    /**
     *
     * @return data of the current node
     */
    public T getData() {
        return data;
    }

    /**
     *
     * @param data value to be assigned
     *             to the current node
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     *
     * @return link to the next node
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     *
     * @param next link to which the current
     *             node shall point
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     *
     * @return string representation of the node
     */
    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
