package com.springdemo.base.service;

import com.springdemo.base.model.Base;

public class BaseServiceLisenerImpl<T extends Base> implements BaseServiceListener<T> {

    @Override
    public void before_create(T incomingObj) {
    }

    @Override
    public void after_create(T existingObj, T incomingObj) {
    }

    @Override
    public void before_update(T existingObj, T incomingObj) {
    }

    @Override
    public void after_update(T existingObj, T incomingObj) {
    }

}
