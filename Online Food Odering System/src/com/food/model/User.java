package com.food.model;

public class User {
    private final String userName;
    private String password;
    private UserType typeOfUser;

    public User(String userName, String password, UserType typeOfUser) {
        this.userName = userName;
        this.password = password;
        this.typeOfUser = typeOfUser;
    }

    public java.lang.String getPassword() {
        return password;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    public UserType getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(UserType typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    @Override
    public java.lang.String toString() {
        return "User{" +
                "UserName=" + userName +
                ", password='" + password + '\'' +
                ", typeOfUser=" + typeOfUser +
                '}';
    }
}
