package com.backend.onlinecvproject.repositories;

import com.backend.onlinecvproject.entities.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long> {
}
