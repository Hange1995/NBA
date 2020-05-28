package com.hardworking.training.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.hardworking.training.jsonview.Views;
import com.hardworking.training.model.User;
import com.hardworking.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/role",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public User setRole(@RequestParam(value = "userName") String userName, @RequestParam(value = "roleName") String roleName){
        return userService.setRole(userName,roleName);
    }

    @RequestMapping(value = "/role",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public User removeRole(@RequestParam(value = "userName") String userName,@RequestParam(value = "roleName") String roleName){
        return userService.removeRole(userName,roleName);
    }
    @JsonView({Views.AdminView.class})
    @RequestMapping(value = "",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


}
