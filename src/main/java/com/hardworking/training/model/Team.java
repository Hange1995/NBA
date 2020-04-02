package com.hardworking.training.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.hardworking.training.jsonview.Views;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {
    public Team() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
//    @JsonView({Views.Position.class,Views.Team.class,Views.Player.class})
    private long id;


    @Column(name = "name")
//    @JsonView({Views.Position.class,Views.Team.class,Views.Player.class})
    private String name;

    @Column(name = "location")
//    @JsonView({Views.Position.class,Views.Team.class,Views.Player.class})
    private String location;

    @OneToMany(mappedBy = "team",fetch = FetchType.EAGER)
//    @JsonView({Views.Position.class,Views.Team.class})
    private Set<Player> player;

    public Team(long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Set<Player> getPlayer() { return player; }

    public void setPlayer(Set<Player> player) { this.player = player; }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }
}
