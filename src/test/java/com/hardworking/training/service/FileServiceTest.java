package com.hardworking.training.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.hardworking.training.init.AppBootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppBootstrap.class)
public class FileServiceTest {
    @Autowired
    FileService fileService;
    @Autowired
    AmazonS3 s3Client;
    @Test
    public void upload(){
        //Mockito
//        AmazonS3 s3client=mock(AmazonS3.class);
//        s3client.putObject("xxx","xx","yy");
//        verify(s3client,times(1)).putObject(anyString(),anyString(),anyString());

        File testFile=new File("/Users/Hange/Downloads/shijingre_banner.png");
//        fileService.uploadFile(testFile);
        //Modified Mockito
//        File testFile=mock(File.class);
        fileService.uploadFile(testFile);
        verify(s3Client,times(1)).putObject(any(PutObjectRequest.class));
    }
    @Test
    public void getUrlTest(){
        try {
            when(s3Client.getUrl(anyString(),anyString() )).thenReturn(new URL("http","xxx",123,"abc"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        fileService.getUrl("s3key");
        verify(s3Client,times(1)).getUrl(anyString(),anyString());
    }
}
