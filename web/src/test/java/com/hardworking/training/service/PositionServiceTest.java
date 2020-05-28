//package com.hardworking.training.service;
//
//import com.hardworking.training.init.AppBootstrap;
//import com.hardworking.training.model.Player;
//import com.hardworking.training.model.Position;
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
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AppBootstrap.class)
//public class PositionServiceTest {
//    @Autowired PositionService positionService;
//    @Autowired PlayerService playerService;
//    private Position position = new Position();
//    private Player player1=new Player();
//    private Player player2=new Player();
//
//    @Before
//    public void initialize(){
//        position.setPositionName("Han");
//        position.setDescription("Just for Hange");
//        positionService.save(position);
//        player1.setPosition(position);
//        player1.setName("CHG");
//        playerService.save(player1);
//        player2.setPosition(position);
//        player2.setName("Ryo");
//        playerService.save(player2);
//    }
//    @After
//    public void tearDown(){
//        playerService.delete(player1.getName());
//        playerService.delete(player2.getName());
//        positionService.delete(position.getPositionName());
//    }
//    @Test
//    public void getPositionListTest(){
//        List<Position> positions= positionService.getPositionList();
//        Assert.assertTrue(positions.size()>=6);
//    }
//    @Test
//    public void getPositionEagerByTest(){
//        String name = "SF";
//        Assert.assertEquals(name,positionService.getPositionEagerBy(1L).getPositionName());
//    }
//    @Test
//    public void getPositionByTest(){
//        String name = "SF";
//        Assert.assertEquals(name,positionService.getPositionBy(1L).getPositionName());
//    }
//    @Test
//    public void getPositionAndPlayers(){
//        Set<Position> positions = positionService.getPositionAndPlayers("SF");
//        Set<String> positionNames=positions.stream()
//                .map(Position::getPositionName)
//                .collect(Collectors.toSet());
//        Assert.assertTrue(positionNames.contains("SF"));
//
//    }
//    @Test
//    public void updateByRequestBodyTest(){
//        String description = "Test for hange";
//        position.setDescription(description);
//        positionService.update(position);
//        Assert.assertEquals(description,position.getDescription());
//    }
//    @Test
//    public void updateByIdAndRequestBodyTest(){
//        String description = "Test for hange";
//        position.setDescription(description);
//        positionService.update(position.getId(),position);
//        Assert.assertEquals(description,position.getDescription());
//    }
//
//}
