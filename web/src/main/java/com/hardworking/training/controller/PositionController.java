package com.hardworking.training.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.hardworking.training.jsonview.Views;
import com.hardworking.training.model.Position;
import com.hardworking.training.service.PositionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    // {prefix}/positions/{position_id} GET a player by id
    @JsonView(Views.PositionView.class)
    @RequestMapping(value = "/{position_id}", method = RequestMethod.GET)
    public Position findPosition(@PathVariable("position_id") Long positionId){
        return positionService.getPositionBy(positionId);
    }
    //{prefix}/positions POST create a new position
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Position save (@RequestBody Position position){
         Position pos = positionService.save(position);
         if (pos==null) System.out.println("Position is not created");
         return pos;
    }
    //{prefix}/positions?key = value  DELETE a player by it's name.
    @JsonView(Views.PositionView2.class)
    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public boolean delete(@RequestParam("position_name") String positionName ){
        return positionService.delete(positionName);
    }
    //{prefix}/positions PUT
    @JsonView(Views.PositionView2.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Position position) {
        Position updatePos = positionService.update(id,position);
        if (updatePos==null) System.out.println("The update is not exist yet");
        return ResponseEntity.ok(updatePos);
    }
    //{prefix}/positions/players?key=value GET
    @JsonView(Views.PositionView2.class)
    @RequestMapping(value = "/players",method = RequestMethod.GET)
    public Set<Position> getPositionAndPlayers(@RequestParam( value = "position_name") String positionName){
        return positionService.getPositionAndPlayers(positionName);
    }

    @JsonView(Views.PositionView.class)
    @RequestMapping(value = "/{id}",method = RequestMethod.PATCH)
    public Position updatePositionName(@PathVariable("id") Long Id, @RequestParam("position_name") String name){
        Position position = positionService.getPositionBy(Id);
        position.setPositionName(name);
        position=positionService.update(position);
        return position;
    }

}
