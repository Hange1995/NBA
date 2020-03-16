package com.hardworking.training.jdbc;

import com.hardworking.training.model.Player;
import org.junit.*;
import java.util.ArrayList;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class PlayerJDBCDaoTest {
    private PlayerJDBCDao playerJDBCDAO;
    @Before
    public void init() {
        playerJDBCDAO = new PlayerJDBCDao();
        Player p = new Player();
        p.setTeam_id(6);
        p.setName("Jimmy Butler");
        p.setFirst_name("Jimmy");
        p.setLast_name("Butler");
        p.setWeight(104);
        p.setHight(201);
        p.setTeam("Heats");
        p.setPosition_id(2);
        p.setTeam_id(1);
        playerJDBCDAO.save(p);
    }
    @After
    public void delete(){
        playerJDBCDAO = new PlayerJDBCDao();
        playerJDBCDAO.delete();
    }

    @Test
    public void getPlayersTest(){
        List<Player> players = playerJDBCDAO.getPlayers();
        int expectedNumofPlayer = 9;
        Assert.assertEquals(expectedNumofPlayer,players.size());
    }

}
