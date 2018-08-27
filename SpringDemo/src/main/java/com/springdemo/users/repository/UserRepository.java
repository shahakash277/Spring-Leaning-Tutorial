package com.springdemo.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdemo.users.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
