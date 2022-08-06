package com.backend.onlinecvproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="work_experiences")
public class WorkExperience {
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="position")
    private String companyName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private Position position;

    @Column(name="start_date")
    private java.sql.Date startDate;

    @Column(name="end_date")
    private java.sql.Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id")
    @JsonIgnore
    private Candidate candidate;
}
