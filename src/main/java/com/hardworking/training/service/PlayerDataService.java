package com.hardworking.training.service;

import com.hardworking.training.repository.PlayerDataDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerDataService {
    private Logger logger = LoggerFactory.getLogger(PlayerDataService.class);
    @Autowired PlayerDataDao playerDataDao;

    
}
