package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Demo;
import com.example.demo.service.DemoService;

@RestController
public class DemoController {

    @Autowired
    DemoService service;

    @RequestMapping(value = "/contract/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Demo> getDemo(@PathVariable("id") long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/demo/Create", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public boolean createContract(@RequestBody Demo d) {
        Demo demo = new Demo();
        demo.setId(1);
        demo.setName("akash");

        service.create(demo);
        return true;
    }
}
