package _6_HashTables.LinearProbing;

public class SimpleHashTable {

    // private Employee[] hashTable;
    private StoredEmployee[] hashTable;

    /**
     * @param capacity size of the hashtable
     */
    public SimpleHashTable(int capacity) {
        this.hashTable = new StoredEmployee[capacity];
    }

    /**
     * @param key last name of the employee
     * @return hashed value corresponding to the key
     */
    private int hashKey(String key) {
        return key.length() % hashTable.length;
    }
    // Every employee whose length of surname is same will collide in our hash function

    public void put(String key, Employee employee) {

        // find the hash value corresponding to the key
        int hashedKey = hashKey(key);

        if (positionTaken(hashedKey)) {
            // need to do linear probing


            // set a stop index just so that we know when have searched the entire hashtable
            int stopIndex = hashedKey;

            if (hashedKey == hashTable.length - 1) {
                hashedKey = 0; // initial probe should start from 0 if hashed key is the last index of the table
            } else {
                hashedKey++; // otherwise simply increment the hashed key by 1
            }

//            hashedKey = hashedKey == hashTable.length - 1 ? hashedKey = 0 : hashedKey+1;

            /*keep probing until we find an empty index or we have searched all the places*/
            while (positionTaken(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashTable.length; // wrap around
            }

            if (positionTaken(hashedKey)) {
            /* we will come here only if the hash table is completely loaded
            in which case there is no space for an employee to added*/
                System.out.println("All positions are booked " + hashedKey);
            } else {
                // hashTable[hashKey] = employee;
                hashTable[hashedKey] = new StoredEmployee(key, employee);
            }
        }
    }


    /**
     * @param index position at which we want to check vacancy
     * @return true if the position is occupied in the hashtable
     * false otherwise
     */
    private boolean positionTaken(int index) {
        return hashTable[index] != null;
    }

    public Employee get(String key) {

        // int hashedKey = hashKey(key);
        // return hashTable[hashKey];

        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            return null;
        }

        return hashTable[hashedKey].getEmployee();
    }

    /*Linear probing has made sure that we can enter employee records
     * in our hash table despite the limitation of our hash function
     * but what about the retrieval, cause remember that the get function
     * also uses the hash function which as we know is deterministic.
     * This means that it would give the wrong value to the employee
     * position. To tackle this new problem we need to make sure that
     * our get function also follows linear probing for which our
     * hash table will have to modified for it start holding information
     * about both the key as well as the value. */

    /*The hash table will now be an array of StoredEmployee rather
     * than just being simply the Employee[]*/

    /**
     * @param key raw key: last name of the employee
     * @return employee record corresponding to the key
     */
    private int findKey(String key) {

        int hashedKey = hashKey(key);
        // was the employee at the hashed key index added using the hash key function or did we use linear probing
        if (hashTable[hashedKey] != null && hashTable[hashedKey].getKey().equals(key)) {
            // found the employee
            return hashedKey;
        } else {
            // we had to do linear probing while putting the employee record in the hash table

            // set a stop index just to know when we have looked at the entire array
            int stopIndex = hashedKey;

            if (hashedKey == hashTable.length - 1) {
                hashedKey = 0; // initial probe should start from 0 if hashed key is last index
            } else {
                hashedKey++; // otherwise simply increment hashed key by 1 to make the first probe
            }

            /*keep probing till we find the key or we have looked at all possible places*/
            while (hashedKey!=stopIndex && hashTable[hashedKey] != null
                    && !hashTable[hashedKey].getKey().equals(key)){
                hashedKey = (hashedKey + 1) % hashTable.length; // wrap around
            }


            /*IMPORTANT: If you are wondering about whether the condition
             * hashTable[hashedKey] != null makes sense within the while loop
             * it is key to note that in linear probing we always end up putting the item
             * in the first available position after the hash collision and so while
             * searching it makes sense to break out of the loop if the value at a
             * particular index is null as that would essentially indicate the end of
             * the hash table. This holds true even when we wrap around the hash table*/

            if(hashTable[hashedKey]!=null && hashTable[hashedKey].getKey().equals(key)){
                return hashedKey;
            } return -1;
        }
    }


    /*Adding a remove method for linear probing*/


    /**
     *
     * @param key raw key of the employee whose data we want to remove
     * @return the employee whose is to be removed, null if not present
     */
    public Employee remove(String key){

        int hashedKey = findKey(key);

        if (hashedKey == -1){
            return null;
        }

        Employee employee = hashTable[hashedKey].getEmployee();
        hashTable[hashedKey] = null;

        // will rehash the entire table on deletion
        // This makes sure that the all employees remain next to each other

        // make a copy of the hashtable before overwriting its values
        StoredEmployee[] beforeDelete = hashTable;

        // re initiate all the values of the hashtable
        hashTable = new StoredEmployee[beforeDelete.length];

        // copy back all the non null values to the new hashtable
        for (int i = 0; i < beforeDelete.length; i++){
            if (beforeDelete[i]!=null){
                // rehash
                put(beforeDelete[i].getKey(), beforeDelete[i].getEmployee());
            }
        }

        // return the employee record which has been removed
        return employee;
    }


    public void printHashTable(){
        for (int i = 0; i < hashTable.length; i++){
            if (hashTable[i] == null){
                System.out.println("Empty");
            } else {
                System.out.println("Position " + i + ": " + hashTable[i].getEmployee());
            }
        }
    }

}