package com.appspringmvc.service;

import com.appspringmvc.dao.UserDao;
import com.appspringmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public void createUser(String name, String address, String email) {
        User user = new User();
        user.setName(name);
        user.setAddress(address);
        user.setEmail(email);
        userDao.save(user);
    }

    @Override
    @Transactional
    public void updateUser(Long id, String name, String address, String email) {
        User existing = userDao.findById(id);
        if (existing != null) {
            existing.setName(name);
            existing.setAddress(address);
            existing.setEmail(email);
            userDao.update(existing);
        }
    }


    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.delete(id);
    }
}