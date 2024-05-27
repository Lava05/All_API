package com.example.microservice.Ecommerce.repository;

import com.example.microservice.Ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
