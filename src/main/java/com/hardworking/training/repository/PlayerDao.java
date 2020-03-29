package com.hardworking.training.repository;

import com.hardworking.training.model.Player;

import java.util.List;

public interface PlayerDao {
    Player save(Player player);
    List<Player> getPlayers();
    boolean delete(Player player );
    Player update(Player player);
    Player getPlayerByName(String name);



}