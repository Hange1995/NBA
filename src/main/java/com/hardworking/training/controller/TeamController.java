package com.hardworking.training.controller;

import com.hardworking.training.model.Team;
import com.hardworking.training.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/teams","/team","/tm"})
public class TeamController {
    @Autowired
    private TeamService teamService;
    //save a team to the list
    @RequestMapping(value = {""},method = RequestMethod.POST)
    public Team save(Team team){
        return teamService.save(team);
    }
    //delete a team from the list
    @RequestMapping(value = {""},method = RequestMethod.DELETE)
    public boolean delete(Team team){
        return teamService.delete(team);
    }
    //get team eager by
    @RequestMapping(value = {"/{id}"},method = RequestMethod.GET)
    public Team getTeamEagerBy(@PathVariable(value = "id") Long id){
        return teamService.getTeamEagerBy(id);
    }
//    //get team lazy by
//    @RequestMapping(value = {""},method = RequestMethod.GET )
//    public Team getTeamBy(Long id){
//    return teamService.getTeamBy(id);
//    }
    //update a team in the list

    @RequestMapping(value = {""},method = RequestMethod.PUT)
    public Team update(Team team){
        return teamService.update(team);
    }

    //get a team by name and the player in the team
    @RequestMapping(value = {"/players"},method = RequestMethod.GET)
    public List<Object[]> getTeamNameAndPlayers(@RequestParam(value = "players") String teamName){
        return teamService.getTeamNameAndPlayers(teamName);
    }

    //get a team by name and the player in the team and the position detail of the players
    @RequestMapping(value = {"/players_position"},method = RequestMethod.GET)
    public List<Object[]> getTeamNameAndPlayersAndPosition(@RequestParam(value = "name") String teamName){
        return teamService.getTeamNameAndPlayersAndPosition(teamName);
    }
}
