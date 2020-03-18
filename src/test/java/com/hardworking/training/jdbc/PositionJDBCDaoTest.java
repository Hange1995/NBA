//package com.hardworking.training.jdbc;
//
//
//import com.hardworking.training.model.Position;
//import org.junit.*;
//import java.util.List;
//
//public class PositionJDBCDaoTest {
//    private PositionJDBCDao positionJDBCDao;
//    @Before
//    public void init() {
//        positionJDBCDao = new PositionJDBCDao();
//        Position p = new Position();
//        p.setId(6);
//        p.setPositionName("JB");
//        p.setDescription("Jimmy");
//        positionJDBCDao.add(p);
//    }
//    @After
//    public void delete(){
//        positionJDBCDao = new PositionJDBCDao();
//        Position p = new Position();
//        p.setId(6);
//        p.setPositionName("JB");
//        p.setDescription("Jimmy");
//        positionJDBCDao.delete(p);
//    }
//    @Test
//    public void getPlayersTest(){
//        PositionJDBCDao positionJDBCDao = new PositionJDBCDao();
//        List<Position> positions = positionJDBCDao.getPositions();
//        int expectedNumofPosition = 3;
//        Assert.assertTrue(expectedNumofPosition==positions.size());
//
//    }
//
//}