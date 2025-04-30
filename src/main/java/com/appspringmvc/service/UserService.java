package com.appspringmvc.service;

import com.appspringmvc.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    void createUser(String name, String address, String email);

    void updateUser(Long id, String name, String address, String email);

    void deleteUser(Long id);
}
