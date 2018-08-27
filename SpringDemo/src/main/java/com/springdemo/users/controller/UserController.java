package com.springdemo.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.users.model.User;
import com.springdemo.users.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping(value = "/login/list", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<User> getUser() {
        return service.get(1L);
    }

    @RequestMapping(value = "/user/Create", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public boolean createContract(@RequestBody User user) {
        service.create(user);
        return true;
    }
}
