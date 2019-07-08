package _6_HashTables.Chaining;

import _6_HashTables.LinearProbing.Employee;
import _6_HashTables.LinearProbing.StoredEmployee;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHT {

    /* instead of storing the values directly in the array,
       each array index contains a linked list.
     */
    private LinkedList<StoredEmployee>[] hashTable;


    public ChainedHT(int capacity){

        hashTable = new LinkedList[capacity];

        for (int i = 0; i < hashTable.length; i++){
            hashTable[i] = new LinkedList<>();
        }
    }

    /**
     *
     * @param key last name of the employee
     * @return corresponding hash value of the key
     */
    private int hashKey(String key) {
        return key.length() % hashTable.length;
    }

    /**
     *
     * @param key last name of the employee whose record we want to the hashtable
     * @param employee employee whose record we want to add to the hashtable
     */
    public void put(String key, Employee employee){

        // find the hash value corresponding to the given key
        int hashedKey = hashKey(key);

        // use to the hash value of the key to find the index where the employee has to be added
        // and then add the employee object to the linked list present at the respective index
        hashTable[hashedKey].add(new StoredEmployee(key, employee));

    }

    /**
     *
     * @param key last name of the employee we want to retrieve
     * @return employee corresponding to the given key
     */
    public Employee get(String key){

        // find the index in whose corresponding linked list, the given key might have been hashed
        int hashedKey = hashKey(key);

        // create an iterator for the linked list present at the index given by the hash function
        ListIterator<StoredEmployee> iterator = hashTable[hashedKey].listIterator();

        StoredEmployee employee;

        // iterate through the linked list present at the index given by the hash function
        while (iterator.hasNext()){
            employee = iterator.next();

            // if the given key matches with any employee object's key (within the chain -> linked list)
            if (employee.getKey().equals(key)){
                // employee found
                return employee.getEmployee();
            }
        }

        // no key matched ; return null
        return null;
    }


    /**
     * \
     * @param key last name of the employee which is to be removed from the hashtable
     * @return record of the employee who is to be removed from the hashtable
     */
    public Employee remove(String key){

        // find the index in whose corresponding linked list, the given key might have been hashed
        int hashedKey = hashKey(key);

        // create an iterator for the linked list present at the index given by the hash function
        ListIterator<StoredEmployee> iterator = hashTable[hashedKey].listIterator();

        StoredEmployee employee = null;

        // iterate through the linked list present at the index given by the hash function
        while (iterator.hasNext()){
            employee = iterator.next();

            // if the given key matches with any employee object's key (within the chain -> linked list)
            if (employee.getKey().equals(key)){

                // employee found
                break;
            }
        }

        /* employee will be null if we never entered the above iterator i.e when the hashtable has 0 elements
           employee.getKey() will not be equal to the given key when we have exhausted all elements of the hash
           table without finding a match */
        if (employee==null || !employee.getKey().equals(key)){
            return null;
        } else {
            // employee was found by matching the key i.e. the we broke out of the above while loop

            // remove the employee from the linked list
            hashTable[hashedKey].remove(employee);

            // return the employee which has been removed from the hash table
            return employee.getEmployee();
        }
    }

    public void printHashTable(){

        // cycle through all the indices of the hashtable
        for (int i = 0; i < hashTable.length; i++){

            // if the linked list corresponding to any index is empty then simply print empty
            if (hashTable[i].isEmpty()){
                System.out.println("Position "+ i +": empty");
            } else {

                // print the index
                System.out.println("Position "+ i +": ");

                // iterate through the linked list corresponding to the index
                ListIterator<StoredEmployee> iterator = hashTable[i].listIterator();

                while (iterator.hasNext()){

                    // print out employee objects in the linked list
                    System.out.println(iterator.next().getEmployee());
                    // print the arrow to show that all the element in the linked list are interconnected
                    System.out.println("-->");
                }
            }
        }
    }


}
