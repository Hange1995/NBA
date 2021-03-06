package com.hardworking.training.init;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class AWSConfig {
    //TODO constructor based DI
    @Value("${aws.bucket.name}")
    private String bucketName;
    @Bean
    public AmazonS3 getAmazonS3(){
        return AmazonS3ClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .build();
    }

    @Bean
    public AmazonSQS getAmazonSQS(){
        return AmazonSQSClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain())
                .build();
    }

//    @Bean
//    public FileService getFileService(){
//        AmazonS3 amazonS3=AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
//        FileService fileService=new FileService(amazonS3);
//        fileService.setBucketName(bucketName);
//        return fileService;
//    }

}
