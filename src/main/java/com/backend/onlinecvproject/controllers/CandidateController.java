package com.backend.onlinecvproject.controllers;

import com.backend.onlinecvproject.entities.Candidate;
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
    public List<Candidate> getall(){
        return this.candidateService.getall();
    }

    @PostMapping
    public Candidate add(@RequestBody Candidate candidate){
        return this.candidateService.add(candidate);
    }

    @PutMapping("/{candidateId}")
    public Candidate update(@PathVariable Long candidateId,@RequestBody Candidate updatedCandidate){
        return this.candidateService.update(candidateId,updatedCandidate);
    }

    @DeleteMapping("/{candidateId}")
    public void delete(@PathVariable Long candidateId) {
        this.candidateService.delete(candidateId);
    }
}
