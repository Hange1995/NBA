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
        playerService.delete(player);
    }
    @Test
    public void getPlayers(){
        List<Player> playerList=  playerService.getPlayer();
        Assert.assertEquals(5,playerList.size());
    }
}
