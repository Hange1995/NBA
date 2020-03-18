package com.hardworking.training.repository;

import com.hardworking.training.model.Player;
import com.hardworking.training.model.Team;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TeamDaotest {
    private TeamDao teamDaoImpl;
    private PlayerDao playerDaoImpl;
    private Team t1;
    private Player p1;
    private Player p2;
    private Team team = new Team();
    @Before
    public void init(){
        teamDaoImpl= new TeamDaoImpl();
        playerDaoImpl= new PlayerDaoImpl();
        t1= new Team();
        t1.setName("ZJ");
        t1.setLocation("China");
        t1 = teamDaoImpl.save(t1);
        p1 = new Player();
        p1.setName("CHG");
        p1.setTeam(t1);
        playerDaoImpl.save(p1);
        p2 = new Player();
        p2.setName("MFX");
        p2.setTeam(t1);
        playerDaoImpl.save(p2);
    }
    @After
    public void teardown(){
        playerDaoImpl.delete(p1);
        playerDaoImpl.delete(p2);
        teamDaoImpl.delete(t1);
    }

    @Test
    public void getTeamEagerByTest(){
        Team team = teamDaoImpl.getTeamEagerBy(t1.getId());
        Assert.assertNotNull(team);
        Assert.assertEquals(team.getName(),t1.getName());
        Assert.assertTrue(team.getPlayer().size()>5);
    }



}
