package com.hardworking.training.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com.hardworking.training"})
@ServletComponentScan(basePackages = {"com.hardworking.training.filter"})
public class AppBootstrap extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(AppBootstrap.class,args);
    }
}
