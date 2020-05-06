package com.hardworking.training.worker.init;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfig {

    @Bean
    public AmazonSQS getAmazonSQS(){
        return AmazonSQSClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain())
                .build();
    }
}
