package com.hardworking.training.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.hardworking.training.jsonview.Views;
import com.hardworking.training.model.PlayerData;
import com.hardworking.training.service.PlayerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = {"/playerdata", "/data"})
public class PlayerDataController {
    @Autowired
    private PlayerDataService playerDataService;

    @JsonView(Views.PlayerDataView.class)
    @RequestMapping(value = "",method = RequestMethod.POST)
    public PlayerData create(@RequestBody PlayerData playerData){
        return playerDataService.create(playerData);
    }
    @JsonView(Views.PlayerDataView.class)
    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public boolean delete(@RequestParam("id") Long id){
        return playerDataService.delete(id);
    }
    @JsonView(Views.PlayerDataView.class)
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public PlayerData update(@RequestBody PlayerData playerData){
        PlayerData update= playerDataService.update(playerData);
        return update;
    }
    @JsonView(Views.PlayerDataView.class)
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Set<PlayerData> getAllPlayerData(){
        return playerDataService.get();
    }

    @JsonView(Views.PlayerDataView.class)
    @RequestMapping(value = "/season",method = RequestMethod.GET)
    public PlayerData getXSeasonPlayerDataForPlayer(@RequestParam("id") Long id, @RequestParam("season") Long season){
        return playerDataService.getXSeasonPlayerDataForPlayer(id,season);
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
