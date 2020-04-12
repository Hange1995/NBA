package com.hardworking.training.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.hardworking.training.jsonview.Views;
import com.hardworking.training.model.Team;
import com.hardworking.training.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = {"/teams","/team","/tm"})
public class TeamController {
    @Autowired
    private TeamService teamService;
    //{prefix}/teams POST
    @RequestMapping(value = {""},method = RequestMethod.POST)
    public Team save(@RequestBody Team team){
        Team team1= teamService.save(team);
        if (team1==null) System.out.println("Create failed");
        return team1;
    }
    //{prefix}/teams DELETE
    @RequestMapping(value = {""},method = RequestMethod.DELETE)
    public boolean delete(@RequestParam String name){
        return teamService.delete(name);
    }
    //{prefix}/teams/{id} GET
    @JsonView(Views.TeamView.class)
    @RequestMapping(value = {"/{id}"},method = RequestMethod.GET)
    public Team getTeamEagerBy(@PathVariable(value = "id") Long id){
        return teamService.getTeamEagerBy(id);
    }
//    //get team lazy by
//    @RequestMapping(value = {""},method = RequestMethod.GET )
//    public Team getTeamBy(Long id){
//    return teamService.getTeamBy(id);
//    }

    //{prefix}/teams PUT
    @RequestMapping(value = {""},method = RequestMethod.PUT)
    public Team update(@RequestBody Team team){
        Team teamup=teamService.update(team);
        if (teamup==null) System.out.println("The update is failed");
        return teamup;
    }

    //{prefix}/teams/players?value = key GET
    @JsonView(Views.TeamView2.class)
    @RequestMapping(value = {"/players"},method = RequestMethod.GET)
    public Team getTeamNameAndPlayers(@RequestParam(value = "name") String teamName){
        return teamService.getTeamNameAndPlayers(teamName);
    }

    //g{prefix}/teams/positions?key = value GET
    @JsonView(Views.TeamView3.class)
    @RequestMapping(value = {"/positions"},method = RequestMethod.GET)
    public Set<Team> getTeamNameAndPlayersAndPosition(@RequestParam(value = "name") String teamName){
        return teamService.getTeamNameAndPlayersAndPosition(teamName);
    }
    @JsonView(Views.PlayerDataView.class)
    @RequestMapping(value = "/data",method = RequestMethod.GET)
    public Team getTeamAndPlayerAndDataByName(@RequestParam(value = "name")String name){
        return teamService.getTeamAndPlayerAndDataByName(name);
    }
}
