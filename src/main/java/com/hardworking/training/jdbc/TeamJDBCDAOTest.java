package com.hardworking.training.jdbc;

import com.hardworking.training.model.Team;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TeamJDBCDAOTest {
    private TeamJDBCDAO teamJDBCDAO;
    @Before
    public void init(){teamJDBCDAO= new TeamJDBCDAO();}
    @Test
    public void getTeams(){
        List<Team> teams = teamJDBCDAO.getTeams();
        int expectedNumofPlayer = 3;
        Assert.assertEquals(expectedNumofPlayer, teams.size());

    }

}
