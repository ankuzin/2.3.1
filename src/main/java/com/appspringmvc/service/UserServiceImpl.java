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
    public void createUser(User user) {
        if (user != null) {
            userDao.save(user);
        }
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        if (user != null && user.getId() != null) {
            User existing = userDao.findById(user.getId());
            if (existing != null) {
                existing.setName(user.getName());
                existing.setAddress(user.getAddress());
                existing.setEmail(user.getEmail());
                userDao.update(existing);
            }
        }
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        if (id != null) {
            userDao.delete(id);
        }
    }
}