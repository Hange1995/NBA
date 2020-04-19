package com.hardworking.training.service;

import com.hardworking.training.model.Player;
import com.hardworking.training.repository.PlayerDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    @Autowired
    private PlayerDao playerDao;

    public Player save(Player player) {
        return playerDao.save(player);
    }

    public List<Player> getPlayer() {
        return playerDao.getPlayers();
    }

    public boolean delete(String name) {
        return playerDao.delete(name);
    }

    public Player update(Player player) {
        return playerDao.update(player);
    }

    //TODO: Unit Test
    public Player update(Long id, Player newPlayer) {
        Player oldPlayer=playerDao.getPlayerById(id);
        BeanUtils.copyProperties(newPlayer, oldPlayer, "id","team", "position");
        return playerDao.update(oldPlayer);
    }

    public Player getPlayerByName(String name) {
        return playerDao.getPlayerByName(name);
    }

    public Player getPlayerById(Long id){ return playerDao.getPlayerById(id);}

    public Player getPlayerAndData(String name){ return playerDao.getPlayerData(name);}

    public Set<Player> getAllPlayerAndCurrentSeasonData(){ return playerDao.getAllPlayerAndCurrentSeasonData(); }

    public Set<Player> getAllPlayerAndAllSeasonData(){return playerDao.getAllPlayerAndData();}

    public Set<Player> getAllPlayerWhoHasXpointsScoreCurrentSeason(Double score){return playerDao.getAllPlayerWhoHasXpointsScoreCurrentSeason(score);}

    public SortedSet<Player> getAllPlayerAndCurrentSeasonDataInOrder(){
        Set<Player> unsorted=playerDao.getAllPlayerAndCurrentSeasonData();
        Comparator<Player> byScore=(p1,p2)->(int)(p1.getCurrentSeasonPlayerData().getScore()-p2.getCurrentSeasonPlayerData().getScore());
        SortedSet<Player> sortedSet=new TreeSet<Player>(byScore);
        sortedSet.addAll(unsorted);
        return sortedSet;
    }


}

