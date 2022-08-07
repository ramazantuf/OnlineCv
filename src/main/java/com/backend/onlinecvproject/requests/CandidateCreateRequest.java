package com.backend.onlinecvproject.requests;

import lombok.Data;

@Data
public class CandidateCreateRequest {
    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String phoneNumber;
}
