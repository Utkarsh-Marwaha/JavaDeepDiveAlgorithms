package _5_Queues;

import java.lang.reflect.Array;

public class QueueUsingArray<T> implements Queue<T> {

    // The data stored in the queue will be internally represented by an array of values of type T
    private T[] queue;

    //initial or default size of the queue
    private static final int DEFAULT_SIZE = 10;

    // This represents the total number of elements present in the queue
    private int elements;

    // This represents the index of the front element of the queue
    private int front;

    // This represents the index of the rear element of the queue
    private int rear;

    // This represents the class type of the queue elements
    private Class<T> classType;

    // default size constructor for the queue
    public QueueUsingArray(Class<T> classType) {
        this.classType = classType;
        queue = (T[]) Array.newInstance(classType, DEFAULT_SIZE);
        this.front = this.rear = -1;
        this.elements = 0;
    }

    // custom size constructor for the queue
    public QueueUsingArray(Class<T> classType, int capacity) {
        this.classType = classType;
        queue = (T[]) Array.newInstance(classType, capacity);
        this.front = this.rear = -1;
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
    // This method returns the top most element in the queue
    public T front() throws QueueEmptyException {

        if (isEmpty()){
            // if the queue is empty, we should throw the queue-empty exception
            throw new QueueEmptyException();
        }

        return queue[front];
    }

    @Override
    public void enqueue(T value) {

        // if the capacity of the queue has been exhausted
        if (elements == queue.length){
            throw new IndexOutOfBoundsException();
        }

        // The `front` value is equal to -1 when the queue is empty, for each subsequent additions
        // to the queue, the value of front remains fixated at 0
        if (isEmpty()){
            // i.e. if we are about to add the first element to the queue
            // then front needs to be updated from -1 to 0
            front = 0;
        }

        // this makes our queue circular
        rear = (rear + 1) % queue.length;

//        rear++;
//         This makes our queue circular
//        if (rear == queue.length){
//            rear = 0; // reset the rear index back to 0
//        }

        // insertions in a queue happen at the rear end
        queue[rear] = value;

        // we also need to increment the size of the queue by 1
        elements++;
    }

    @Override
    public T dequeue() throws QueueEmptyException {

        // if the queue is empty to start-off with then we can't delete any further elements from it
        if (isEmpty()){
            // if the queue is empty, we should throw the queue-empty exception
            throw new QueueEmptyException();
        }

        // the deletions in a queue happen from the front end

        // here the front gets updated but the rear remains unchanged
        // store the front element which is going to be removed
        T temp = queue[front];

        // This makes our queue circular
        front = (front + 1) % queue.length; // front will always be between 0 and queue.length - 1

//        front++;
//        This makes our queue circular
//        if (front==queue.length){
//            front = 0; // reset the front back to 0
//        }


        // also decrement the size of the queue by 1
        elements--;

        // if we have deleted the last element of the queue then both front and rear should be reset to -1
        if (isEmpty()){
            front = -1;
            rear = -1;
        }

        return temp;
    }
}
