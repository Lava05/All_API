package com.customer.Ecommerrce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "cart_items")
public class UserCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "breed_variety")
    private String breedVariety;

    @Column(name = "breedName")
    private String breedName;

    // Parameterized constructor
    public UserCart(String username, String breedVariety, String breedName) {
        this.username = username;
        this.breedVariety = breedVariety;
        this.breedName = breedName;
    }

    // Default constructor
    public UserCart() {
        // Default constructor
    }
}
