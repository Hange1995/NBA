package com.hardworking.training.jdbc;

import com.hardworking.training.model.Player;
import org.junit.*;

import java.util.List;

public class PlayerJDBCDaoTest {
    private PlayerJDBCDao playerJDBCDAO;
    @Before
    public void init(){ playerJDBCDAO = new PlayerJDBCDao();}
    @Test
    public void getPlayersTest(){
        List<Player> players = playerJDBCDAO.getPlayers();
        int expectedNumofPlayer = 9;
        Assert.assertEquals(expectedNumofPlayer,players.size());
    }

}
