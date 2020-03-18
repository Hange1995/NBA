package com.hardworking.training.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="positions")
public class Position {
    public Position (){
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @OneToMany(mappedBy = "position",fetch = FetchType.LAZY)
    private List<Player> player;

    @Column(name="position_name")
    private String positionName;

    @Column(name = "description")
    private String description;
    public Position (long id, String positionName, String description){
        this.id = id;
        this.positionName = positionName;
        this.description = description;
    }

//    public List<Player> getPlayers() { return players; }
//
//    public void setPlayers(List<Player> players) { this.players = players; }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getPositionName() { return positionName; }

    public void setPositionName(String positionName) { this.positionName = positionName; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public List<Player> getPlayer() { return player; }

    public void setPlayer(List<Player> player) { this.player = player; }
}
