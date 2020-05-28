//package com.hardworking.training.service;
//
//import com.hardworking.training.init.AppBootstrap;
//import com.hardworking.training.model.Player;
//import com.hardworking.training.model.Team;
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
//import java.util.stream.Collectors;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AppBootstrap.class)
//public class TeamServiceTest {
//    @Autowired TeamService teamService;
//
//    @Autowired PlayerService playerService;
//
//    Team team = new Team();
//    Player player= new Player();
//
//    @Before
//    public void init(){
//        team.setName("Ascending");
//        team.setLocation("VA");
//        teamService.save(team);
//        player.setName("Hange");
//        player.setTeam(team);
//        playerService.save(player);
//    }
//
//    @After
//    public void teardown(){
//        playerService.delete(player.getName());
//        teamService.delete(team.getName());
//    }
//
//    @Test
//    public void getTeamEagerByTest(){
//        String string = "Heat";
//        Assert.assertEquals(string,teamService.getTeamEagerBy(1L).getName());
//    }
//    @Test
//    public void getTeamByTest(){
//        String string = "Lakers";
//        Assert.assertEquals(string,teamService.getTeamBy(2L).getName());
//    }
//    @Test
//    public void getTeamNameAndPlayersTest(){
//        String string = "Lakers";
//        Assert.assertEquals(string,teamService.getTeamNameAndPlayers(string).getName());
//    }
//    @Test
//    public void getTeamNameAndPlayersAndPositionTest(){
//        Set<Team> teams= teamService.getTeamNameAndPlayersAndPosition("Lakers");
//        Set<String> teamNames=teams.stream()
//                .map(Team::getName)
//                .collect(Collectors.toSet());
//        Assert.assertTrue(teamNames.contains("Lakers"));
//
//    }
//
//}
