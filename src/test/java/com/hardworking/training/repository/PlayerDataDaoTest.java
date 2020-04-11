package com.hardworking.training.repository;

import com.hardworking.training.init.AppBootstrap;
import com.hardworking.training.model.Player;
import com.hardworking.training.model.PlayerData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppBootstrap.class)
public class PlayerDataDaoTest {
    @Autowired PlayerDataDao playerDataDao;
    @Autowired PlayerDao playerDao;

    Player player= new Player();
    PlayerData playerData= new PlayerData();
    @Before
    public void init(){
        player.setName("HG");
        player.setFirstName("Hange");
        player.setLastName("Chen");
        player.setWeight(75);
        player.setHeight(180);
        playerDao.save(player);
        playerData.setScore(100.0);
        playerData.setSeason(2019L);
        playerData.setSalary(10_0000.0);
        playerDataDao.create(playerData);
    }

    @After
    public void tearDown(){
        playerDataDao.delete(playerData.getId());
        playerDao.delete(player.getName());
    }

    @Test
    public void getPlayerDataTest(){
        Set<PlayerData> result = playerDataDao.getPlayerData();
        Assert.assertEquals(1,result.size());
    }
}
