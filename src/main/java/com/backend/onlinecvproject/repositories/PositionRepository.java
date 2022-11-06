package com.backend.onlinecvproject.repositories;

import com.backend.onlinecvproject.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
