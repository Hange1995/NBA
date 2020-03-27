package com.hardworking.training.repository;



import com.hardworking.training.model.Player;
import com.hardworking.training.model.Team;

import java.util.List;

public interface TeamDao {
    Team save(Team team);
    Team update(Team team);
    boolean delete(Team team );
    Team getTeamEagerBy(Long id);
    Team getTeamBy(Long id);
    List<Object[]> getTeamNameAndPlayers(String teamName);
    List<Object[]> getTeamNameAndPlayersAndPosition(String teamName);


}
