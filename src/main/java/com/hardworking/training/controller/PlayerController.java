package com.hardworking.training.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.hardworking.training.jsonview.Views;
import com.hardworking.training.model.Player;
import com.hardworking.training.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/players","/player","/pla"})
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    // Player save
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Player save(@RequestBody Player player) {
        Player pla=playerService.save(player);
        if (pla==null) System.out.println("Player is not created yet");
        return pla;
    }
    //delete player
    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public boolean delete(@RequestParam(value = "name") String name) {
        return playerService.delete(name);
    }
    //update player
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public Player update(@RequestBody Player player) {
        Player updatepla = playerService.update(player);
        if (updatepla==null) System.out.println("The update is failed");
        return updatepla;
    }
    // Get player
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Player> getPlayer() {
        return playerService.getPlayer();
    }
    //get the player by specific name
    @RequestMapping(value = "/name",method = RequestMethod.GET)
    public Player getPlayerByName(@RequestParam(value = "name") String name) {
        return playerService.getPlayerByName(name);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PATCH)
    public Player update(@PathVariable("id") Long Id, @RequestParam("teamName") String teamName) {
        Player player = playerService.getPlayerById(Id);
//        player.setTeamName(teamName);
        player = playerService.update(player);
        return player;
    }
}
