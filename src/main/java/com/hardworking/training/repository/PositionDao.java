package com.hardworking.training.repository;

import com.hardworking.training.model.Position;

import java.util.List;


public interface PositionDao {
    Position save(Position position);
    boolean delete(String positionName );
    Position getPositionEagerBy(Long id);
    Position getPositionBy(Long id);
    List<Object[]> getPositionAndPlayers(String positionName);
    Position update(Position position);
    Position getPositionByName(String positionName);

}
