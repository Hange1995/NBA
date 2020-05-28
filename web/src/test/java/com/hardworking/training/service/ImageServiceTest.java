package com.hardworking.training.service;

import com.hardworking.training.init.AppBootstrap;
import com.hardworking.training.model.Image;
import com.hardworking.training.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppBootstrap.class)
public class ImageServiceTest {
    @Autowired ImageService imageService;
    @Autowired UserService userService;

    @Test
    public void saveTest(){
        User user=new User();
        user.setName("1234");
        user.setEmail("1234@123.com");
        userService.saveUser(user);

        Image image=new Image();
        image.setFileName("TestFile.txt");
        image.setUser(user);
        image.setS3key("txt3219493281948928391.txt");
        image.setUploadTime(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
        imageService.save(image);

    }
}
