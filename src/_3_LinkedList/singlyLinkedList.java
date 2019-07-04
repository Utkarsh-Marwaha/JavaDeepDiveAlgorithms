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
     * method to add a new node at kth position of our linked list
     * @param data data value of the node to be inserted
     *             in the linked list
     * @param pos position at which the node is to be
     *            inserted within the linked list
     */
    public void insertAtPos(T data, int pos){

        // firstly, we create the node which is to be added to the linked list
        Node<T> toBeAdded = new Node<>(data, null);

        /*trying to access an illegitimate position which cannot exist at all*/
        if (pos <1 || pos>size+1){
            return;
        }

        /*if we want to add the new node at the head of the linked list*/
        else if (pos==1){
            prepend(data);
        }

        /*If we want to add the new node at the end of the linked list*/
        else if (pos==size+1){
            append(data);
        }

        else {
            /*To insert the new node at the specified (legitimate) position*/
            /*We need to traverse till the (position - 1)th node */

            Node<T> prev = head; // initialization

            // counter to keep track of the number of nodes traversed
            int count = 1; // =1 because the first node is already traversed by the previous node

            while (count < pos - 1){
                // keep moving till we reach the node just before kth position
                prev = prev.getNext();
                count++;
            }

            /*The while loop breaks out when we reach a node just previous to the one at kth position
             * Therefore, the kth node of our original linked list will be given by prev.getNext()*/
            Node<T> kthNode = prev.getNext();

            /*Our main objective is to add the new node between
             prev i.e. [(k-1)th Node] and the kthNode */

            // new node starts pointing kth node of original list
            toBeAdded.setNext(kthNode);
            // (k-1)th node of original list starts pointing this new node
            prev.setNext(toBeAdded);

            size++;
        }

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

    /**
     * method to delete a node from a given position in a linked list
     * @param pos position (1 to size) from where the node is to be deleted
     */
    public void deleteNode(int pos){

        if (isEmpty()){
            return; // cannot delete element from empty list
        }
        /*If the user wants to delete the only node of a singleton list */
        else if (pos == 1 && size == 1){
            head = tail = null;
            size--;
        }

        /*If the user wants to delete the head of the linked list*/
        else if (pos==1) {
            // Our new head starts referring to the next Node in the linked list
            head = head.getNext();
            size--; // decrementing the size of the linked list after deleting the head
        }
        /*If the user wants to delete the tail of the linked list*/
        else if (pos == size){

            // iterator through the linked list
            Node<T> node = head;

            // we keep track of the previous node
            Node<T> prev = head;

            while (node!=tail){
                prev = node;
                node = node.getNext();
            }

            // our new tail is the node previously pointing to our old tail
            tail = prev;
            // our new tail should further be pointing towards null to indicate the end of the tail
            tail.setNext(null);

            // decrement the number of elements in the linked list
            size--;
        } else {

            Node<T> ptr = head;
            for (int i = 1; i < size - 1; i++) {

                // stop at one position prior to the node which is to be deleted
                if (i == pos - 1) {
                    // ptr is the left neighbour of the node which is to be deleted

                    // tmp is the right neighbour of the node which is to be deleted
                    Node<T> tmp = ptr.getNext().getNext();

                    ptr.setNext(tmp); // basically we jump the node to be deleted by connecting its neighbours directly.
                    break;
                }

                ptr = ptr.getNext();
            }

            // decrement the number of elements in the linked list
            size-- ;
        }

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
