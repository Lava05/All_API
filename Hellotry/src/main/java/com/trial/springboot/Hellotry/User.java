package com.trial.springboot.Hellotry;

public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;

//    public User(String firstName, String lastName, String userName, String email, String phoneNumber, String createPassword, String confirmPassword) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.userName = userName;
//        this.email = email;
//        this.password = password;
//    }

    public User() {
        this.userName = "";
        this.password = "";
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}