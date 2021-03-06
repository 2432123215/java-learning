package com.yxz.boottest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BootTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootTestApplication.class, args);
    }

}
