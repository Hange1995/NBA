package com.hardworking.training.service;

import com.hardworking.training.model.Player;
import com.hardworking.training.repository.PlayerDataDao;

import com.hardworking.training.repository.PlayerDataDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
public class PlayerComparator {

}
//    @Service
    class SortByScore implements Comparator<Player> {
//        @Autowired PlayerDataDao playerDataDao;
        PlayerDataDao playerDataDao=new PlayerDataDaoImpl();
        @Override
        public int compare(Player o1, Player o2) {
            return (int) (playerDataDao.getXSeasonPlayerDataForPlayer(o1.getId(),2020L).getScore() -
                    playerDataDao.getXSeasonPlayerDataForPlayer(o2.getId(),2020L).getScore());
        }
    }

//    class SortBySteal implements Comparator<Player> {
//
//        @Override
//        public int compare(Player o1, Player o2) {
//            return (int) (o2.getCurrentSeasonPlayerData().getSteal() - o1.getCurrentSeasonPlayerData().getSteal());
//        }
//    }
//
//    class SortByBlock implements Comparator<Player> {
//
//        @Override
//        public int compare(Player o1, Player o2) {
//            return (int) (o2.getCurrentSeasonPlayerData().getBlock() - o1.getCurrentSeasonPlayerData().getBlock());
//        }
//    }
//
//    class SortByAssistance implements Comparator<Player> {
//
//        @Override
//        public int compare(Player o1, Player o2) {
//            return (int) (o2.getCurrentSeasonPlayerData().getAssistant() - o1.getCurrentSeasonPlayerData().getAssistant());
//        }
//    }
//
//    class SortByAppearance implements Comparator<Player> {
//
//        @Override
//        public int compare(Player o1, Player o2) {
//            return (int) (o2.getCurrentSeasonPlayerData().getAppearances() - o1.getCurrentSeasonPlayerData().getAppearances());
//        }
//    }
