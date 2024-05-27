package com.trial.springboot.Hellotry;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String userName;

    @Setter
    @Column(nullable = false)
    private String password;

    @Setter
    @Column(nullable = false)
    private String email;

    @Setter
    @Column
    private Long mobileNo;

    // Constructors

    public User() {
        this.userName = "";
        this.password = "";
    }

    // Getters and setters for id

    public void setId(Long id) {
        this.id = id;
    }

    // Getters and setters for userName, password, and mobileNo

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    // Additional methods, if any
}
