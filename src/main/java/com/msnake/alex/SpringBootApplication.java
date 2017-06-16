package com.msnake.alex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring Boot starter
 *
 * @author shigaevak
 * @since 29.05.2017
 */
@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableTransactionManagement
@EnableAutoConfiguration
@ComponentScan("com.msnake.alex")
@EnableJpaRepositories("com.msnake.alex.repository")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class<?>[]{SpringBootApplication.class}, args);
    }
}
