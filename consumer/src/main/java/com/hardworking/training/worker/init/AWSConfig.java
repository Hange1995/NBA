package com.hardworking.training.worker.init;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
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

    @Bean
    public static SQSConnectionFactory getSQSConnectionFactory(){
        SQSConnectionFactory connectionFactory = new SQSConnectionFactory(
                new ProviderConfiguration(),
                AmazonSQSClientBuilder.standard()
                        .withRegion("us-east-1")
                        .withCredentials(new DefaultAWSCredentialsProviderChain()));
        return connectionFactory;
    }
}
