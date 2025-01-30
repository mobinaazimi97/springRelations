package com.mftplus.spring02twopractice.model.service.impl;

import com.mftplus.spring02twopractice.model.entity.User;
import com.mftplus.spring02twopractice.model.repository.UserRepository;
import com.mftplus.spring02twopractice.model.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);

    }

    @Override
    public void update(User user) {
        userRepository.save(user);

    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
