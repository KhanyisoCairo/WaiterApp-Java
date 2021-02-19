package models;

public class Login {
    private Long id;
    private String username;
    private String password;

    public void setId(Long id) { this.id = id; }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public Long getId() { return id; }
    public String getUsername() {
        return username;
    }
}
