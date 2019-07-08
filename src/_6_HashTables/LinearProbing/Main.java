package _6_HashTables.LinearProbing;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Jane", "Jones", 123),
                new Employee("John", "Doe", 4567),
                new Employee("Mary", "Smith", 22),
                new Employee("Mike", "Wilson", 3245),
                new Employee("Bill", "End", 78)
        };

        SimpleHashTable hashTable = new SimpleHashTable(5);

        for (Employee e: employees){
            hashTable.put(e.getLastName(), e);
        }

        hashTable.printHashTable();

        hashTable.remove(employees[0].getLastName());
        hashTable.remove(employees[1].getLastName());

        hashTable.printHashTable();
    }
}
