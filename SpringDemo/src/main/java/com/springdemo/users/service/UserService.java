package com.springdemo.users.service;

import java.util.List;

import com.springdemo.users.model.User;

public interface UserService {

    User create(User demo);

    List<User> get(long id);

}