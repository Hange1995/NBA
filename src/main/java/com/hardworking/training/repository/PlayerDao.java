package com.hardworking.training.repository;

import com.hardworking.training.model.Player;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public interface PlayerDao {
    Player save(Player player);
    List<Player> getPlayers();
    boolean delete(String name );
    Player update(Player player);
    Player getPlayerByName(String name);
    Player getPlayerById(Long id);
    Player getPlayerData(String name);
    TreeSet<Player> getAllPlayerAndCurrentSeasonData();
    Set<Player> getAllPlayerAndData();
    Set<Player> getAllPlayerWhoHasXpointsScoreCurrentSeason(Double score);

}
