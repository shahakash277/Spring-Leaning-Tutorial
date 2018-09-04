package com.springdemo.users.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.springdemo.users.model.User;

public interface UserService extends UserDetailsService {

    User create(User demo);

    List<User> get(long id);

    List<User> getByName(String name);

}
