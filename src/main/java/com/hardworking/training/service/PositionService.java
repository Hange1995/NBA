package com.hardworking.training.service;

import com.hardworking.training.model.Position;
import com.hardworking.training.repository.PositionDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PositionService {
    @Autowired
    private PositionDao positionDao;
    public Position save(Position position){
        return positionDao.save(position);
    }

    public boolean delete(String positionName){
        return positionDao.delete(positionName);
    }

    public Position getPositionEagerBy(Long id){
        return positionDao.getPositionEagerBy(id);
    }

    public Position getPositionBy(Long id){
        return positionDao.getPositionBy(id);
    }

    public Set<Position> getPositionAndPlayers(String positionName){
        return positionDao.getPositionAndPlayers(positionName);
    }
    public Position update(Position position) {
        return positionDao.update(position);
    }

    public Position update(Long id,Position newPosition) {
        Position oldPosition = positionDao.getPositionEagerBy(id);
        BeanUtils.copyProperties(newPosition,oldPosition,"id","player");
        return positionDao.update(oldPosition);
    }

}
