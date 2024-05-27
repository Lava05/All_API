package com.api.Hibernate.repository;

import org.springframework.stereotype.Repository;
import com.api.Hibernate.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void registerUser(User user) {
        Query query = entityManager.createQuery("INSERT INTO User(firstName, lastName, age, mobileNo) " +
                "VALUES (:firstName, :lastName, :age, :mobileNo)");
        query.setParameter("firstName", user.getFirstName());
        query.setParameter("lastName", user.getLastName());
        query.setParameter("age", user.getAge());
        query.setParameter("mobileNo", user.getMobileNo());
        query.executeUpdate();
    }

    @Transactional
    public User updateUser(User user) {
        Query query = entityManager.createQuery("UPDATE User u SET u.firstName = :firstName, u.lastName = :lastName, u.age = :age, u.mobileNo = :mobileNo WHERE u.employeeID = :employeeID");
        query.setParameter("firstName", user.getFirstName());
        query.setParameter("lastName", user.getLastName());
        query.setParameter("age", user.getAge());
        query.setParameter("mobileNo", user.getMobileNo());
        query.setParameter("employeeID", user.getEmployeeID());
        query.executeUpdate();
        return user;
    }

    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.employeeID = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    public void deleteUser(int id) {
        Query query = entityManager.createQuery("DELETE FROM User u WHERE u.employeeID = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public User save(User user) {
        return user;
    }

    public Optional<Object> findById(Integer id) {
        return Optional.empty();
    }

    public void deleteById(Integer id) {
    }
}
