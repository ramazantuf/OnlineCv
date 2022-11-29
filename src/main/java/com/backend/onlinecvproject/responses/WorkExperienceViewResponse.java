package com.backend.onlinecvproject.responses;

import com.backend.onlinecvproject.entities.Candidate;
import com.backend.onlinecvproject.entities.Position;
import com.backend.onlinecvproject.entities.WorkExperience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceViewResponse {
    private int id;
    private String companyName;
    private Position position;
    private java.sql.Date startDate;
    private java.sql.Date endDate;
    private Candidate candidate;
    public static WorkExperienceViewResponse of(WorkExperience workExperience){
        return new WorkExperienceViewResponse(workExperience.getId(),workExperience.getCompanyName(),workExperience.getPosition(),workExperience.getStartDate(),workExperience.getEndDate(),workExperience.getCandidate());
    }
}
