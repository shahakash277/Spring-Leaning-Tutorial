package com.springdemo.base.service;

import com.springdemo.base.model.Base;

public interface BaseService<T extends Base> {

    public T create(T domainObj);

    public T update(T domainObj);

    public T get(int id);
}
