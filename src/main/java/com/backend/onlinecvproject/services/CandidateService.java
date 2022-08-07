package com.backend.onlinecvproject.services;

import com.backend.onlinecvproject.entities.Admin;
import com.backend.onlinecvproject.entities.Candidate;
import com.backend.onlinecvproject.repositories.CandidateRepository;
import com.backend.onlinecvproject.requests.CandidateCreateRequest;
import com.backend.onlinecvproject.requests.CandidateUpdateRequest;
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

    public Candidate add(CandidateCreateRequest candidate){
        Candidate toAdd = new Candidate();
        toAdd.setFirstName(candidate.getFirstName());
        toAdd.setLastName(candidate.getLastName());
        toAdd.setEmail(candidate.getEmail());
        toAdd.setPhoneNumber(candidate.getPhoneNumber());
        toAdd.setPassword(candidate.getPassword());
        return this.candidateRepository.save(toAdd);
    }

    public Candidate update(Long candidateId, CandidateUpdateRequest updatedCandidate){
        Optional<Candidate> candidate = this.candidateRepository.findById(candidateId);
        if(candidate.isPresent()){
            Candidate toUpdate = candidate.get();
            toUpdate.setFirstName(updatedCandidate.getFirstName());
            toUpdate.setLastName(updatedCandidate.getLastName());
            toUpdate.setEmail(updatedCandidate.getEmail());
            toUpdate.setPhoneNumber(updatedCandidate.getPhoneNumber());
            this.candidateRepository.save(toUpdate);
            return toUpdate;
        }else{
            return null;
        }
    }

    public void delete(Long candidateId){
        this.candidateRepository.deleteById(candidateId);
    }
}
