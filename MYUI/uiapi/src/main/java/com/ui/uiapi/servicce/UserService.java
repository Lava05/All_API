package com.ui.uiapi.servicce;

import com.ui.uiapi.dto.UserNameUpdateDTO;
import com.ui.uiapi.entity.User;

public interface UserService {
    void registerUser(User user);
    boolean loginUser(User user);
    User getUserById(Long id);
    User updateUser(User user);
    void deleteUser(Long id);

    boolean updateUserName(Long id, UserNameUpdateDTO userNameUpdateDTO);
}
