package com.springdemo.users.repository;

import java.util.List;

import com.springdemo.base.repository.BaseRepository;
import com.springdemo.users.model.User;

public interface UserRepository extends BaseRepository<User, Long> {
    List<User> findByEmail(String email);
}
