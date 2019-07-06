package _4_Stacks;

public interface Stack<T> {

    /**
     *
     * @return true if the stack is empty
     * false otherwise
     */
    boolean isEmpty();

    /**
     *
     * @return number of elements present in the stack
     */
    int size();

    /**
     *
     * @return element at the top of the stack
     */
    T top() throws StackEmptyException;

    /**
     *
     * @param value value of the element to
     *              be pushed onto the stack
     */
    void push(T value);

    /**
     *
     * @return pop the top most element from
     * the stack
     */
    T pop() throws StackEmptyException;
}
