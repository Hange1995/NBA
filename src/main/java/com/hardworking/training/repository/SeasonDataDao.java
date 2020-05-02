package com.hardworking.training.repository;

import com.hardworking.training.model.SeasonData;


import java.util.Set;

public interface SeasonDataDao {
    SeasonData create(SeasonData seasonData);
    boolean delete(Long id);
    SeasonData update(SeasonData seasonData);
    Set<SeasonData> getPlayerData();
    SeasonData getXSeasonPlayerDataForPlayer(Long playerId, Long season);
}
