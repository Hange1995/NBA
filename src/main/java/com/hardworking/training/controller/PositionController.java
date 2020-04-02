package com.hardworking.training.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hardworking.training.model.Position;
import com.hardworking.training.service.PositionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Set;


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
         if (pos==null) System.out.println("Position is not created");
         return pos;
    }
    //{prefix}/positions DELETE
    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public boolean delete(@RequestParam("position_name") String positionName ){
        return positionService.delete(positionName);
    }
    //{prefix}/positions PUT
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Position update(@RequestBody Position position) {
        Position updatePos = positionService.update(position);
        if (updatePos==null) System.out.println("The position is not exist yet");
        return updatePos;
    }
    //{prefix}/positions/players?key=value GET
    @RequestMapping(value = "/players",method = RequestMethod.GET)
    public Set<Position> getPositionAndPlayers(@RequestParam( value = "position_name") String positionName){
        return positionService.getPositionAndPlayers(positionName);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PATCH)
    public Position updatePositionName(@PathVariable("id") Long Id, @RequestParam("position_name") String name){
        Position position = positionService.getPositionBy(Id);
        position.setPositionName(name);
        position=positionService.update(position);
        return position;
    }

}
