package _4_Stacks;

import _3_LinkedList.Node;

public class StackUsingLL<T> implements Stack<T> {

    // The stack is internally represented by a linked list of generic type T
    private Node<T> stack;

    // This represents the total number of elements in the linked list
    private int elements;

    /* default constructor */
    public StackUsingLL(){
        stack = new Node<>();
        this.elements = 0;
    }

    @Override
    // This method tells us if the stack is empty or not
    public boolean isEmpty() {
        return elements==0;
    }

    @Override
    // This method returns the size of the stack i.e. number of elements present in the stack
    public int size() {
        return elements;
    }
    @Override
    public T top() throws StackEmptyException {
        if (isEmpty()){
            // if the stack is empty, we should throw the stack-empty exception
            throw new StackEmptyException();
        }

        return stack.getData();
    }

    @Override
    // This method lets us push (add) an element of type T onto the stack
    public void push(T value) {

        // firstly, let us create the node which is to be pushed to the stack
        Node<T> toBeAdded = new Node<>(value, null);

        // before destroying or overwriting any link, let us create one
        toBeAdded.setNext(stack);

        // now we have to update the head of the stack to point to this newly added node
        stack = toBeAdded;

        // increment the number of elements present in the stack
        elements++;
    }

    @Override
    // This method helps us to pop (delete) an element of type T from the top of the stack
    // It also returns the element that has been removed from the top of the array
    public T pop() throws StackEmptyException {

        if (isEmpty()){
            // if the stack is empty, we should throw the stack-empty exception
            throw new StackEmptyException();
        }

        T temp = stack.getData();
        stack = stack.getNext();

        // decrement the size of the stack
        elements--;
        return temp;
    }
}
