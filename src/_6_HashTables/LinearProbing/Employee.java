package _6_HashTables.LinearProbing;

public class Employee {

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

    /**
     *
     * @return first name of the employee
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @return last name of the employee
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @return unique identifier of the employee
     */
    public int getEmployeeID() {
        return employeeID;
    }
}
