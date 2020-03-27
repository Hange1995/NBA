package com.hardworking.training.repository;

import com.hardworking.training.init.AppBootstrap;
import com.hardworking.training.model.Player;
import com.hardworking.training.model.Position;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppBootstrap.class)
public class PositionDaoTest {
    @Autowired
    private PlayerDao playerDao;
    @Autowired
    private PositionDao positionDao;
    private Position po1;
    private Player p1;
    private Player p2;
    private Position position = new Position();
    @Before
    public void init(){
//        positionDaoImpl= new PositionDaoImpl();
//        playerDaoImpl= new PlayerDaoImpl();
        po1= new Position();
        po1.setDescription("xxx");
        po1.setPositionName("X");
        po1 = positionDao.save(po1);
        p1 = new Player();
        p1.setName("CHG");
        p1.setPosition(po1);
        playerDao.save(p1);
        p2 = new Player();
        p2.setName("MFX");
        p2.setPosition(po1);
        playerDao.save(p2);
    }
    @After
    public void deardown(){
        playerDao.delete(p1);
        playerDao.delete(p2);
        positionDao.delete(po1);
    }
    @Test
    public void getPositionEagerBy(){
        Position position = positionDao.getPositionEagerBy(po1.getId());
        Assert.assertNotNull(position);
        Assert.assertEquals(position.getPositionName(),po1.getPositionName());
        Assert.assertTrue(position.getPlayer().size()>1);
    }

    @Test
    public void getPositionBy(){
        Position position = positionDao.getPositionBy(po1.getId());
        Assert.assertNotNull(position);
        Assert.assertEquals(position.getPositionName(),po1.getPositionName());
        Assert.assertTrue(position.getPlayer().size()>1);
    }
    @Test
    public void getPositionAndPlayers(){
        String posName="PG";
        List<Object[]> playerList = positionDao.getPositionAndPlayers(posName);
        Assert.assertEquals(1,playerList.size());
    }
}
