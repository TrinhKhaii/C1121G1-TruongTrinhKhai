package model.employee;
/*
    Created by Trinh Khai
    Date: 17/03/2022
    Time: 11:09
*/

public class UserRole {
    private Integer role;
    private String username;

    public UserRole() {}

    public UserRole(Integer role, String username) {
        this.role = role;
        this.username = username;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "role=" + role +
                ", username='" + username + '\'' +
                '}';
    }
}
