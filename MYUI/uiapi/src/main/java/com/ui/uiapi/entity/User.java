package com.ui.uiapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue

    private Integer id;



    private  String email;

    private Long mobile_no;

    private  String password;

    private String username;

    public void setUserName(String newName) {
        this.username = newName;
    }
}
