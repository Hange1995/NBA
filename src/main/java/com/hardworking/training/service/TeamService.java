package com.hardworking.training.service;

import com.hardworking.training.model.Team;
import com.hardworking.training.repository.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class TeamService {
    @Autowired
    private TeamDao teamDao;
    public Team save(Team team){
        return teamDao.save(team);
    }

    public boolean delete(String name){
        return teamDao.delete(name);
    }

    public Team getTeamEagerBy(Long id){ return teamDao.getTeamEagerBy(id); }

    public Team getTeamBy(Long id){
        return teamDao.getTeamBy(id);
    }

    public Team update(Team team){
        return teamDao.update(team);
    }

    public Team getTeamNameAndPlayers(String teamName){
        return teamDao.getTeamNameAndPlayers(teamName);
    }

    public Set<Team> getTeamNameAndPlayersAndPosition(String teamName){
        return teamDao.getTeamNameAndPlayersAndPosition(teamName);
    }
}
