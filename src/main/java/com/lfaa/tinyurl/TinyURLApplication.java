package com.lfaa.tinyurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class TinyURLApplication {

    public static void main(String[] args) {
        SpringApplication.run(TinyURLApplication.class, args);
    }

}
