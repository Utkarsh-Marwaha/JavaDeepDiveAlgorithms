package _6_HashTables.SimpleHT;

public class Employee {

    /**
     * instance fields of the employee class
     */
    private String firstName;
    private String lastName;
    private int employeeID;

    /**
     *
     * @param firstName first name of the employee
     * @param lastName last name of the employee
     * @param employeeID unique identifier of the employee
     */
    public Employee(String firstName, String lastName, int employeeID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getEmployeeID() {
        return employeeID;
    }


    @Override
    public String toString() {
        return "Employee{" + firstName + ' ' + lastName + " has employee ID: " + employeeID + '}';
    }
}
