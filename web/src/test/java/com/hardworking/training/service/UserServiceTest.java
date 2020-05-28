package com.hardworking.training.service;

import com.hardworking.training.init.AppBootstrap;
import com.hardworking.training.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppBootstrap.class)
public class UserServiceTest {
    @Autowired UserService userService;

    @Test
    public void getUserByIdTest(){
        User user=userService.getUserById(3L);
        System.out.println(user);
    }
    @Test
    public void getUserCTest(){
        try {
            User user = userService.getUserByCredentials("XXX@123.com","202cb962ac59075b964b07152d234b70");
        }catch (Exception e){
            System.out.println("1");
        }

    }
}
