package _5_Queues;

import _3_LinkedList.Node;


public class QueueUsingLL<T> implements Queue<T> {


    // This represents the total number of elements present in the queue
    private int elements;

    // This represents the index of the front element of the queue
    private Node<T> front;

    // This represents the index of the rear element of the queue
    private Node<T> rear;

    // default constructor for the queue
    public QueueUsingLL() {
        this.front = this.rear = null;
        this.elements = 0;
    }

    @Override
    // This method tells us if the queue is empty or not
    public boolean isEmpty() {
        return elements==0;
    }

    @Override
    // This method returns the size of the queue i.e. number of elements present in the queue
    public int size() {
        return elements;
    }

    @Override
    public T front() throws QueueEmptyException {

        if (isEmpty()){
            // if the queue is empty, we should throw the queue-empty exception
            throw new QueueEmptyException();
        }
        return front.getData();
    }

    @Override
    public void enqueue(T value) {

        // firstly, let us create the node which is to be added to the queue
        Node toBeAdded = new Node<>(value, null);

        // both the front and rear would be assigned to the same new element if we're adding to an empty queue
        if (isEmpty()){
            front = rear = toBeAdded;
        }else {
            // otherwise add the new node next to the rear
            rear.setNext(toBeAdded);
            // reassign the rear
            rear = rear.getNext();
        }

        // increment the size of the queue
        elements++;
    }

    @Override
    public T dequeue() throws QueueEmptyException {

        // if the queue is empty to start-off with then we can't delete any further elements from it
        if (isEmpty()){
            // if the queue is empty, we should throw the queue-empty exception
            throw new QueueEmptyException();
        } else {
            // here the front gets updated but the rear remains unchanged
            // store the front element which is going to be removed
            T temp = front.getData();
            front = front.getNext();

            // also decrement the size of the queue by 1
            elements--;

            // if we have deleted the last element of the queue then both front and rear should be reset to -1
            if (isEmpty()){
                front = rear = null;
            }

            return temp;
        }
    }

    /*  Function to display the status of the queue */
    public void display()
    {
        System.out.print("\nQueue = ");
        if (elements == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        Node ptr = front;
        while (ptr != rear.getNext() )
        {
            System.out.print(ptr.getData()+" ");
            ptr = ptr.getNext();
        }
        System.out.println();
    }
}
