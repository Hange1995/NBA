package com.hardworking.training.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hardworking.training.jsonview.Views;

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
    @JsonView({Views.PositionView.class})
    private long id;

    @Column(name="position_name")
    @JsonView({Views.PositionView.class, Views.TeamView.class,Views.PlayerView.class})
    private String positionName;

    @Column(name = "description")
    @JsonView({Views.PositionView.class, Views.TeamView.class,Views.PlayerView.class})
    private String description;

    @OneToMany(mappedBy = "position",fetch = FetchType.LAZY)
    @JsonView({Views.PositionView2.class})
    private List<Player> player;

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
