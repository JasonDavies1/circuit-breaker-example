package com.example.circuitbreakerexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CircuitBreakerExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CircuitBreakerExampleApplication.class, args);
    }

}

