package com.appspringmvc.service;

import com.appspringmvc.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}
