package nazzr.alphasolutionsexam.model;

public class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private String role;

    public Employee() {
    }

    public Employee(int employeeID, String firstName, String lastName, String email, String role) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    //----------------------------------------------------Getter-----------------------------------------------------\\
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

    //----------------------------------------------------Setter-----------------------------------------------------\\
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
