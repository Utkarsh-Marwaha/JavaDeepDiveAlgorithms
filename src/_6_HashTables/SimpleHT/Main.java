package _6_HashTables.SimpleHT;

public class Main {

    public static void main(String[] args) {

        Employee[] employees = {
                new Employee("Jane", "Jones", 123),
                new Employee("John", "Doe", 4567),
                new Employee("Mary", "Smith", 22),
                new Employee("Mike", "Wilson", 3245),
                new Employee("Bill", "End", 78)
        };

        SimpleHashTable hashTable = new SimpleHashTable(10);

        for (Employee e: employees) {
            hashTable.put(e.getLastName(), e);
        }

        hashTable.printHashTable();
    }
}
