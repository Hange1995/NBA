package com.hardworking.training.controller;


import com.hardworking.training.model.User;
import com.hardworking.training.service.JWTService;
import com.hardworking.training.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired JWTService jwtService;
    @Autowired UserService userService;


    @RequestMapping(value = "",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody User user){
        try {
//            String digestPassword= DigestUtils.md5Hex(.trim());
            User u = userService.getUserByCredentials(user.getEmail(),user.getPassword());
            if (u==null) return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).build();
            return ResponseEntity.ok().body(jwtService.generateToken(u));

        }catch (Exception e){
            e.printStackTrace();
        }return ResponseEntity.notFound().build();
    }
}
