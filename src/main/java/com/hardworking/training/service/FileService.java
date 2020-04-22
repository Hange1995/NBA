package com.hardworking.training.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.hardworking.training.init.AWSConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileService {
    private String clientRegion = "us-east-1";
    private String bucketName="bucket-for-hange";
    @Autowired
    private AmazonS3 s3Client;
    public void uploadFile(File file){
        //This code expects that you have AWS credentials set up per:
        // https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/setup-credentials.html
        // Upload a text string as a new object.
        PutObjectRequest request = new PutObjectRequest(bucketName, file.getName(), file);
        s3Client.putObject(request);
    }

    public String getUrl(String s3Key){
        return s3Client.getUrl(bucketName,s3Key).toString();
    }
}
