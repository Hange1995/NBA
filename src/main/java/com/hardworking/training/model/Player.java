package com.hardworking.training.model;

public class Player {
    public Player() {
    }

    public Player(long id,String name, String firstName, String lastName, double weight, double hight, String team, long positionId,  long teamId) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.weight = weight;
        this.hight = hight;
        this.team = team;
        this.positionId = positionId;
        this.teamId = teamId;
    }
    private long id;
    private String name;
    private String firstName;
    private String lastName;
    private double weight;
    private double hight;
    private String team;
    private long positionId;
    private long teamId;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public long getPositionId() {
        return positionId;
    }

    public void setPositionId(long positionId) {
        this.positionId = positionId;
    }

    public long getTeamId(){ return teamId; }

    public void setTeamId(long teamId){ this.teamId = teamId;}
}
