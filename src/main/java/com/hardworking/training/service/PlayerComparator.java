package com.hardworking.training.service;

import com.hardworking.training.model.Player;
import com.hardworking.training.repository.SeasonDataDao;

import com.hardworking.training.repository.SeasonDataDaoImpl;

import java.util.Comparator;
import java.util.stream.Collectors;

public class PlayerComparator {

}
//    @Service
    class SortByScore implements Comparator<Player> {
//        @Autowired PlayerDataDao playerDataDao;
        SeasonDataDao seasonDataDao =new SeasonDataDaoImpl();
        @Override
        public int compare(Player o1, Player o2) {
            return (int) (            o1.getSeasonData()
                                        .stream()
                                        .filter(playerData -> playerData.getSeason()==2020L)
                                        .collect(Collectors.toList())
                                        .get(0).getScore()
                                         -
                                    o2.getSeasonData()
                                            .stream()
                                            .filter(playerData -> playerData.getSeason()==2020L)
                                            .collect(Collectors.toList())
                                            .get(0).getScore());
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
