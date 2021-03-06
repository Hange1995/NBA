package com.hardworking.training.service;

import com.amazonaws.services.s3.AmazonS3;

import com.amazonaws.services.s3.model.PutObjectRequest;
import com.hardworking.training.init.AppBootstrap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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


    @Before
    public void init(){

    }
    @After
    public void after(){
        reset(s3Client);
    }
    @Test
    public void uploadTest() throws IOException {
        //Mockito
//        AmazonS3 s3client=mock(AmazonS3.class);
//        s3client.putObject("xxx","xx","yy");
//        verify(s3client,times(1)).putObject(anyString(),anyString(),anyString());
//        verify(s3Client,times(0)).putObject(any(PutObjectRequest.class));
//        ObjectMetadata metadata = mock(ObjectMetadata.class);
//        when(metadata.getContentType()).thenReturn("xxx");
//        fileService.uploadFile(testFile);
        //Modified Mockito
//        File testFile=mock(File.class);
        MultipartFile testFile= mock(MultipartFile.class);
        when(testFile.getOriginalFilename()).thenReturn("sample.txt");
        when(s3Client.getUrl(anyString(),anyString())).thenReturn(new URL("http","xxx",123,"abc"));
        InputStream inputStream= new ByteArrayInputStream("xxx".getBytes());
        when(testFile.getInputStream()).thenReturn(inputStream);
        fileService.uploadFile(testFile);
//        verify(s3Client,times(1)).putObject(anyString(),anyString(),
//                                            any(InputStream.class),any(ObjectMetadata.class));
        verify(s3Client,times(1)).putObject(any(PutObjectRequest.class));
    }




    @Test
    public void getUrlTest() throws MalformedURLException {
        when(s3Client.getUrl(anyString(),anyString() )).thenReturn(new URL("http","xxx",123,"abc"));
        fileService.getUrl("s3key");
        verify(s3Client,times(1)).getUrl(anyString(),anyString());
    }
}
