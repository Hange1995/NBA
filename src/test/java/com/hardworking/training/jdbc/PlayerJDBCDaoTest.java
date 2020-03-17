package com.hardworking.training.jdbc;

import com.hardworking.training.model.Player;
import org.junit.*;
import java.util.List;

public class PlayerJDBCDaoTest {
    private PlayerJDBCDao playerJDBCDao;
    @Before
    public void init() {
        playerJDBCDao = new PlayerJDBCDao();
        Player p = new Player();
        p.setId(5);
        p.setName("JB");
        p.setFirstName("Jimmy");
        p.setLastName("Butler");
        p.setWeight(104);
        p.setHight(201);
        p.setTeam("Heats");
        p.setPositionId(2);
        p.setTeamId(1);
        playerJDBCDao.save(p);
    }
    @After
    public void delete(){
        Player p = new Player();
        p.setTeamId(5);
        p.setName("JB");
        p.setFirstName("Jimmy");
        p.setLastName("Butler");
        p.setWeight(104);
        p.setHight(201);
        p.setTeam("Heats");
        p.setPositionId(2);
        p.setTeamId(1);
        playerJDBCDao = new PlayerJDBCDao();
        playerJDBCDao.delete(p);
    }

    @Test
    public void getPlayersTest(){
        PlayerJDBCDao playerJDBCDao = new PlayerJDBCDao();
        List<Player> players = playerJDBCDao.getPlayers();
        int expectedNumofPlayer = 5;
        Assert.assertEquals(expectedNumofPlayer,players.size());
    }

}
