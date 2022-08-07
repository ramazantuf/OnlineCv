package com.backend.onlinecvproject.controllers;

import com.backend.onlinecvproject.entities.WorkExperience;
import com.backend.onlinecvproject.services.WorkExperienceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workexperiences")
public class WorkExperienceController {
    private WorkExperienceService workExperienceService;

    public WorkExperienceController(WorkExperienceService workExperienceService) {
        this.workExperienceService = workExperienceService;
    }

    @GetMapping
    public List<WorkExperience> getall(){
        return this.workExperienceService.getall();
    }

    @PostMapping
    public WorkExperience add(@RequestBody WorkExperience workExperience){
        return this.workExperienceService.add(workExperience);
    }

    @PutMapping("/{workExperienceId}")
    public WorkExperience update(@PathVariable Long workExperienceId,@RequestBody WorkExperience updatedWorkExperience){
        return this.workExperienceService.update(workExperienceId, updatedWorkExperience);
    }

    @DeleteMapping("/{workExperienceId}")
    public void delete(@PathVariable Long workExperienceId){
        this.workExperienceService.delete(workExperienceId);
    }
}