package com.backend.onlinecvproject.responses;

import com.backend.onlinecvproject.entities.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminViewResponse {
    private int id;
    private String userName;
    private String password;

    public static AdminViewResponse of(Admin admin) {
        return new AdminViewResponse(admin.getId(),admin.getUserName(),admin.getPassword());
    }
}
