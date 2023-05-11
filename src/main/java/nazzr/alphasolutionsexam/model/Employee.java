package nazzr.alphasolutionsexam.model;

public class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private int userID;

    public Employee() {
    }

    public Employee(int employeeID, String firstName, String lastName, String email, String role, int userID) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.userID = userID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public int getUserID() {
        return userID;
    }

    public Employee setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
        return this;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    public Employee setRole(String role) {
        this.role = role;
        return this;
    }

    public Employee setUserID(int userID) {
        this.userID = userID;
        return this;
    }
}
