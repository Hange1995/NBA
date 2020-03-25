package com.hardworking.training.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com.hardworking.training"})
public class AppBootstrap{
    public static void main(String[] args) {
        SpringApplication.run(AppBootstrap.class,args);
    }
}
