package com.hardworking.training.controller;

import com.hardworking.training.model.User;
import com.hardworking.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public User update(User user){
        User updateUser=userService.update(user);
        if (updateUser==null) System.out.println("failure to update");
        return updateUser;
    }

    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public boolean delete(@RequestParam(value = "name") String name){
        return userService.deleteUser(name);
    }
//    @RequestMapping(value = "/{id}",method = RequestMethod.PATCH)
//    public User updatePatch(@PathVariable("id") Long id,@RequestParam() ){
//
//    }
}
