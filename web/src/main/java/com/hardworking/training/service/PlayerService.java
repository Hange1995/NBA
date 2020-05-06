package com.hardworking.training.service;

import com.hardworking.training.model.Player;
import com.hardworking.training.repository.PlayerDao;
import com.hardworking.training.repository.SeasonDataDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlayerService {
    @Autowired
    private PlayerDao playerDao;

    @Autowired
    SeasonDataDao seasonDataDao;

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

    public Set<Player> getAllPlayerWhoHasXpointsScoreCurrentSeason(Double score,Long season){return playerDao.getAllPlayerWhoHasXpointsScoreYSeason(score,season);}

    //This way is gonna use comparator to sort the result.
    public SortedSet<Player> getAllPlayerAndCurrentSeasonDataInOrder(){
        Set<Player> unsorted=playerDao.getAllPlayerAndCurrentSeasonData();
        //Double score1 = playerDataDao.getXSeasonPlayerDataForPlayer(p1.getId(),2020L).getScore()
//        Comparator<Player> byScore=(p1,p2)->(int) (playerDataDao.getXSeasonPlayerDataForPlayer(p1.getId(),2020L).getScore() -
//                playerDataDao.getXSeasonPlayerDataForPlayer(p2.getId(),2020L).getScore());
//        SortedSet<Player> sortedSet=new TreeSet<Player>(byScore);
        SortedSet<Player> sortedSet=new TreeSet<Player>(new SortByScore());
        sortedSet.addAll(unsorted);
        return sortedSet;
    }

    //This was is gonna use hql to sort this result.
//    public List<Player> getAllPlayerAndCurrentSeasonDataInOrder(){
//        return playerDao.getAllPlayerAndCurrentSeasonDataInOrder();
//    }


}

