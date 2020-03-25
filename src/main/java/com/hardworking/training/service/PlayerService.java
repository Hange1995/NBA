package com.hardworking.training.service;

import com.hardworking.training.model.Player;
import com.hardworking.training.repository.PlayerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlayerService {
    @Autowired
    private PlayerDao playerDao;
    public Player save(Player player){
        return playerDao.save(player);
    }
    public List<Player> getPlayer(){
        return playerDao.getPlayers();
    }
    public boolean delete(Player player){
        return playerDao.delete(player);
    }
}
