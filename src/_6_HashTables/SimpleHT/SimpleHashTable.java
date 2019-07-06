package _6_HashTables.SimpleHT;

import _6_HashTables.SimpleHT.Employee;

public class SimpleHashTable {

    private Employee[] hashTable;

    public SimpleHashTable(int capacity) {
        this.hashTable = new Employee[capacity];
    }

    /**
     *
     * @param key last name of the employee
     * @return hash code corresponding to the employee
     */
    private int hashKey(String key){
        return key.length() % hashTable.length;
    }
    /*Every employee whose length of the surname is the same will collide in this hash function*/

    public void put(String key, Employee employee){

        int hashedKey = hashKey(employee.getLastName());

        if (hashTable[hashedKey]!=null){
            System.out.println("Sorry, there is already an employee at the position "+hashedKey);
        } else {
            hashTable[hashedKey] = employee;
        }
    }

    public Employee get(String key){

        int hashedKey = hashKey(key);

        /*The fact that we will get the same hash code for our key as the one which
         * was generated while putting the employee record into the hash table reveals
         * an important property about hash functions that they are always deterministic
         * Otherwise we would almost always end up returning the wrong employee records*/

        return hashTable[hashedKey];

        /* A word about complexity
         *  The retrieval as can be observed is constant time because all
         *  we are doing at the end of the day is using array indices to
         *  access the values.
         */
    }


    /*Let say the last name of the employee is Jones and so
     * the hash function will return the result of 5 % 10
     * because length of the last name (key) is 5 and the
     * capacity of the hash table is 10
     *
     * The result will be used to hash into the hash table
     * (backed by an array). It is important to note that
     * it is only a matter of chance that the key length
     * and the hash code have turned out to be identical.
     * */

    /*
     * This hash function is not particularly the best we can come up with
     * but it makes sure that all employees get mapped to indices within the
     * valid range. As mentioned earlier, the quality of our hash function
     * will play a decisive role in determining the retrieval of values
     * from our hash table. If we write a hash function which ends up
     * matching most of the values to the same index then it would take
     * us that bit longer to search through all those matched values and find
     * out the one we want.
     *
     * If we have a hash function which evenly distributes the values over
     * the buckets of the indices then the retrieval will be good.
     */

    public void printHashTable(){

        for (Employee employee: hashTable){
            System.out.println(employee);
        }
    }
}
