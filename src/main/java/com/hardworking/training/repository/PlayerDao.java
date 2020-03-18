package com.hardworking.training.repository;

import com.hardworking.training.model.Player;

import java.util.List;

public interface PlayerDao {
    Player save(Player player);
    List<Player> getPlayers();

//    Player update (Player player);
    boolean delete(Player player );

}
