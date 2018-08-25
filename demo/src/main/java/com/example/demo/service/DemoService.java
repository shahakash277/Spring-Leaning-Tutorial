package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Demo;

public interface DemoService {
    Demo create(Demo demo);

    List<Demo> get(long id);
}
