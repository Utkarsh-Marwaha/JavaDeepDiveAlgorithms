package _5_Queues;

public interface Queue<T> {

    /**
     *
     * @return true if the queue is empty
     * false otherwise
     */
    boolean isEmpty();

    /**
     *
     * @return number of elements present in the queue
     */
    int size();

    /**
     *
     * @return element at the front of the queue
     */
    T front () throws QueueEmptyException;

    /**
     *
     * @param value value of the element to
     *              be enqueued to the queue
     */
    void enqueue(T value) ;

    /**
     *
     * @return dequeue the front most element from
     * the queue
     */
    T dequeue() throws QueueEmptyException;

}
