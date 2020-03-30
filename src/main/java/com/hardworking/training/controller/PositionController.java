package com.hardworking.training.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    // http://localhost:8080={prefix}
    // {prefix}/positions{position_id} GET
    @RequestMapping(value = "/{position_id}", method = RequestMethod.GET)
    public Position findPosition(@PathVariable("position_id") Long positionId){
        return positionService.getPositionEagerBy(positionId);
    }
    //{prefix}/positions POST
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Position save (@RequestBody Position position){
         Position pos = positionService.save(position);
         if (pos==null) System.out.println("Position is noe created");
         return pos;
    }
    //{prefix}/positions DELETE
    @RequestMapping(value = "/{position_name}",method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("position_name") String positionName ){
        return positionService.delete(positionName);
    }
    //{prefix}/positions PUT
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Position update(Position position) {
        return positionService.update(position);
    }
    //{prefix}/positions/players?key=value GET
    @RequestMapping(value = "/players",method = RequestMethod.GET)
    public List<Object[]> getPositionAndPlayers(@RequestParam( value = "position_name") String positionName){
        return positionService.getPositionAndPlayers(positionName);
    }

}
