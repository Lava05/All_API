package com.customer.Ecommerrce.repository;

import com.customer.Ecommerrce.entity.UserCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<UserCart, Long> {
    void deleteByUsernameAndBreedNameAndBreedVariety(String username, String breedVariety, String breedName);
}

