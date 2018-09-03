package com.springdemo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springdemo.base.repository.BaseRepositoryFactoryBean;

@SpringBootApplication
@ComponentScan("com.springdemo")
@EntityScan("com.springdemo")
@EnableJpaRepositories(basePackages = "com.springdemo", repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class, entityManagerFactoryRef = "entityManager", transactionManagerRef = "transactionManager")
public class SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }
}
