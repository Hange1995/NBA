package com.hardworking.training.jdbc;


import com.hardworking.training.model.Position;
import org.junit.*;

import java.util.List;

class PositionJDBCTest {
    private PositionJDBCDAO positionJDBCDAO;
    @Before
    public void init(){ positionJDBCDAO = new PositionJDBCDAO();}
    @Test
    public void getPlayersTest(){
        List<Position> positions = positionJDBCDAO.getPositions();
        int expectedNumofPlayer = 3;
        Assert.assertTrue(expectedNumofPlayer==positions.size())

    }

}