package com.hardworking.training.jdbc;

import com.hardworking.training.model.Player;
import org.junit.*;

import java.util.List;

public class PlayerJDBCDAOTest {
    private PlayerJDBCDAO playerJDBCDAO;
    @Before
    public void init(){ playerJDBCDAO = new PlayerJDBCDAO();}
    @Test
    public void getPlayersTest(){
        List<Player> players = playerJDBCDAO.getPlayers();
        int expectedNumofPlayer = 9;
        Assert.assertEquals(expectedNumofPlayer,players.size());
    }

}
