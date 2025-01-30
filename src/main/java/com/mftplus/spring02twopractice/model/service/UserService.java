package com.mftplus.spring02twopractice.model.service;

import com.mftplus.spring02twopractice.model.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void update(User user);
    void delete(User user);
    void deleteById(Long id);
    User findUserById(Long id);
    List<User> findAll();
    User findUserByUsername(String username);
}
