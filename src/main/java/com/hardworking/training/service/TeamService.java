package com.hardworking.training.service;

import com.hardworking.training.model.Team;
import com.hardworking.training.repository.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    private TeamDao teamDao;
    public Team save(Team team){
        return teamDao.save(team);
    }
    public boolean delete(Team team){
        return teamDao.delete(team);
    }
    public Team getTeamEagerBy(Long id){
        return teamDao.getTeamEagerBy(id);
    }
    public Team getTeamBy(Long id){
        return teamDao.getTeamBy(id);
    }
}
