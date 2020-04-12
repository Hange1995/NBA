package com.hardworking.training.repository;




import com.hardworking.training.model.Team;
import java.util.Set;

public interface TeamDao {
    Team save(Team team);
    Team update(Team team);
    boolean delete(String name );
    Team getTeamEagerBy(Long id);
    Team getTeamBy(Long id);
    Team getTeamNameAndPlayers(String teamName);
    Set<Team> getTeamNameAndPlayersAndPosition(String teamName);
    Team getTeamByNameAndPlayersAndData(String teamName);


}
