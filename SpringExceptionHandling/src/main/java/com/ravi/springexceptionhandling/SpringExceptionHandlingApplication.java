package com.ravi.springexceptionhandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringExceptionHandlingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringExceptionHandlingApplication.class, args);
    }

}
