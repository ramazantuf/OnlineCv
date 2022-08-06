package com.backend.onlinecvproject.repositories;

import com.backend.onlinecvproject.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
