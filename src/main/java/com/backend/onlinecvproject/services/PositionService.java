package com.backend.onlinecvproject.services;

import com.backend.onlinecvproject.entities.Position;
import com.backend.onlinecvproject.repositories.PositionRepository;
import com.backend.onlinecvproject.requests.PositionCreateRequest;
import com.backend.onlinecvproject.requests.PositionUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {
    private PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> getall(){
        return this.positionRepository.findAll();
    }

    public Position add(PositionCreateRequest position){
        Position toAdd = new Position();
        toAdd.setPositionName(position.getPositionName());
        return this.positionRepository.save(toAdd);
    }

    public Position update(int positionId, PositionUpdateRequest updatedPosition){
        Optional<Position> position = this.positionRepository.findById(positionId);
        if(position.isPresent()){
            Position toUpdate = position.get();
            toUpdate.setPositionName(updatedPosition.getPositionName());
            this.positionRepository.save(toUpdate);
            return toUpdate;
        }else{
            return null;
        }
    }

    public void delete(int positionId){
        this.positionRepository.deleteById(positionId);
    }
}
