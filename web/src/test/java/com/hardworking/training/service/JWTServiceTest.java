package com.hardworking.training.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.hardworking.training.init.AppBootstrap;
import com.hardworking.training.model.User;
import com.hardworking.training.repository.UserDao;
import io.jsonwebtoken.Claims;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppBootstrap.class)
public class JWTServiceTest {
    @Autowired JWTService jwtService;
    private User user;
    @Autowired
    @Qualifier("True")
    UserDao userDao;
    @Before
    public void init(){
        user= userDao.getUserByName("hangec");
    }

    @Test
    public void tokenTest(){
        Map<String,String> token = jwtService.generateToken(user);
//        String token2 = jwtService.generateToken(user);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        String token3=jwtService.generateToken(user);
//        Assert.assertEquals(token,token2);
//        Assert.assertNotEquals(token,token3);
//        List<Character> tokenChar=new ArrayList<>();
//        for (char c: token.toCharArray()){
//            tokenChar.add(c);
//        }
//        List<Character> containPoint = tokenChar.stream()
//                                                .filter(c->c.equals('.'))
//                                                .collect(Collectors.toList());
//        Assert.assertTrue(containPoint.size()==2);
        //TODO regex matcher/match
        Assert.assertEquals(token.get("token").split("[.]").length,3);
        }


        @Test
        public void deTest(){
        Map<String,String> token=jwtService.generateToken(user);
        Claims c =jwtService.decyptToken(token.get("token"));
        String name= c.getSubject();
        Assert.assertEquals("hangec",name);

        }
}
