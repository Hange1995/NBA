package com.hardworking.training.jdbc;

import com.hardworking.training.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerJDBCDao {
    private static Logger logger = LoggerFactory.getLogger(PlayerJDBCDao.class);
    static final String DBURL = "jdbc:postgresql://localhost:5430/nba";
    static final String USER = "admin";
    static final String PASS = "password";
    List<Player> pLayers = new ArrayList();

    public List<Player> getPlayers() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DBURL, USER, PASS);
            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM player";
            rs = stmt.executeQuery(sql);
            //STEP 4: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String firstName = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                double weight = rs.getDouble("weight");
                double height = rs.getDouble("height");
                String team = rs.getString("team");
                long position_id = rs.getLong("position_id");
                long team_id = rs.getLong("team_id");
                //Fill the object
                Player player = new Player();
                player.setId(id);
                player.setName(name);
                player.setFirstName(firstName);
                player.setLastName(last_name);
                player.setWeight(weight);
                player.setHeight(height);
                player.setTeam(team);
                player.setPositionId(position_id);
                player.setTeamId(team_id);

                pLayers.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //STEP 6: finally block used to close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return pLayers;

    }

//    public static void main(String[] args) {
//        PlayerJDBCDao playerJDBCDAO = new PlayerJDBCDao();
//        System.out.println(playerJDBCDAO.getPlayers());
//        logger.info("infomation");
//        logger.debug("debug");
//        logger.warn("WARNING");
//    }

    public void save(Player p){
        Connection conn = null;
        Statement stmt = null;

        String add = "VALUES('"+p.getName()+"','"+p.getFirstName()+"','"+p.getLastName()+
                "',"+Double.toString(p.getWeight())+","+Double.toString(p.getHeight())+","+Long.toString(p.getPositionId())+",'"+p.getTeam()+"',"
                +Long.toString(p.getTeamId())+")";
        try {
            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DBURL, USER, PASS);
            //STEP 3: Execute a query to add player
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql =  "INSERT INTO Player (name, first_name, last_name, weight, hight, position_id,team,team_id) " +add;
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //STEP 6: finally block used to close resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }

    public void delete(Player p){
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DBURL, USER, PASS);
            //STEP 3: Execute a query to delete player
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
            sql1 =  "DELETE FROM player WHERE name='"+p.getName()+"'";
            stmt.executeUpdate(sql1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //STEP 4: finally block used to close resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


}

