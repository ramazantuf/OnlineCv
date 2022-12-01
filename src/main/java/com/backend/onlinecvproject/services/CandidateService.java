package com.backend.onlinecvproject.services;

import com.backend.onlinecvproject.core.mapping.ModelMapperService;
import com.backend.onlinecvproject.entities.Candidate;
import com.backend.onlinecvproject.repositories.CandidateRepository;
import com.backend.onlinecvproject.requests.CandidateCreateRequest;
import com.backend.onlinecvproject.requests.CandidateUpdateRequest;
import com.backend.onlinecvproject.responses.CandidateViewResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidateService {
    private CandidateRepository candidateRepository;
    private final ModelMapperService modelMapperService;

    public CandidateService(CandidateRepository candidateRepository, ModelMapperService modelMapperService) {
        this.candidateRepository = candidateRepository;
        this.modelMapperService = modelMapperService;
    }

    public List<CandidateViewResponse> getall(){
        List<Candidate> candidates = this.candidateRepository.findAll();
        List<CandidateViewResponse> result = candidates.stream().map(color -> this.modelMapperService.forDto().map(color, CandidateViewResponse.class)).collect(Collectors.toList());
        return result;
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

    public Candidate update(int candidateId, CandidateUpdateRequest updatedCandidate){
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

    public void delete(int candidateId){
        this.candidateRepository.deleteById(candidateId);
    }

    public CandidateViewResponse getbyid(int candidateId){
        Candidate candidate=this.candidateRepository.getReferenceById(candidateId);
        CandidateViewResponse result = this.modelMapperService.forDto().map(candidate, CandidateViewResponse.class);
        return result;
    }
}
