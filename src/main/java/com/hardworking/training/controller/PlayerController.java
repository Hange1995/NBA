package com.hardworking.training.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.hardworking.training.jsonview.Views;
import com.hardworking.training.model.Player;
import com.hardworking.training.model.PlayerComparator;
import com.hardworking.training.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.JoinColumn;
import java.util.*;

@RestController
@RequestMapping(value = {"/players","/player","/pla"})
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    //{prefix}/players POST create a new player.
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Player save(@RequestBody Player player) {
        Player pla=playerService.save(player);
        if (pla==null) System.out.println("Player is not created yet");
        return pla;
    }

    //{prefix}/players?key=value DELETE player by name.
    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public boolean delete(@RequestParam(value = "name") String name) {
        return playerService.delete(name);
    }

    //update the player's name by it's id. update player
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public Player update(@RequestBody Player player) {
        Player updatepla = playerService.update(player);
        if (updatepla==null) System.out.println("The update is failed");
        return updatepla;
    }

    //{prefix}/players/{id} PUT, update the whole player by it's id.
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Player newPlayer) {
        Player updatePla = playerService.update(id,newPlayer);
        if (updatePla==null) System.out.println("The update is failed");
        return ResponseEntity.ok(updatePla);
    }
    // {prefix}/players GET, get the list of the player.
    @JsonView(Views.PositionView.class)
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Player> getPlayer() {
        return playerService.getPlayer();
    }

    //{prefix}/players/name?key=value GET get the player by specific name
    @JsonView(Views.PlayerView.class)
    @RequestMapping(value = "/name",method = RequestMethod.GET)
    public Player getPlayerByName(@RequestParam(value = "name") String name) {
        return playerService.getPlayerByName(name);
    }

    //{prefix}/players/{id}?key=value PATCH, update the player's name by it's id.
    @RequestMapping(value = "/{id}",method = RequestMethod.PATCH)
    public Player update(@PathVariable("id") Long Id, @RequestParam("teamName") String teamName) {
        Player player = playerService.getPlayerById(Id);
//        player.setTeamName(teamName);
        player = playerService.update(player);
        return player;
    }
    //{prefix}/players/data GET, get all players and all season data.
    @JsonView(Views.PlayerDataView.class)
    @RequestMapping(value = "/data",method = RequestMethod.GET)
    public Set<Player> getAllPlayerAndAllSeasonData(){
        return playerService.getAllPlayerAndAllSeasonData();
    }
    //{prefix}/players/data?key=value GET, get player by name and all season data of this player.
    @JsonView(Views.PlayerDataView.class)
    @RequestMapping(value = "/data/name",method = RequestMethod.GET)
    public Player getPlayerAndAllSeasonDataByName(@RequestParam("name")String name ){
        return playerService.getPlayerAndData(name);
    }
    //{prefix}/players/data/current GET, get all player and current season data of this player.
    @JsonView(Views.PlayerDataView.class)
    @RequestMapping(value = "/data/current",method = RequestMethod.GET)
    public Set<Player> getAllPlayerAndCurrentSeasonData(){
        return playerService.getAllPlayerAndCurrentSeasonData();
    }
    @JsonView(Views.PlayerDataView.class)
    @RequestMapping(value = "/data/current/score",method = RequestMethod.GET)
    public Set<Player> getAllPlayerWhoHasXpointsScoreCurrentSeason(@RequestParam("score") Double score){
        Set<Player> players= playerService.getAllPlayerWhoHasXpointsScoreCurrentSeason(score);
        if (players.size()==0){
            System.out.println("there is no player have such high score");
        }
        return players;
    }

    @JsonView(Views.PlayerDataView.class)
    @RequestMapping(value = "/data/current/sorted",method = RequestMethod.GET)
    public SortedSet<Player> getAllPlayerAndCurrentSeasonDataInOrder(){
        return playerService.getAllPlayerAndCurrentSeasonDataInOrder();
    }
   
}
