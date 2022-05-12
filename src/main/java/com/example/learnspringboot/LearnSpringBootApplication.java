package com.example.learnspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class LearnSpringBootApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("ICT"));
        SpringApplication.run(LearnSpringBootApplication.class, args);
    }
}
