package org.dentalclinic.logic;

public class User {
    private int userId;
    private String userName;
    private String password;
    private String rol;

    public User(int userId, String userName, String password, String rol) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.rol = rol;
    }

    public int getuserId() {
        return userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
