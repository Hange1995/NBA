package com.hardworking.training.jdbc;

import com.hardworking.training.model.Player;

public class Main {
    public static void main(String[] args) {
        Player p = new Player();
        p.setId(5);
        p.setName("Jimmy Butler");
        p.setFirstName("Jimmy");
        p.setLastName("Butler");
        p.setWeight(104);
        p.setHeight(201);
        p.setTeam("Heats");
        p.setPositionId(2);
        p.setTeamId(1);
        String add = "VALUES('"+p.getName()+"','"+p.getFirstName()+"','"+p.getLastName()+
                "',"+Double.toString(p.getWeight())+","+Double.toString(p.getHeight())+",'"+p.getTeam()+"',"+Long.toString(p.getPositionId())+
                ","+Long.toString(p.getTeamId())+")";
        String sql =  "INSERT INTO Player " +add;
        System.out.println(sql);
        String sql1 =  "DELETE FROM player WHERE id='"+Long.toString(p.getId())+"';";
        System.out.println(sql1);
    }
}
