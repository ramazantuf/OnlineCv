package com.backend.onlinecvproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "positions")
@Data
public class Position {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="position_name")
    private String positionName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_experience_id")
    @JsonIgnore
    private WorkExperience workExperience;
}
