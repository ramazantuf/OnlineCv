package com.backend.onlinecvproject.requests;

import com.backend.onlinecvproject.entities.Candidate;
import com.backend.onlinecvproject.entities.Position;
import lombok.Data;

@Data
public class WorkExperienceCreateRequest {
    private String companyName;

    private Position position;

    private java.sql.Date startDate;

    private java.sql.Date endDate;

    private Candidate candidate;
}
