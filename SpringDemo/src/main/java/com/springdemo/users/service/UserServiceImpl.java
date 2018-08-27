package com.springdemo.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.users.model.User;
import com.springdemo.users.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User demo) {
        return userRepository.save(demo);
    }

    @Override
    public List<User> get(long id) {

        return userRepository.findAll();
    }

}