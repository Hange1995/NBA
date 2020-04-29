package com.hardworking.training.controller;

import com.hardworking.training.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/files")
public class FileController {

    @Autowired
    FileService fileService;

    Logger logger= LoggerFactory.getLogger("file");

    @RequestMapping(value = "",method = RequestMethod.POST)
    public void uploadFile(@RequestParam("file") MultipartFile file){
        logger.info("Upload file: "+file.getOriginalFilename());
        try {
            fileService.uploadFile("bucket-for-hange",file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
