//package com.hardworking.training.repository;
//
//import com.hardworking.training.init.AppBootstrap;
//import com.hardworking.training.model.User;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AppBootstrap.class)
//public class UserDaoTest {
//    @Autowired UserDao userDao;
//
//
//    @Before
//    public void init(){
//         User user =new User();
//         user.setName("Test");
//         user.setEmail("Test@gmail.com");
//         user.setPassword("123");
//    }
//
//
//
//
//    @Test
//    public void getRoleFromUser(){
//        User user= userDao.getUserById(1L);
//        user.getRoles();
//        System.out.println(user.getRoles());
//    }
//}
