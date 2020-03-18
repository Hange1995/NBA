package com.hardworking.training.repository;

import com.hardworking.training.model.Player;
import com.hardworking.training.model.Position;
import com.hardworking.training.model.Team;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PositionDaoTest {
    private PlayerDao playerDaoImpl;
    private PositionDao positionDaoImpl;
    private Position po1;
    private Player p1;
    private Player p2;
    private Position position = new Position();
    @Before
    public void init(){
        positionDaoImpl= new PositionDaoImpl();
        playerDaoImpl= new PlayerDaoImpl();
        po1= new Position();
        po1.setDescription("xxx");
        po1.setPositionName("X");
        po1 = positionDaoImpl.save(po1);
        p1 = new Player();
        p1.setName("CHG");
        p1.setPosition(po1);
        playerDaoImpl.save(p1);
        p2 = new Player();
        p2.setName("MFX");
        p2.setPosition(po1);
        playerDaoImpl.save(p2);
    }
    @After
    public void deardown(){
        playerDaoImpl.delete(p1);
        playerDaoImpl.delete(p2);
        positionDaoImpl.delete(po1);
    }
    @Test
    public void getPositionEagerBy(){
        Position position = positionDaoImpl.getPositionEagerBy(po1.getId());
        Assert.assertNotNull(position);
        Assert.assertEquals(position.getPositionName(),po1.getPositionName());
        Assert.assertTrue(position.getPlayer().size()>3);
    }

}
