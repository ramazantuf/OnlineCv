package com.backend.onlinecvproject.controllers;

import com.backend.onlinecvproject.entities.Position;
import com.backend.onlinecvproject.requests.PositionCreateRequest;
import com.backend.onlinecvproject.requests.PositionUpdateRequest;
import com.backend.onlinecvproject.services.PositionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionController {
    private PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public List<Position> getall(){
        return this.positionService.getall();
    }

    @PostMapping
    public Position add(@RequestBody PositionCreateRequest position){
        return this.positionService.add(position);
    }

    @PutMapping("/{positionId}")
    public Position update(@PathVariable Long positionId,@RequestBody PositionUpdateRequest updatedPosition){
        return this.positionService.update(positionId,updatedPosition);
    }

    @DeleteMapping("/{positionId}")
    public void delete(@PathVariable Long positionId){
        this.positionService.delete(positionId);
    }
}
