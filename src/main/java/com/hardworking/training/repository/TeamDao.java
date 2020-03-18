package com.hardworking.training.repository;



import com.hardworking.training.model.Player;
import com.hardworking.training.model.Team;

import java.util.List;

public interface TeamDao {
    Team save(Team team);
    boolean delete(Team team );
    Team getTeamEagerBy(Long id);
    Team getTeamBy(Long id);

}
