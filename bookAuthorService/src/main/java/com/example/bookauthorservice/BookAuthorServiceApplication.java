package com.example.bookauthorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookAuthorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookAuthorServiceApplication.class, args);
    }

}
