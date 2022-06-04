/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dql.configs;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 *
 * @author Acer
 */
@Configuration
@PropertySource("classpath:databases.properties")
public class HibernateConfig {
    @Autowired
    private Environment env;
    
    //Session
    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setPackagesToScan("com.dql.pojos");
        factory.setDataSource(dataSource());
        factory.setHibernateProperties(hibernateProperties());
        return factory;
    }
    
    //ket noi csdl
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("hibernate.connection.driverClass"));
        dataSource.setUrl(env.getProperty("hibernate.connection.url"));
        dataSource.setUsername(env.getProperty("hibernate.connection.username"));
        dataSource.setPassword(env.getProperty("hibernate.connection.password"));
        
        return dataSource;
    }
    
    
    public Properties hibernateProperties(){
        Properties p = new Properties();
        p.setProperty(org.hibernate.cfg.Environment.SHOW_SQL, env.getProperty("hibernate.showSql"));
        p.setProperty(org.hibernate.cfg.Environment.DIALECT, env.getProperty("hibernate.dialect"));
        
        return p;
    }
    
    //tu dong/mo 
    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager h = new HibernateTransactionManager();
        h.setSessionFactory(getSessionFactory().getObject());
        
        return h;
    }
    
}

