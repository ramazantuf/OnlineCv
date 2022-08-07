package com.backend.onlinecvproject.requests;

import com.backend.onlinecvproject.entities.Position;
import lombok.Data;

@Data
public class AdminCreateRequest {
    private String userName;

    private String password;
}
