package com.hardworking.training.repository;


import com.hardworking.training.model.Player;
import com.hardworking.training.model.Team;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PlayerDaoTest {
    private PlayerDao playerDaoImpl;
    private Player p= new Player();
    @Before
    public void init() {
        playerDaoImpl = new PlayerDaoImpl();
        p.setName("JB");
        p.setFirstName("Jimmy");
        p.setLastName("Butler");
        p.setWeight(104);
        p.setHeight(201);
//        p.setTeam("Heats");
//        p.setPositionId(2);
//        p.setTeamId(1);
        playerDaoImpl.save(p);
    }
    @After
    public void tearDown(){
//        playerDaoImpl = new PlayerDaoImpl();
        playerDaoImpl.delete(p);
    }

    @Test
    public void getPlayersTest(){
        List<Player> players = playerDaoImpl.getPlayers();
        int expectedNumofPlayer = 5;
        Assert.assertEquals(expectedNumofPlayer,players.size());
    }

}
