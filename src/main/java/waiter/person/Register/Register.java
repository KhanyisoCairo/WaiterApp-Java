package waiter.person.Register;

public class Register {
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String password;

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;

    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public String getPassword() {
        return  password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }


}

