package com.springdemo.users.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.NoRepositoryBean;

import com.springdemo.users.model.User;

@NoRepositoryBean
public class BaseDao {
    @Autowired
    SessionFactory sessionFactory;

    public List<User> findAllUser() {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        org.hibernate.query.Query<User> userList = session.createQuery("Select * from users",
                User.class);
        return userList.getResultList();

    }
}
