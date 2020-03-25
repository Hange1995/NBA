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
        playerDao.delete(p1);
        playerDao.delete(p2);
        teamDao.delete(t1);
    }

    @Test
    public void getTeamEagerByTest(){
        Team team = teamDao.getTeamEagerBy(t1.getId());
        Assert.assertNotNull(team);
        Assert.assertEquals(team.getName(),t1.getName());
        Assert.assertTrue(team.getPlayer().size()>1);
    }



}
