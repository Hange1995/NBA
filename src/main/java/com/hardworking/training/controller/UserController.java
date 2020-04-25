package com.hardworking.training.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.hardworking.training.jsonview.Views;
import com.hardworking.training.model.User;
import com.hardworking.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/users","/user"})
public class UserController {
    @Autowired
    UserService userService;
    @JsonView({Views.UserView.class})
    @RequestMapping(value = "/create",method = RequestMethod.POST)
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

    @RequestMapping(value = "/setrole",method = RequestMethod.PUT)
    public User setRole(@RequestParam(value = "username") String userName,@RequestParam(value = "rolename") String roleName){
        return userService.setRole(userName,roleName);
    }

    @RequestMapping(value = "/removerole",method = RequestMethod.DELETE)
    public User removeRole(@RequestParam(value = "username") String userName,@RequestParam(value = "rolename") String roleName){
        return userService.removeRole(userName,roleName);
    }
//    @RequestMapping(value = "/removerole",method = RequestMethod.DELETE)
//    public User removeRole(@RequestParam(value = "userId") Long userId,@RequestParam(value = "roleId") Long roleId){
//         return userService.removeRole(userId,roleId);
//}

}
