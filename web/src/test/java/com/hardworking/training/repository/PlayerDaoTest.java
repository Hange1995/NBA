//package com.hardworking.training.repository;
//
//
//import com.hardworking.training.init.AppBootstrap;
//import com.hardworking.training.model.Player;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AppBootstrap.class)
//public class PlayerDaoTest {
//    @Autowired
//    private PlayerDao playerDao;
//
//    private Player p= new Player();
//    @Before
//    public void init() {
////        playerDaoImpl = new PlayerDaoImpl();
//        p.setName("JB");
//        p.setFirstName("Jimmy");
//        p.setLastName("Butler");
//        p.setWeight(104);
//        p.setHeight(201);
////        p.setTeam("Heats");
////        p.setPositionId(2);
////        p.setTeamId(1);
//        playerDao.save(p);
//    }
//    @After
//    public void tearDown(){
////        playerDaoImpl = new PlayerDaoImpl()
//        playerDao.delete(p.getName());
//    }
//
////    @Test
////    public void getPlayersTest(){
////        List<Player> players = playerDao.getPlayers();
////        int expectedNumofPlayer = 6;
////        Assert.assertEquals(expectedNumofPlayer,players.size());
////    }
//    @Test
//    public void getPlayerByName(){
//        String name = "Kobe";
//        Player player1 = playerDao.getPlayerByName(name);
//        Assert.assertEquals(player1.getName(),name);
//
//    }
//    @Test
//    public void getPlayerById(){
//        Player newPlayer =  playerDao.getPlayerById(2L);
//        Assert.assertEquals(newPlayer.getName(),"Kobe");
//    }
//
//
//}
