package com.springdemo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.springdemo.base.repository.BaseRepositoryFactoryBean;

@Configuration
@EnableConfigurationProperties
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.springdemo", entityManagerFactoryRef = "entityManager", transactionManagerRef = "transactionManager", repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class JpaConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String dbDriverName;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUserName;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String dbDialect;

    @Value("${spring.jpa.show-sql}")
    private String dbShowSQL;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String dbDDL;
    @Value("${entitymanager.packagesToScan}")
    private String packageScan;

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManager() {
        final LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan(packageScan);

        final JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(vendorAdapter);
        emf.setJpaProperties(hibernateProperties());

        return emf;

    }

    @Bean
    public Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.jdbc.lob.non_contextual_creation", true);
        hibernateProperties.put("hibernate.dialect", dbDialect);
        hibernateProperties.put("spring.jpa.show-sql", dbShowSQL);
        hibernateProperties.put("spring.jpa.hibernate.ddl-auto", dbDDL);
        return hibernateProperties;
    }

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbDriverName);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUserName);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    @Primary
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManager().getObject());
        return txManager;
    }
}
