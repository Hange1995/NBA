package com.hardworking.training.repository;

import com.hardworking.training.model.Position;


public interface PositionDao {
    Position save(Position position);
    boolean delete(Position position );
    Position getPositionEagerBy(Long id);
    Position getPositionBy(Long id);
}
