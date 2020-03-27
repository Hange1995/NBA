package com.hardworking.training.controller;

import com.hardworking.training.model.Player;
import com.hardworking.training.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/players","/player","/pla"})
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    // Player save
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Player save(Player player) { return playerService.save(player); }
    // Get player
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Player> getPlayer() { return playerService.getPlayer(); }
    //delete player
    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public boolean delete(Player player) { return playerService.delete(player); }
    //update player
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public Player update(Player player) { return playerService.update(player); }
    //get the player by specific name
    @RequestMapping(value = "{/name}",method = RequestMethod.GET)
    public Player getPlayerByName(String name) { return playerService.getPlayerByName(name); }

}
