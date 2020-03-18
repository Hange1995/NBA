package com.hardworking.training.jdbc;

import com.hardworking.training.model.Position;
import com.hardworking.training.model.Team;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TeamJDBCDaoTest {
    private TeamJDBCDao teamJDBCDao;
    @Before
    public void init() {
        teamJDBCDao = new TeamJDBCDao();
        Team team = new Team();
        team.setId(6);
        team.setLocation("JB");
        team.setName("Jimmy");
        teamJDBCDao.add(team);
    }
    @After
    public void delete(){
        teamJDBCDao = new TeamJDBCDao();
        Team team = new Team();
        team.setId(6);
        team.setLocation("JB");
        team.setName("Jimmy");
        teamJDBCDao.delete(team);
    }
    @Test
    public void getTeams(){
        List<Team> teams = teamJDBCDao.getTeams();
        int expectedNumoTeam = 3;
        Assert.assertEquals(expectedNumoTeam, teams.size());

    }

}
