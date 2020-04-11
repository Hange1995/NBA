package com.hardworking.training.model;

import javax.persistence.*;

@Entity
@Table(name = "playerdata")
public class PlayerData {
    public PlayerData() {
    }

    public PlayerData(Long id, Long player_id, Long season, Double salary, Double steal, Double block, Double assistant, Double score, Long appearances) {
        this.id = id;
//        this.playerId = player_id;
        this.season = season;
        this.salary = salary;
        this.steal = steal;
        this.block = block;
        this.assistant = assistant;
        this.score = score;
        this.appearances=appearances;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
//    private Long playerId;
    @Column(name = "season")
    private Long season;
    @Column(name = "salary")
    private Double salary;
    @Column(name = "steal")
    private Double steal;
    @Column(name = "block")
    private Double block;
    @Column(name = "assistant")
    private Double assistant;
    @Column(name = "score")
    private Double score;
    @Column(name = "appearances")
    private Long appearances;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getPlayerId() {
//        return playerId;
//    }
//
//    public void setPlayerId(Long id ) {
//        this.playerId = id;
//    }

    public Long getSeason() {
        return season;
    }

    public void setSeason(Long season) {
        this.season = season;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getSteal() {
        return steal;
    }

    public void setSteal(Double steal) {
        this.steal = steal;
    }

    public Double getBlock() {
        return block;
    }

    public void setBlock(Double block) {
        this.block = block;
    }

    public Double getAssistant() {
        return assistant;
    }

    public void setAssistant(Double assistant) {
        this.assistant = assistant;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Long getAppearances() {
        return appearances;
    }

    public void setAppearances(Long appearances) {
        this.appearances = appearances;
    }
}
