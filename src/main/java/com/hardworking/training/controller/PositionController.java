package com.hardworking.training.controller;

import com.hardworking.training.model.Position;
import com.hardworking.training.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/positions","/position","/pos"})
public class PositionController {
    @Autowired
    private PositionService positionService;
    // /positions GET
    @RequestMapping(value = "/{position_id}", method = RequestMethod.GET)
    public Position findPosition(@PathVariable("position_id") Long positionId){
        return positionService.getPositionEagerBy(positionId);
    }

    //save a position
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Position save (Position position){
        return positionService.save(position);
    }
    //delete a position
    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public boolean delete(Position position ){
        return positionService.delete(position);
    }
    //update a position info
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Position update(Position position) {
        return positionService.update(position);
    }

    //get position and the player in the position
    @RequestMapping(value = "/players",method = RequestMethod.GET)
    public List<Object[]> getPositionAndPlayers(@RequestParam(value = "players") String positionName){
        return positionService.getPositionAndPlayers(positionName);
    }

}
