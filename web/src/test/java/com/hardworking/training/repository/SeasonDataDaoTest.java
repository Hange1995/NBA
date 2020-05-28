//package com.hardworking.training.repository;
//
//import com.hardworking.training.init.AppBootstrap;
//import com.hardworking.training.model.Player;
//import com.hardworking.training.model.SeasonData;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Set;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AppBootstrap.class)
//public class SeasonDataDaoTest {
//    @Autowired
//    SeasonDataDao seasonDataDao;
//    @Autowired PlayerDao playerDao;
//
//    Player player= new Player();
//    SeasonData seasonData = new SeasonData();
//    @Before
//    public void init(){
//        player.setName("HG");
//        player.setFirstName("Hange");
//        player.setLastName("Chen");
//        player.setWeight(75);
//        player.setHeight(180);
//        playerDao.save(player);
//        seasonData.setScore(100.0);
//        seasonData.setSeason(2019L);
//        seasonData.setSalary(10_0000.0);
//        seasonDataDao.create(seasonData);
//    }
//
//    @After
//    public void tearDown(){
//        seasonDataDao.delete(seasonData.getId());
//        playerDao.delete(player.getName());
//    }
//
//    @Test
//    public void getPlayerDataTest(){
//        Set<SeasonData> result = seasonDataDao.getPlayerData();
//        Assert.assertEquals(1,result.size());
//    }
//}
