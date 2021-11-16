package com.h2sm.springjpahibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories

public class SpringJpaHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaHibernateApplication.class, args);

    }



}
