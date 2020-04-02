package com.hardworking.training.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.hardworking.training.jsonview.Views;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    public Player() {}

    public Player(long id, String name, String firstName, String lastName,
                  double weight, double height, long positionId, long teamId) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.weight = weight;
        this.height = height;
//        this.teamName = this.teamName;
//        this.positionId = positionId;
//        this.teamId = teamId;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
//    @JsonView({Views.Position.class,Views.Team.class,Views.Player.class})
    private Long id;

    @Column(name = "name")
//    @JsonView({Views.Position.class,Views.Team.class,Views.Player.class})
    private String name;

    @Column(name = "first_name")
//    @JsonView({Views.Position.class,Views.Team.class,Views.Player.class})
    private String firstName;

    @Column(name = "last_name")
//    @JsonView({Views.Position.class,Views.Team.class,Views.Player.class})
    private String lastName;
//    @JsonView({Views.Player.class,Views.Position.class})
//    @Column(name = "team")
//    private String teamName;

//    @Column(name="position_id")
//    private long positionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
//    @JsonView({Views.Player.class})
    @JsonIgnore
    private Position position;

//    @JsonView({Views.Player.class})
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "weight")
    @JsonView({Views.Position.class,Views.Team.class,Views.Player.class})
    private double weight;

    @Column(name = "height")
    @JsonView({Views.Position.class,Views.Team.class,Views.Player.class})
    private double height;

    public Long getId() {
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setId(Long id) { this.id = id; }

    public Team getTeam() { return team; }

    public void setTeam(Team team) { this.team = team; }

    public Position getPosition() { return position; }

    public void setPosition(Position position) { this.position = position; }

//    public String getTeamName() { return teamName; }
//
//    public void setTeamName(String teamName) { this.teamName = teamName; }


    //    public long getPositionId() {
//        return positionId;
//    }
//
//    public void setPositionId(long positionId) {
//        this.positionId = positionId;
//    }

//    public long getTeamId(){ return teamId; }
//
//    public void setTeamId(long teamId){ this.teamId = teamId;}
}
