package com.hardworking.training.service;

import com.hardworking.training.model.SeasonData;
import com.hardworking.training.repository.SeasonDataDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SeasonDataService {
    private Logger logger = LoggerFactory.getLogger(SeasonDataService.class);
    @Autowired
    SeasonDataDao seasonDataDao;

    public SeasonData create(SeasonData seasonData){return seasonDataDao.create(seasonData);}

    public boolean delete(Long id){return seasonDataDao.delete(id);}

    public SeasonData update(SeasonData seasonData){return seasonDataDao.update(seasonData); }

    public Set<SeasonData> get(){return seasonDataDao.getPlayerData();}

    public SeasonData getXSeasonPlayerDataForPlayer(Long playerId, Long season){return seasonDataDao.getXSeasonPlayerDataForPlayer(playerId,season);}


}
