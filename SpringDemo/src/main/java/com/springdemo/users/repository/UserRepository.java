package com.springdemo.users.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springdemo.base.repository.BaseRepository;
import com.springdemo.users.model.User;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    List<User> findByEmail(String email);
}
