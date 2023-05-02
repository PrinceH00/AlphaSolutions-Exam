package nazzr.alphasolutionsexam.model;

public class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private String role;

    public Employee(int employeeID, String firstName, String lastName, String email, String role) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    public Employee() {
    }

    public int getEmployeeID() { return employeeID; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getEmail() { return email; }

    public String getRole() { return role; }



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
}
