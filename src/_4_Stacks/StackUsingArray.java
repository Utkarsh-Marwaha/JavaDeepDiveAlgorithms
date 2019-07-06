package _4_Stacks;

import java.lang.reflect.Array;

public class StackUsingArray<T> implements Stack<T> {

    // The data stored in the stack will be internally represented by an array of values of type T
    private T[] stack;

    //initial or default size of the stack
    private static final int DEFAULT_SIZE = 10;

    // This constant decides the factor by which we need to grow our stack in case we exhaust the DEFAULT_SIZE
    private static final int GROWTH_FACTOR = 2;

    // This represents the total number of elements present in the stack
    private int elements;

    // This represents the class type of the stack elements
    private Class<T> classType;

    // default size constructor for the stack
    public StackUsingArray(Class<T> classType) {
        this.classType = classType;
        stack = (T[]) Array.newInstance(classType, DEFAULT_SIZE);
        this.elements = 0;
    }

    // custom size constructor for the stack
    public StackUsingArray(Class<T> classType, int capacity) {
        this.classType = classType;
        stack = (T[]) Array.newInstance(classType, capacity);
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
    // This method returns the top most element in the stack
    public T top() throws StackEmptyException {

        if (isEmpty()){
            // if the stack is empty, we should throw the stack-empty exception
            throw new StackEmptyException();
        }

        return stack[elements-1];
    }

    @Override
    // This method lets us push (add) an element of type T onto the stack
    public void push(T value) {

        // if the stack capacity has been reached then we would have to increase its size first
        if (elements==stack.length){
            // Stack Full
            T[] tmp = (T[]) Array.newInstance(classType, elements*GROWTH_FACTOR);

            // copy over all entries from the exhausted array onto this new one
            System.arraycopy(stack, 0, tmp, 0, stack.length);

            // Then update the stack as this new grown up array
            stack = tmp;
        }

        // insert the given value at the top of the stack
        stack[elements] = value;

        // increment the total number of elements by 1
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

        T temp = stack[elements-1];
        elements--;
        return temp;

    }
}
