package com.backend.onlinecvproject.services;

import com.backend.onlinecvproject.entities.Position;
import com.backend.onlinecvproject.repositories.PositionRepository;
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

    public Position add(Position position){
        return this.positionRepository.save(position);
    }

    public Position update(Long positionId, Position updatedPosition){
        Optional<Position> position = this.positionRepository.findById(positionId);
        if(position.isPresent()){
            Position foundedPosition = position.get();
            foundedPosition.setPositionName(updatedPosition.getPositionName());
            this.positionRepository.save(foundedPosition);
            return foundedPosition;
        }else{
            return null;
        }
    }

    public void delete(Long positionId){
        this.positionRepository.deleteById(positionId);
    }
}
