package com.backend.onlinecvproject.services;

import com.backend.onlinecvproject.core.mapping.ModelMapperService;
import com.backend.onlinecvproject.entities.Candidate;
import com.backend.onlinecvproject.entities.WorkExperience;
import com.backend.onlinecvproject.repositories.WorkExperienceRepository;
import com.backend.onlinecvproject.requests.WorkExperienceCreateRequest;
import com.backend.onlinecvproject.requests.WorkExperienceUpdateRequest;
import com.backend.onlinecvproject.responses.CandidateViewResponse;
import com.backend.onlinecvproject.responses.WorkExperienceViewResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkExperienceService {
    private WorkExperienceRepository workExperienceRepository;
    private ModelMapperService modelMapperService;

    public WorkExperienceService(WorkExperienceRepository workExperienceRepository, ModelMapperService modelMapperService) {
        this.workExperienceRepository = workExperienceRepository;
        this.modelMapperService = modelMapperService;
    }

    public List<WorkExperienceViewResponse> getall(){
        List<WorkExperience> candidates = this.workExperienceRepository.findAll();
        List<WorkExperienceViewResponse> result = candidates.stream().map(color -> this.modelMapperService.forDto().map(color, WorkExperienceViewResponse.class)).collect(Collectors.toList());
        return result;
    }

    public WorkExperience add(WorkExperienceCreateRequest workExperience){
        WorkExperience toAdd = new WorkExperience();
        toAdd.setCompanyName(workExperience.getCompanyName());
        toAdd.setPosition(workExperience.getPosition());
        toAdd.setStartDate(workExperience.getStartDate());
        toAdd.setEndDate(workExperience.getEndDate());
        return this.workExperienceRepository.save(toAdd);
    }

    public WorkExperience update(int workExperienceId, WorkExperienceUpdateRequest updatedWorkExperience){
        Optional<WorkExperience> workExperience = this.workExperienceRepository.findById(workExperienceId);
        if(workExperience.isPresent()){
            WorkExperience toUpdate = workExperience.get();
            toUpdate.setCompanyName(updatedWorkExperience.getCompanyName());
            toUpdate.setPosition(updatedWorkExperience.getPosition());
            toUpdate.setStartDate(updatedWorkExperience.getStartDate());
            toUpdate.setEndDate(updatedWorkExperience.getEndDate());
            this.workExperienceRepository.save(toUpdate);
            return toUpdate;
        }else{
            return null;
        }
    }

    public void delete(int workExperienceId){
        this.workExperienceRepository.deleteById(workExperienceId);
    }
}
