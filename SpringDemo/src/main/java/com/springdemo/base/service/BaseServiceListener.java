package com.springdemo.base.service;

import com.springdemo.base.model.Base;

public interface BaseServiceListener<T extends Base> {

    public void before_create(T incomingObj);

    public void after_create(T existingObj, T incomingObj);

    public void before_update(T existingObj, T incomingObj);

    public void after_update(T existingObj, T incomingObj);
}
