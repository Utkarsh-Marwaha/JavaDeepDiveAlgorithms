package _6_HashTables;

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "Employee{" + firstName + ' ' + lastName + " has employee ID: " + employeeID + '}';
    }
}
