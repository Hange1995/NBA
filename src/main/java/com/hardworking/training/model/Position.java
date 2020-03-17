package com.hardworking.training.model;

public class Position {
    public Position (){
    }
    private long id;
    private String positionName;
    private String description;
    public Position (long id, String positionName, String description){
        this.id = id;
        this.positionName = positionName;
        this.description = description;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getPositionName() { return positionName; }

    public void setPositionName(String positionName) { this.positionName = positionName; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}
