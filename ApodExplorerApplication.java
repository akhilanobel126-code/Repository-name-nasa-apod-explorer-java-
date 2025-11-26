package com.example.apod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApodExplorerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApodExplorerApplication.class, args);
    }
}
