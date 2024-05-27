package com.customer.Ecommerrce.dto;

public class CartRequest {
    public String breedName;
    private String username;
    private String breedVariety;

    // Constructors, getters, and setters
    public CartRequest() {}

    public CartRequest(String username, String breedVariety, String breedName) {
        this.username = username;
        this.breedVariety = breedVariety;
        this.breedName=breedName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBreedVariety() {
        return breedVariety;
    }

    public void setBreedVariety(String breedVariety) {
        this.breedVariety = breedVariety;
    }


    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }
}
