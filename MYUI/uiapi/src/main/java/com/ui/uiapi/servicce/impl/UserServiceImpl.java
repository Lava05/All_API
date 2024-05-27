package com.ui.uiapi.servicce.impl;

import com.ui.uiapi.dto.UserNameUpdateDTO;
import com.ui.uiapi.entity.User;
import com.ui.uiapi.repository.UserRepository;
import com.ui.uiapi.servicce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean loginUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        return existingUser != null && existingUser.getPassword().equals(user.getPassword());
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    @Override
    public User updateUser(User user) {
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        } else {
            return null; // User not found
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public boolean updateUserName(Long id, UserNameUpdateDTO userNameUpdateDTO) {
        User existingUser = userRepository.findById(Math.toIntExact(id)).orElse(null);
        if (existingUser != null) {
            existingUser.setUserName(userNameUpdateDTO.getNewName());
            userRepository.save(existingUser);
            return true;
        } else {
            return false; // User not found
        }
    }




}
