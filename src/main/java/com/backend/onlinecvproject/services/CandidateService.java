package com.backend.onlinecvproject.services;

import com.backend.onlinecvproject.entities.Admin;
import com.backend.onlinecvproject.entities.Candidate;
import com.backend.onlinecvproject.repositories.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {
    private CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public List<Candidate> getall(){
        return this.candidateRepository.findAll();
    }

    public Candidate add(Candidate candidate){
        return this.candidateRepository.save(candidate);
    }

    public Candidate update(Long candidateId, Candidate updatedCandidate){
        Optional<Candidate> candidate = this.candidateRepository.findById(candidateId);
        if(candidate.isPresent()){
            Candidate foundedCandidate = candidate.get();
            foundedCandidate.setFirstName(updatedCandidate.getFirstName());
            foundedCandidate.setLastName(updatedCandidate.getLastName());
            foundedCandidate.setEmail(updatedCandidate.getEmail());
            foundedCandidate.setPhoneNumber(updatedCandidate.getPhoneNumber());
            this.candidateRepository.save(foundedCandidate);
            return foundedCandidate;
        }else{
            return null;
        }
    }

    public void delete(Long candidateId){
        this.candidateRepository.deleteById(candidateId);
    }
}
