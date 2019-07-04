package _3_LinkedList;

public class singlyLinkedList<T> {

    private Node<T> head, tail;
    private int size;

    /**
     * default constructor
     */
    public singlyLinkedList(){
        head = tail = null;
        size = 0;
    }

    /**
     *
     * @return true if linked list is empty
     * false otherwise
     */
    public boolean isEmpty(){
        /*If the head of the linked list is null then the list is empty*/
        return head == null;
    }

    /**
     *
     * @return number of elements in the linked list
     */
    public int getSize() {
        return size;
    }

    /**
     * method to add a node at the end of the linked list
     * @param value data value of the node to be appended
     *              to the linked list
     */
    public void append(T value){

        // firstly, we create the node which is to be appended to the linked list
        Node<T> toBeAdded = new Node<>(value, null);

        // Scenario 1: If the linked list is empty
        if (isEmpty()){

            /* An empty list means that both head and tail are null,
             * accessing their next will result in null pointer exception
             * Thus, The resultant list should be just the toBeAdded
             */
            head = tail = toBeAdded;
        }
        else {

            // Scenario 2: If the linked list is non empty

            /* Let the non-empty linked list be [Node (15) -> Node (16)]
             we wish to append (10). Before appending the element
             head = Node (15), tail = Node (16) and tail.next = null

             Our resultant linked list will look like [Node (15) -> Node (16) -> Node (10)]
             where in head = Node (15) and tail = Node (10) and tail.next = null
             */

            /* we set (tail.next = toBeAdded) so tail.next goes from (null) to (toBeAdded)
            In other words Node (16), which is our current tail is now pointing towards Node (10)
            */

            tail.setNext(toBeAdded);

            /* Now having linked Node (16) to Node (10)
               we set tail = toBeAdded so tail goes from Node(16) to Node(10)
             */
            tail = toBeAdded; // current tail becomes Node (10)

            // tail's next node is set to null
            tail.setNext(null);
        }

        // increment the size of the linked list
        size++;
    }

    /**
     * method to check if the specified node is present in the linked list
     * @param data value to be searched within the linked list
     * @return node whose data value matches the given value
     */
    public Node<T> search (T data){

        // Scenario 1: The linked list is empty
        if (isEmpty()){
            return null;
        }

        // Scenario 2: The linked list is non empty

        // assign node as the iterator
        Node<T> temp = head; // initialization

        // iterate through the linked list
        while (temp.getNext()!=null){

            if (temp.getData() == data){
                return temp; // node found
            }

            temp = temp.getNext(); // update statement
        }

        // After we exit the while loop, temp = last element of the linked list
        return (temp.getData() == data ? temp : null);
    }



    /**
     * method to add a node at the front of the linked list
     * @param value data value of the node to be prepended
     *              to the linked list
     */
    public void prepend(T value){

        // firstly, we create the node which is to be prepended to the linked list
        Node<T> toBeAdded = new Node<>(value, null);

        // Scenario 1: The linked list we are prepending to is empty
        if (isEmpty()){
            head = tail = toBeAdded;
        }

        else {
            // Scenario 2: The linked list we are inserting to is non-empty

            /* the new node starts pointing to the current head (which by the way
            is pointing to the first node of the linked list) */
            toBeAdded.setNext(head);

            /* Having established a link from the new node to the old head of our linked list
            we need to change the current head of linked list so that it refers to new node */
            head = toBeAdded;
        }

        // increment the size of the linked list
        size++;
    }

    /*  Function to display elements  */
    public void display() {

        System.out.print("\nSingly Linked List = ");

        if (size == 0) {
            System.out.print("empty\n");
            return;
        }

        if (head.getNext() == null) {
            System.out.println(head.getData() );
            return;
        }

        Node ptr = head;
        System.out.print(head.getData()+ " -> ");
        ptr = head.getNext();
        while (ptr.getNext() != null) {
            System.out.print(ptr.getData()+ " -> ");
            ptr = ptr.getNext();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}
