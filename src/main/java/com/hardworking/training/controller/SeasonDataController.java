package com.hardworking.training.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.hardworking.training.jsonview.Views;
import com.hardworking.training.model.SeasonData;
import com.hardworking.training.service.SeasonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = {"/playerdata", "/data"})
public class SeasonDataController {
    @Autowired
    private SeasonDataService seasonDataService;

    @JsonView(Views.PlayerDataView.class)
    @RequestMapping(value = "",method = RequestMethod.POST)
    public SeasonData create(@RequestBody SeasonData seasonData){
        return seasonDataService.create(seasonData);
    }
    @JsonView(Views.PlayerDataView.class)
    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public boolean delete(@RequestParam("id") Long id){
        return seasonDataService.delete(id);
    }
    @JsonView(Views.PlayerDataView.class)
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public SeasonData update(@RequestBody SeasonData seasonData){
        SeasonData update= seasonDataService.update(seasonData);
        return update;
    }
    @JsonView(Views.PlayerDataView.class)
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Set<SeasonData> getAllPlayerData(){
        return seasonDataService.get();
    }

    @JsonView(Views.PlayerDataView.class)
    @RequestMapping(value = "/season",method = RequestMethod.GET)
    public SeasonData getXSeasonPlayerDataForPlayer(@RequestParam("id") Long id, @RequestParam("season") Long season){
        return seasonDataService.getXSeasonPlayerDataForPlayer(id,season);
    }

//    @JsonView(Views.PlayerDataView.class)
//    @RequestMapping(value = "/score",method = RequestMethod.GET)
//    public Set<PlayerData> findPlayerDataScoreHigherThan(@RequestParam("score") Double score){
//        return playerDataService.getScoreGreatThan(score);
//    }
//    @JsonView(Views.PlayerDataView.class)
//    @RequestMapping(value = "/steal",method = RequestMethod.GET)
//    public Set<PlayerData> findPlayerDataStealHigherThan(@RequestParam("steal") Double steal){
//        return playerDataService.getScoreGreatThan(steal);
//    }

}
