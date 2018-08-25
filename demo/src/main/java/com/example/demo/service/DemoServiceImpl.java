package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Demo;
import com.example.demo.repository.DemoRepository;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    DemoRepository demoRepo;

    DemoServiceImpl() {
    }

    @Override
    public Demo create(Demo demo) {
        demo = demoRepo.save(demo);
        return demo;
    }

    @Override
    public List<Demo> get(long id) {
        List<Demo> demo = demoRepo.findAll();

        return demo;
    }

}
