package com.springdemo.base.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
        implements BaseRepository<T, ID> {

    private EntityManager entityManager;
    private Class<T> domainClass;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager = em;
        this.domainClass = domainClass;
    }

    @Override
    public List<T> findByName(String name) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cQuery = builder.createQuery(domainClass);
        Root<T> root = cQuery.from(domainClass);
        cQuery.select(root).where(builder.like(root.<String> get("name"), "%" + name + "%"));
        TypedQuery<T> query = entityManager.createQuery(cQuery);
        return query.getResultList();
    }

    @Override
    public T findById(int id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cQuery = builder.createQuery(domainClass);
        Root<T> root = cQuery.from(domainClass);
        cQuery.select(root).where();
        TypedQuery<T> query = entityManager.createQuery(cQuery);
        List<T> resultList = query.getResultList();
        T domainObj = null;
        if (resultList != null && !resultList.isEmpty()) {
            domainObj = resultList.get(0);
        }
        return domainObj;

    }
}
