package com.backend.onlinecvproject.controllers;

import com.backend.onlinecvproject.entities.Candidate;
import com.backend.onlinecvproject.requests.CandidateCreateRequest;
import com.backend.onlinecvproject.requests.CandidateUpdateRequest;
import com.backend.onlinecvproject.responses.CandidateViewResponse;
import com.backend.onlinecvproject.services.CandidateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
public class CandidateController {
    private CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    public List<CandidateViewResponse> getall(){
        return this.candidateService.getall();
    }

    @PostMapping
    public Candidate add(@RequestBody CandidateCreateRequest candidate){
        return this.candidateService.add(candidate);
    }

    @PutMapping("/{candidateId}")
    public Candidate update(@PathVariable int candidateId,@RequestBody CandidateUpdateRequest updatedCandidate){
        return this.candidateService.update(candidateId,updatedCandidate);
    }

    @DeleteMapping("/{candidateId}")
    public void delete(@PathVariable int candidateId) {
        this.candidateService.delete(candidateId);
    }
}
