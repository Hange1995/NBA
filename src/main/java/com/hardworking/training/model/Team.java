package com.hardworking.training.model;

public class Team {
    public Team() {
    }
    private long id;
    private String teamname;
    private String location;
    public Team(long id, String Teamname, String location) {
        this.id = id;
        this.teamname = Teamname;
        this.location = location;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getTeamname() { return teamname; }

    public void setTeamname(String teamname) { this.teamname = teamname; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }
}
