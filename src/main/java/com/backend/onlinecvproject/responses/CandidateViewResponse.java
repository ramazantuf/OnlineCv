package com.backend.onlinecvproject.responses;

import com.backend.onlinecvproject.entities.Candidate;
import com.backend.onlinecvproject.entities.WorkExperience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateViewResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private List<WorkExperience> workExperiences;
    public static CandidateViewResponse of(Candidate candidate){
        return new CandidateViewResponse(candidate.getId(),candidate.getFirstName(),candidate.getLastName(),candidate.getEmail(), candidate.getPassword(),candidate.getPhoneNumber(),
                candidate.getWorkExperiences());
    }
}
