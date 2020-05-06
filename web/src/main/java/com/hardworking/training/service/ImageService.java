package com.hardworking.training.service;

import com.hardworking.training.model.Image;
import com.hardworking.training.repository.ImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    ImageDao imageDao;

    public Image save(Image image){return imageDao.save(image);}
}
