package com.hardworking.training.service;

import com.hardworking.training.init.AppBootstrap;
import com.hardworking.training.model.Player;
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
public class PlayerServiceTest {
    @Autowired PlayerService playerService;
    private Player player = new Player();

    @Before
    public void init(){
        player.setName("Z3");
        playerService.save(player);
    }
    @After
    public void teardown(){
        playerService.delete(player.getName());
    }
    @Test
    public void getPlayers(){
        List<Player> playerList=  playerService.getPlayer();
        Assert.assertTrue(playerList.size()>=5);
    }
    @Test
    public void getPlayerById(){
        Player playerTest = playerService.getPlayerById(2L);
        Assert.assertEquals("Kobe",playerTest.getName());
    }
    @Test
    public void updateRequestBodyTest(){
        double a =123;
        player.setWeight(a);
        playerService.update(player);
        Assert.assertTrue(a-player.getWeight()==0);
    }

    @Test
    public void updatePathAndRequestBodyTest(){
        player.setWeight(123);
        playerService.update(player.getId(),player);
        Assert.assertTrue(123-player.getWeight()==0);
    }
}
