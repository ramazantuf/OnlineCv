package com.backend.onlinecvproject.services;

import com.backend.onlinecvproject.entities.WorkExperience;
import com.backend.onlinecvproject.repositories.WorkExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkExperienceService {
    private WorkExperienceRepository workExperienceRepository;

    public WorkExperienceService(WorkExperienceRepository workExperienceRepository) {
        this.workExperienceRepository = workExperienceRepository;
    }

    public List<WorkExperience> getall(){
        return this.workExperienceRepository.findAll();
    }

    public WorkExperience add(WorkExperience workExperience){
        return this.workExperienceRepository.save(workExperience);
    }

    public WorkExperience update(Long workExperienceId, WorkExperience updatedWorkExperience){
        Optional<WorkExperience> workExperience = this.workExperienceRepository.findById(workExperienceId);
        if(workExperience.isPresent()){
            WorkExperience foundedWorkExperience = workExperience.get();
            foundedWorkExperience.setCompanyName(updatedWorkExperience.getCompanyName());
            foundedWorkExperience.setPosition(updatedWorkExperience.getPosition());
            foundedWorkExperience.setStartDate(updatedWorkExperience.getStartDate());
            foundedWorkExperience.setEndDate(updatedWorkExperience.getEndDate());
            this.workExperienceRepository.save(foundedWorkExperience);
            return foundedWorkExperience;
        }else{
            return null;
        }
    }

    public void delete(Long workExperienceId){
        this.workExperienceRepository.deleteById(workExperienceId);
    }
}
