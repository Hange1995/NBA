package com.hardworking.training.controller;

import com.hardworking.training.model.Image;
import com.hardworking.training.model.User;
import com.hardworking.training.service.FileService;
import com.hardworking.training.service.ImageService;
import com.hardworking.training.service.JWTService;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@RestController
@RequestMapping(value = "/files")
public class FileController {

    @Autowired
    FileService fileService;
    @Autowired
    JWTService jwtService;
    @Autowired
    ImageService imageService;


    Logger logger= LoggerFactory.getLogger("file");

    @RequestMapping(value = "",method = RequestMethod.POST)
    public void uploadFile(@RequestParam("file") MultipartFile file, ServletRequest servletRequest){
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String token = req.getHeader("Authorization").replaceAll("^(.*?) ", "");
        Claims claims = jwtService.decyptToken(token);
        logger.info("Upload file: "+file.getOriginalFilename());
        try {
            Image image=new Image();
            String url = fileService.uploadFile(file);
            HttpSession session = req.getSession();
            User user= (User) session.getAttribute("user");
            image.setFileName(file.getOriginalFilename());
            image.setUser(user);
            image.setS3key(url);
            image.setUploadTime(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
            imageService.save(image);
            System.out.println(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
