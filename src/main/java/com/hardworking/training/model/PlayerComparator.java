package com.hardworking.training.model;

import java.util.Comparator;

public class PlayerComparator {
    static class SortByScore implements Comparator<Player>{
        @Override
        public int compare(Player o1, Player o2) {
            return (int)(o2.getCurrentSeasonPlayerData().getScore()-o1.getCurrentSeasonPlayerData().getScore());
        }
    }
    class SortBySteal implements Comparator<Player>{

        @Override
        public int compare(Player o1, Player o2) {
            return (int)(o2.getCurrentSeasonPlayerData().getSteal()-o1.getCurrentSeasonPlayerData().getSteal());
        }
    }
    class SortByBlock implements Comparator<Player>{

        @Override
        public int compare(Player o1, Player o2) {
            return (int)(o2.getCurrentSeasonPlayerData().getBlock()-o1.getCurrentSeasonPlayerData().getBlock());
        }
    }
    class SortByAssistance implements Comparator<Player>{

        @Override
        public int compare(Player o1, Player o2) {
            return (int)(o2.getCurrentSeasonPlayerData().getAssistant()-o1.getCurrentSeasonPlayerData().getAssistant());
        }
    }
    class SortByAppearance implements Comparator<Player>{

        @Override
        public int compare(Player o1, Player o2) {
            return (int)(o2.getCurrentSeasonPlayerData().getAppearances()-o1.getCurrentSeasonPlayerData().getAppearances());
        }
    }
}
