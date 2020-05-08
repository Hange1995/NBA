package com.hardworking.training.worker.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.hardworking.training.worker")
public class AppBootstrapConsumer {
    public static void main(String[] args) {
        SpringApplication.run(AppBootstrapConsumer.class,args);
    }
}
