package _6_HashTables.LinearProbing;

public class StoredEmployee {

    /* This is the raw key and not the hash key. Remember hashed keys are always
     integers because they have to be used as indices within the hash table
    */
    private String key;

    private Employee employee;

    // constructor
    public StoredEmployee(String key, Employee employee) {
        this.key = key;
        this.employee = employee;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Employee getEmployee() {
        return employee;
    }
}
