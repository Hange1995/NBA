package com.hardworking.training.controller;

import com.hardworking.training.model.Role;
import com.hardworking.training.model.User;
import com.hardworking.training.service.RoleService;
import com.hardworking.training.service.UserService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/set",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public User setRole(@RequestParam(value = "userName") String userName, @RequestParam(value = "roleName") String roleName){
        return userService.setRole(userName,roleName);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public User removeRole(@RequestParam(value = "userName") String userName,@RequestParam(value = "roleName") String roleName){
        return userService.removeRole(userName,roleName);
    }


}
