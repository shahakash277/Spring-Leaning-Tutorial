package com.example.demo.repository;

import javax.persistence.EntityManager;

import com.example.demo.model.Demo;

public class DemoRepositoryImpl {

    protected Class<Demo> domainClass;
    protected EntityManager em;
    //
    // public DemoRepositoryImpl(Class<Demo> domainClass, EntityManager em) {
    // // super(domainClass, em);
    // this.domainClass = domainClass;
    // this.em = em;
    // }
    //
    // // public DemoRepositoryImpl(Class<Demo> domainClass, EntityManager em) {
    // //
    // // this.domainClass = domainClass;
    // // this.em = em;
    // // }
    //
    // public List<Demo> searchByQual() {
    // CriteriaBuilder cb = em.getCriteriaBuilder();
    // CriteriaQuery<Demo> query = cb.createQuery(Demo.class);
    // Root<Demo> root = query.from(domainClass);
    // Predicate id = cb.equal(root.get("id"), 2);
    // query.where(id);
    // TypedQuery<Demo> result = em.createQuery(query);
    // return result.getResultList();
    // }
}
