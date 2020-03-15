package com.hardworking.training.model;

public class Position {
    public Position (){
    }
    private long id;
    private String positionname;
    private String description;
    public Position (long id, String positionname, String description){
        this.id = id;
        this.positionname = positionname;
        this.description = description;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getPositionname() { return positionname; }

    public void setPositionname(String positionname) { this.positionname = positionname; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}
