package com.mysql1.data.mysqldemo.repository;


import com.mysql1.data.mysqldemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{


}
