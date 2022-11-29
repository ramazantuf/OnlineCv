package com.backend.onlinecvproject.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="admins")
@Data
public class Admin {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;
}
