package com.hardworking.training.jdbc;

import com.hardworking.training.model.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PlayerJDBCDAOTest {
    private PlayerJDBCDAO playerJDBCDAO;

    @Before
    public void init(){playerJDBCDAO=new PlayerJDBCDAO();}
    @Test
    public void getPLayersTest(){
        List<Player> players = playerJDBCDAO.getPlayers();
        int expectedNumOfPlayer = 4;
        Assert.assertEquals(expectedNumOfPlayer,players.size());
    }

}
