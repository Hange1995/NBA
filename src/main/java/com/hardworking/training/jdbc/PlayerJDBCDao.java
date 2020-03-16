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
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                double weight = rs.getDouble("weight");
                double hight = rs.getDouble("hight");
                String team = rs.getString("team");
                long position_id = rs.getLong("position_id");
                long team_id = rs.getLong("team_id");
                //Fill the object
                Player player = new Player();
                player.setId(id);
                player.setName(name);
                player.setFirst_name(first_name);
                player.setLast_name(last_name);
                player.setWeight(weight);
                player.setHight(hight);
                player.setTeam(team);
                player.setPosition_id(position_id);
                player.setTeam_id(team_id);

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
//        PlayerJDBCDAO playerJDBCDAO = new PlayerJDBCDAO();
//        System.out.println(playerJDBCDAO.getPlayers());
//        logger.info("infomation");
//        logger.debug("debug");
//        logger.warn("WARNING");
//    }

    public void save(Player p){
        pLayers.add(p);
    }

    public void delete(){
        pLayers=new ArrayList<>();
    }

}

