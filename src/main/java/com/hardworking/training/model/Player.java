package com.hardworking.training.model;

public class Player {
    public Player() {
    }

    public Player(long id,String name, String first_name, String last_name, double weight, double hight, String team, long position_id,  long team_id) {
        this.id = id;
        this.name = name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.weight = weight;
        this.hight = hight;
        this.team = team;
        this.position_id = position_id;
        this.team_id = team_id;
    }
    private long id;
    private String name;
    private String first_name;
    private String last_name;
    private double weight;
    private double hight;
    private String team;
    private long position_id;
    private long team_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public long getPosition_id() {
        return position_id;
    }

    public void setPosition_id(long position_id) {
        this.position_id = position_id;
    }

    public long getTeam_id(){ return team_id; }

    public void setTeam_id(long team_id){ this.team_id = team_id;}
}
