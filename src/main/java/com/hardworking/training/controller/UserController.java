package com.hardworking.training.controller;

import com.hardworking.training.model.User;
import com.hardworking.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/users","/user"})
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "",method = RequestMethod.POST)
    public User save(@RequestBody User user){
        User user1=userService.saveUser(user);
        if (user1==null) System.out.println("failure to create");
        return user1;
    }
}
