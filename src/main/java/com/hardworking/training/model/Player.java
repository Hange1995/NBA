package com.hardworking.training.model;


import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    public Player() {}

    public Player(long id, String name, String firstName, String lastName,
                  double weight, double height, String team, long positionId, long teamId) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.weight = weight;
        this.height = height;
//        this.team = team;
//        this.positionId = positionId;
//        this.teamId = teamId;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
//    @Column(name = "team")
//    private String team;
//    @Column(name="position_id")
//    private long positionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "weight")
    private double weight;

    @Column(name = "height")
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
