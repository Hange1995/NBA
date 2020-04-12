package com.hardworking.training.service;

import com.hardworking.training.model.PlayerData;
import com.hardworking.training.repository.PlayerDataDao;
import com.sun.xml.bind.v2.TODO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Set;

@Service
public class PlayerDataService {
    private Logger logger = LoggerFactory.getLogger(PlayerDataService.class);
    @Autowired PlayerDataDao playerDataDao;

    public PlayerData create(PlayerData playerData){return playerDataDao.create(playerData);}

    public boolean delete(Long id){return playerDataDao.delete(id);}

    public PlayerData update(PlayerData playerData){return playerDataDao.update(playerData); }

    public Set<PlayerData> get(){return playerDataDao.getPlayerData();}
//TODO Fix this
//    public Set<PlayerData> getScoreGreatThan(Double score){
//        Set<PlayerData> value=playerDataDao.getPlayerData();
//        for (PlayerData playerData:value){
//            if (playerData.getScore() < score) {
//                value.remove(playerData);
//            }
//        }return value;
//    }
//
//    public Set<PlayerData> getStealGreatThan(Double steal){
//        Set<PlayerData> value=playerDataDao.getPlayerData();
//        for (PlayerData playerData:value){
//            if (playerData.getScore()<steal) value.remove(playerData);
//        }return value;
//    }



}
