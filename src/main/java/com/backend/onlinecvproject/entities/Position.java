package com.backend.onlinecvproject.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "positions")
@Data
public class Position {
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="position_name")
    private String positionName;
}
