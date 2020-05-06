package com.hardworking.training.worker.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.hardworking.training.worker")
public class AppBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(AppBootstrap.class,args);
    }
}
