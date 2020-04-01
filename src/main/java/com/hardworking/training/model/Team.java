package com.hardworking.training.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private long id;


    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "team",fetch = FetchType.EAGER)
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
