package com.springdemo.base.service;

import com.springdemo.base.model.Base;
import com.springdemo.base.repository.BaseRepository;

public abstract class BaseServiceImpl<T extends Base> extends BaseServiceLisenerImpl<T> implements
        BaseService<T> {

    protected BaseRepository<T, Long> repository;
    protected Class<T> domainClass;

    public BaseServiceImpl(BaseRepository<T, Long> repository, Class<T> domainclass) {
        this.repository = repository;
        this.domainClass = domainclass;
    }

    @Override
    public T create(T domainObj) {
        before_create(domainObj);
        T createdEntity = repository.save(domainObj);
        return createdEntity;
    }

    @Override
    public T update(T domainObj) {
        T existingObj = repository.findById(domainObj.getId());
        before_update(existingObj, domainObj);
        T updatedObj = perform_update(existingObj, domainObj);
        updatedObj = repository.save(updatedObj);
        after_update(updatedObj, domainObj);
        return updatedObj;
    }

    private T perform_update(T existingObj, T incomingObj) {

        return incomingObj;
    }

    @Override
    public T get(int id) {
        T getObj = repository.findById(id);
        return getObj;
    }

}
