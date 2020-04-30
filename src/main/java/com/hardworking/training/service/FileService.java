package com.hardworking.training.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.google.common.io.Files;
import com.hardworking.training.init.AWSConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {
    private String clientRegion = "us-east-1";
    private String bucketName="bucket-for-hange";
    @Autowired
    private AmazonS3 s3Client;
    public String uploadFile(String bucketName, MultipartFile file) throws IOException {
        //This code expects that you have AWS credentials set up per:
        // https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/setup-credentials.html
        // Upload a text string as a new object.
        String uuid= UUID.randomUUID().toString();
        String newFileName= Files.getFileExtension(file.getOriginalFilename())
                +uuid+Files.getFileExtension(file.getOriginalFilename());
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(file.getContentType());
        objectMetadata.setContentLength(file.getSize());
        PutObjectRequest request = new PutObjectRequest(bucketName,
                file.getOriginalFilename()+uuid, file.getInputStream(),objectMetadata);
        s3Client.putObject(request);
        return s3Client.getUrl(bucketName,newFileName).toString();
    }

    public String getUrl(String s3Key){
        return s3Client.getUrl(bucketName,s3Key).toString();
    }
}
