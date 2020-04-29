package com.hardworking.training.repository;

import com.hardworking.training.model.PlayerData;


import java.util.Set;

public interface PlayerDataDao {
    PlayerData create(PlayerData playerData);
    boolean delete(Long id);
    PlayerData update(PlayerData playerData);
    Set<PlayerData> getPlayerData();
    PlayerData getXSeasonPlayerDataForPlayer(Long playerId,Long season);
}
