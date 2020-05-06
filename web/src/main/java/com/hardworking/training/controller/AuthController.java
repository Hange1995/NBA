package com.hardworking.training.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.hardworking.training.jsonview.Views;
import com.hardworking.training.model.Role;
import com.hardworking.training.model.User;
import com.hardworking.training.service.JWTService;
import com.hardworking.training.service.RoleService;
import com.hardworking.training.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired JWTService jwtService;
    @Autowired UserService userService;
    @Autowired RoleService roleService;


    @RequestMapping(value = "",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody User user){
        try {
            User u = userService.getUserByCredentials(user.getEmail(),user.getPassword());
            if (u==null) return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).build();
            return ResponseEntity.ok().body(jwtService.generateToken(u));

        }catch (Exception e){
            e.printStackTrace();
        }return ResponseEntity.notFound().build();
    }

    @JsonView(Views.UserView.class)
    @RequestMapping(value = "/signUp",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity signUp(@RequestBody User user){
        try{
            if (userService.getUserByName(user.getName())!=null||userService.getUserByName(user.getEmail())!=null){
                return ResponseEntity.ok().body("The user name or email address is already registered");
            }
            List<Role> roleList=new ArrayList<>();
            roleList.add(roleService.getRoleByName("user"));
            user.setRoles(roleList);
            User u= userService.saveUser(user);
            if (u==null) return ResponseEntity.ok().body("Can't not create user");
            return ResponseEntity.ok().body(u);
        }catch (Exception e){
            e.printStackTrace();
        }return ResponseEntity.ok().body("Can't not create user");
    }


}
