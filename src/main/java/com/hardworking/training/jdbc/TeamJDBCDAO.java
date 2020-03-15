package com.hardworking.training.jdbc;

import com.hardworking.training.model.Team;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamJDBCDAO {
    static final String DBURL = "jdbc:postgresql://localhost:5430/nba";
    static final String USER = "admin";
    static final String PASS = "password";

    public List<Team> getTeams() {
        List<Team> teams = new ArrayList<>();
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
                String teamname = rs.getString("Teamname");
                String description = rs.getString("description");

                //Fill the object
                Team team = new Team();
                team.setId(id);
                team.setTeamname(teamname);
                team.setLocation(description);

                teams.add(team);
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
        return teams;
    }

}
