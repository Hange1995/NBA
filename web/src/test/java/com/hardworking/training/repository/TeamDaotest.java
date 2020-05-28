package com.hardworking.training.repository;

import com.hardworking.training.init.AppBootstrap;
import com.hardworking.training.model.Player;
import com.hardworking.training.model.Team;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppBootstrap.class)
public class TeamDaotest {
    @Autowired
    private TeamDao teamDao;
    @Autowired
    private PlayerDao playerDao;
    private Team t1;
    private Player p1;
    private Player p2;
    private Team team = new Team();
    @Before
    public void init(){
//        teamDaoImpl= new TeamDaoImpl();
//        playerDaoImpl= new PlayerDaoImpl();
        t1= new Team();
        t1.setName("ZJ");
        t1.setLocation("China");
        t1 = teamDao.save(t1);
        p1 = new Player();
        p1.setName("CHG");
        p1.setTeam(t1);
        playerDao.save(p1);
        p2 = new Player();
        p2.setName("MFX");
        p2.setTeam(t1);
        playerDao.save(p2);
    }
    @After
    public void teardown(){
        playerDao.delete(p1.getName());
        playerDao.delete(p2.getName());
        teamDao.delete(t1.getName());
    }

    @Test
    public void getTeamEagerByTest(){
        Team team = teamDao.getTeamEagerBy(t1.getId());
        Assert.assertNotNull(team);
        Assert.assertEquals(team.getName(),t1.getName());
        Assert.assertTrue(team.getPlayer().size()>1);
    }

    @Test
    public void getTeamAndPlayers(){
        String teamname="Heat";
        Team team = teamDao.getTeamNameAndPlayers(teamname);
        Assert.assertTrue(teamname.equals(team.getName()));
    }
    @Test
    public void getTeamAndPlayerAndPosition(){
        String teamname="Heat";
//        long id = 1;
        Set<Team> playerList = teamDao.getTeamNameAndPlayersAndPosition(teamname);
        Assert.assertEquals(1,playerList.size());
    }
    @Test
    public void updateTest(){
        t1.setLocation("XXX");
        teamDao.update(t1);
        Assert.assertEquals("XXX",t1.getLocation());
    }



}